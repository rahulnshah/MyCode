package stacks;

import java.util.Stack;

public class MonotonicStack {
    public int[] findBuildings(int[] heights) {
        /*
        Goal is to find all buildings (indices) with an ocean view.
        A building does not have a view if it has a next bigger or equal height building.
        We will mark buildings that have a view with -1 and those that do not with the index of the next large or equal length building
        and then collect all non-negative indices and return them
         */
        Stack<Integer> st = new Stack<>();
        // we do not want to modify heights array
        int [] ans = new int[heights.length];
        int c = 0;
        for(int i = heights.length - 1; i >= 0; i--)
        {
            // while the st is not empty and there are strictly smaller elements than the current element on top, remove them
            while(!st.isEmpty() && heights[st.peek()] < heights[i]) {
                st.pop();
            }
            // if stack is empty, then all the elements below current element were strictly smaller, so there was no building blocking current building so put -1 for it
            if(st.isEmpty())
            {
                ans[i] = -1;
                c++;
            }
            else
            {
                ans[i] = st.peek();
            }
            // push current element's index
            st.push(i);
        }
        int [] res = new int[c];
        int j = 0;
        for(int i = 0; i < ans.length; i++)
        {
            if(ans[i] == -1) {
                res[j] = i;
                j++;
            }
        }
        return res;
    }
}
