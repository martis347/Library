package com.library.metaphone;

public class MetaphoneStringHelper {
	
	private static final String VOWELS = "�����aeyuio";

    public static MetaphoneString parse(String originalString)
    {
        String metaphoneString = originalString.substring(0,1);

        String c;
        for(int i = 1; i < originalString.length(); i++)
        {
            c = Character.toString(originalString.charAt(i));
            if(!VOWELS.contains(((c))))
            {
                metaphoneString = metaphoneString.concat(c);
            }
        }

        if(metaphoneString.charAt(metaphoneString.length()-1) == 's')
            metaphoneString = metaphoneString.substring(0, metaphoneString.length()-1);

        return new MetaphoneString(originalString, metaphoneString);
    }

    public static double compareJaroWrinkler(MetaphoneString a, MetaphoneString b){
        String s1 = a.Value;
        String s2 = b.Value;
        if (s1.equals(s2))
            return 1.0;

        // ensure that s1 is shorter than or same length as s2
        if (s1.length() > s2.length()) {
            String tmp = s2;
            s2 = s1;
            s1 = tmp;
        }

        // (1) find the number of characters the two strings have in common.
        // note that matching characters can only be half the length of the
        // longer string apart.
        int maxdist = s2.length() / 2;
        int c = 0; // count of common characters
        int t = 0; // count of transpositions
        int prevpos = -1;
        for (int ix = 0; ix < s1.length(); ix++) {
            char ch = s1.charAt(ix);

            // now try to find it in s2
            for (int ix2 = Math.max(0, ix - maxdist);
                 ix2 < Math.min(s2.length(), ix + maxdist);
                 ix2++) {
                if (ch == s2.charAt(ix2)) {
                    c++; // we found a common character
                    if (prevpos != -1 && ix2 < prevpos)
                        t++; // moved back before earlier
                    prevpos = ix2;
                    break;
                }
            }
        }

        // we might have to give up right here
        if (c == 0)
            return 0.0;

        // first compute the score
        double score = ((c / (double) s1.length()) +
                (c / (double) s2.length()) +
                ((c - t) / (double) c)) / 3.0;

        // (2) common prefix modification
        int p = 0; // length of prefix
        int last = Math.min(4, s1.length());
        for (; p < last && s1.charAt(p) == s2.charAt(p); p++)
            ;

        score = score + ((p * (1 - score)) / 10);

        // (3) longer string adjustment
        // I'm confused about this part. Winkler's original source code includes
        // it, and Yancey's 2005 paper describes it. However, Winkler's list of
        // test cases in his 2006 paper does not include this modification. So
        // is this part of Jaro-Winkler, or is it not? Hard to say.
        //
        //   if (s1.length() >= 5 && // both strings at least 5 characters long
        //       c - p >= 2 && // at least two common characters besides prefix
        //       c - p >= ((s1.length() - p) / 2)) // fairly rich in common chars
        //     {
        //     System.out.println("ADJUSTED!");
        //     score = score + ((1 - score) * ((c - (p + 1)) /
        //                                     ((double) ((s1.length() + s2.length())
        //                                                - (2 * (p - 1))))));
        // }

        // (4) similar characters adjustment
        // the same holds for this as for (3) above.

        return score;
    }

}