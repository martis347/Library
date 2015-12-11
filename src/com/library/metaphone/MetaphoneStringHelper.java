package com.library.metaphone;

public class MetaphoneStringHelper implements IMetaphoneStringHelper {

    private final char[] SKARD_CONSONANTS = {'b','d','g','z','þ'};
    private final char[] DUSL_CONSONANTS = {'p','t','k','s','ð'};

    public MetaphoneString parse(String originalString) {
        String metaphoneString = originalString.substring(0,1);

        for(int i = 1; i < originalString.length()-1; i++) {
            char lc = Character.toLowerCase(originalString.charAt(i));
            char prevLc = Character.toLowerCase(originalString.charAt(i-1));

            //Skip duplicate letters
            if(lc == prevLc) continue;

            switch (lc){
                case 'a':
                    break;
                case 'à':
                    break;
                case 'b':
                    if(charArrayContains(DUSL_CONSONANTS, originalString.charAt(i+1))) {
                        metaphoneString += 'p';
                        break;
                    }
                    metaphoneString += lc;
                    break;
                case 'c':
                    metaphoneString += lc;
                    break;
                case 'è':
                    metaphoneString += lc;
                    break;
                case 'd':
                    if(charArrayContains(DUSL_CONSONANTS, originalString.charAt(i+1))) {
                        metaphoneString += 't';
                        break;
                    }
                    metaphoneString += lc;
                    break;
                case 'e':
                    // ieva -> jva
                    if(i == 1 && prevLc == 'i')
                        metaphoneString = "j";
                    break;
                case 'æ':
                    break;
                case 'ë':
                    break;
                case 'f':
                    metaphoneString += lc;
                    break;
                case 'g':
                    if(charArrayContains(DUSL_CONSONANTS, originalString.charAt(i+1))) {
                        metaphoneString += 'k';
                        break;
                    }
                    metaphoneString += lc;
                    break;
                case 'h':
                    metaphoneString += lc;
                    break;
                case 'i':
                    break;
                case 'á':
                    break;
                case 'y':
                    metaphoneString += lc;
                    break;
                case 'j':
                    metaphoneString += lc;
                    break;
                case 'k':
                    if(charArrayContains(SKARD_CONSONANTS, originalString.charAt(i+1))) {
                        metaphoneString += 'g';
                        break;
                    }
                    metaphoneString += lc;
                    break;
                case 'l':
                    metaphoneString += lc;
                    break;
                case 'm':
                    metaphoneString += lc;
                    break;
                case 'n':
                    metaphoneString += lc;
                    break;
                case 'o':
                    break;
                case 'p':
                    if(charArrayContains(SKARD_CONSONANTS, originalString.charAt(i+1))) {
                        metaphoneString += 'b';
                        break;
                    }
                    metaphoneString += lc;
                    break;
                case 'r':
                    metaphoneString += lc;
                    break;
                case 's':
                    if(charArrayContains(SKARD_CONSONANTS, originalString.charAt(i+1))) {
                        metaphoneString += 'z';
                        break;
                    }
                    metaphoneString += lc;
                    break;
                case 'ð':
                    if(charArrayContains(SKARD_CONSONANTS, originalString.charAt(i+1))) {
                        metaphoneString += 'þ';
                        break;
                    }
                    metaphoneString += lc;
                    break;
                case 't':
                    if(charArrayContains(SKARD_CONSONANTS, originalString.charAt(i+1))) {
                        metaphoneString += 'd';
                        break;
                    }
                    metaphoneString += lc;
                    break;
                case 'u':
                    break;
                case 'ø':
                    break;
                case 'û':
                    break;
                case 'v':
                    metaphoneString += lc;
                    break;
                case 'z':
                    if(charArrayContains(DUSL_CONSONANTS, originalString.charAt(i+1))) {
                        metaphoneString += 's';
                        break;
                    }
                    metaphoneString += lc;
                    break;
                case 'þ':
                    if(charArrayContains(DUSL_CONSONANTS, originalString.charAt(i+1))) {
                        metaphoneString += 'ð';
                        break;
                    }
                    metaphoneString += lc;
                    break;
            }
        }

        //'s' in the end of the word is omitted due to being too common in male gender words
        // TODO: Test whether it actually makes a difference in data
        char c = originalString.charAt(originalString.length()-1);
        if(c != 's') metaphoneString += c;

        return new MetaphoneString(originalString, metaphoneString);
    }

    public double compare(MetaphoneString a, MetaphoneString b){
        MetaphoneString aEnglishized = new MetaphoneString(a.OriginalValue, a.Value);
        aEnglishized.Value = aEnglishized.Value.replace('ð', 's');
        aEnglishized.Value = aEnglishized.Value.replace('è', 'c');
        aEnglishized.Value = aEnglishized.Value.replace('þ', 'z');
        MetaphoneString bEnglishized = new MetaphoneString(b.OriginalValue, b.Value);
        bEnglishized.Value = bEnglishized.Value.replace('ð', 's');
        bEnglishized.Value = bEnglishized.Value.replace('è', 'c');
        bEnglishized.Value = bEnglishized.Value.replace('þ', 'z');

        double originalJaro = compareJaroWrinkler(a, b);
        double englishizedJaro = compareJaroWrinkler(aEnglishized, bEnglishized);

        if(englishizedJaro > originalJaro) return englishizedJaro;
        else return originalJaro;

    }

    private boolean charArrayContains(char array[], char comparedItem){
        for(char arrayItem : array){
            if(arrayItem == comparedItem){
                return true;
            }
        }
        return false;
    }

    private double compareJaroWrinkler(MetaphoneString a, MetaphoneString b) {
        String s1 = a.Value.toLowerCase();
        String s2 = b.Value.toLowerCase();
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

        return score;
    }
}