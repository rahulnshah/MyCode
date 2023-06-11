package stacks;
import java.util.Stack;
public class RemAdjDeupII {
	public String reverse(String s)
    {
        String retStr = "";
        for(int i = s.length() - 1; i >= 0; i--)
        {
            retStr += s.charAt(i);
        }
        return retStr;
    }
    public String removeDuplicates(String s, int k) {
        /*
        Read eah letter in s, and push each letter in s  and it frequesy in n.
        We know s.length() >= 1 
        When we encounter a new letter in s, we push the freq of that letter into n
        and set the freq to 0.
        In every iteration, check if the counter has reach the value of k, if it has, no need to push that freq in n.  Then while(counter != 0){s.pop()}

        Afte finishing loop, make a new string from the stack and reverse it and return the remaining string
        */
        Stack<Character> strStack = new Stack<>();
        Stack<Integer> ns = new Stack<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char currentLetter = s.charAt(i);

            if(ns.isEmpty())
            {
                ns.push(1);
                strStack.push(currentLetter);
            }
            else
            {
                if(currentLetter == strStack.peek())
                {
                    ns.push(ns.pop() + 1);
                    strStack.push(currentLetter);
                }
                else
                {
                    ns.push(1);
                    strStack.push(currentLetter);
                }
            }
            if(ns.peek() == k)
            {
                int freq = ns.pop();
                while(freq != 0)
                {
                    strStack.pop();
                    freq--;
                }
            }
        }

        String ans = "";
        while(!strStack.isEmpty())
        {
            ans += strStack.pop();
        }
        return reverse(ans);
    }
}
