import java.util.*;

public class FindPermutation{

public List<Integer> findPermutation(String s){
  /*
    The problem asks you to reconstruct a lexiographically smallest permutation of numbers in the range [1, n + 1] where n is the length of s, given a pattern of 'D' (for "decreasing") and 'I' (for "increasing") in a string s.

    Approach:
    We will use the stack DS to solve this problem.  We push our cur num starting from 1 when char is 'D' and when char is 'I' we will pop out all numbers from our stack so we can add them in descending (reverse order) in our ans 
    list.  Then we will add the next num on to the stack so it could be popped later if the next char in s is 'I'.  
    Pop remaining numbers from our stack and attach them to the ans list at the end. 
  */
  Stack<Integer> st = new Stack<>();
  List<Integer> ans = new ArrayList<>();
  int curNum = 1;
  // push 1 initially because that will make the permutation lexio smallest
  st.push(curNum);
  for(char c : s.toCharArray()){
    curNum++;
    if(c == 'D'){
      st.push(curNum);
    }
    else{
      // c is 'I'
      // pop all numbers to add them to ans in decreading order
      while(!st.isEmpty()){
        ans.add(st.pop());
      }
      // add the next num to st
      st.push(curNum);
    }
  }
  while(!st.isEmpty()){
        ans.add(st.pop());
  }
  // add remaining to ans
  
  return ans;
}

}
