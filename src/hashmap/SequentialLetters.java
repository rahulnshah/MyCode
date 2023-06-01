package hashmap;
import java.util.*;
public class SequentialLetters
{
	public static String [] compressString(String [] strs)
	{
		//loop strs, str the freq in a hashmap 
		Map<String, Integer> mp = new HashMap<>();
		String emptyStr = "";

		//only letter freq counted 
		String validLetters = "abcdefghijklmnopqurstuvwxyz";
		for(String str : strs)
		{
		    if(validLetters.contains(str.toLowerCase()))
	            {
			if(!mp.containsKey(str))
			{
				mp.put(str, 1);
			}
			else
			{
				mp.put(str, mp.get(str) + 1);
			}
		   }
			
		}

		//loop the hashmap, attach key:value to an empty string 
		for(String str : mp.keySet())
		{
			emptyStr += str + mp.get(str);
		}
		return emptyStr.split("");
	}
}