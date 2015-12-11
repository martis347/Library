package com.library.metaphone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Metaphone {

	public ArrayList<String> doTheMagic(ArrayList<String> list, String searchWord)
	{
		MetaphoneStringHelper helper = new MetaphoneStringHelper();
		MetaphoneString parsedSearchWord = helper.parse(searchWord);
		HashMap<String, Double> map = new HashMap<String, Double>();
		double length = 0;
				
		for(String listWord : list)
		{
			MetaphoneString parsedListWord = helper.parse(listWord);
			
			length = helper.compare(parsedSearchWord, parsedListWord);
			System.out.println(length+ " = " + listWord);
			map.put(listWord, length);
		}
      
		ArrayList<String> result = new ArrayList<String>();
			

	    Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	    	HashMap.Entry<String, Double> pair = (HashMap.Entry<String, Double>)it.next();
	    	if(pair.getValue() >= 0.9)
			{
				result.add(pair.getKey());
			}
	        
	        it.remove(); // avoids a ConcurrentModificationException
	    }
		
		return result;
	}
}
