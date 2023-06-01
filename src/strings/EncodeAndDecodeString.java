package strings;
import java.util.*;
public class EncodeAndDecodeString{
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        /*
        Seems like to encode, I loop the list of strings and append ':;' after each string to the new string 
        loop until you're at the last stringe in the list 
        if you encounter, a ':' append '::;' after it 

        */
        String encodedStr = "";
        for(int i = 0; i < strs.size() - 1; i++)
        {
            if(!strs.get(i).equals(":"))
            {
                encodedStr += strs.get(i) + ":;";
            }
            else
            {
                encodedStr += strs.get(i) + "::;";
            }
        }
        encodedStr += strs.get(strs.size() - 1);
        return encodedStr;
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        // Init a list of strings 
        // loop str, init an empty string, wehn you encouncter a ":", check if nex charcter is ";" if so append the prev empty string 
        // to list; reempty it, add 1 to i and keep loop ing elase, add ":" to the list and add 2 to i and reempty string agian 
        //need to figure out a way to add last str 

        // this problem shows that we can concatenate chars to a string in java 
        List<String> decodedStrList = new ArrayList<>();

        String emptyStr = "";

        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == ':')
            {
                if(str.charAt(i + 1) == ';')
                {
                    i = i + 1;
                }
                else if(str.charAt(i + 1) == ':')
                {
                    i = i + 3;
                    emptyStr += str.charAt(i);
                }
                decodedStrList.add(emptyStr);
                emptyStr = "";
            }
            else if(i == str.length() - 1)
            {
                emptyStr += str.charAt(i);
                decodedStrList.add(emptyStr);
            }
            else
            {
                emptyStr += str.charAt(i);
            }
        }

        return decodedStrList;
        
    }
}