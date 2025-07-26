package org.example.stacks;
import java.util.Stack;
public class RemAllDupAdjInString {
	public String reverse(String s)
    {
        String retStr = "";
        for(int i = s.length() - 1; i >= 0; i--)
        {
            retStr += s.charAt(i);
        }
        return retStr;
    }
    public String removeDuplicates(String s) {
        /*
            We can make use of stack.  Read a char, push it in if stack is empty.  If stack is not empty then get the topmost letter on the stack and see if it matchd with the one u read, if it does pop it.  Keep doing this until u finish reading the string.  Have an empty final str initialized, pop all chars and append them to the empty str and revers the string.  
         */
        Stack<Character> ns = new Stack<>();
        String fullStr = "";
        for(int i = 0; i < s.length(); i++)
        {
            if(ns.isEmpty())
            {
                ns.push(s.charAt(i));
            }
            else
            {
                if(s.charAt(i) == ns.peek())
                {
                    ns.pop();
                }
                else
                {
                    ns.push(s.charAt(i));
                }
            }
        }

        while(!ns.isEmpty())
        {
            fullStr += ns.pop();
        }

        return reverse(fullStr);
    }
}
