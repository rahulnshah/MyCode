package trees;

import java.util.List;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> myList)
    {
        // T.C : O(n), where n is total number of integers within the list
        return dfs(myList, 1);
    }
    public int dfs(List<NestedInteger> myList, int depth)
    {
        int total = 0;
        // loop myList and if you come across an integer multiply it by it's depth else
        // you come across a list so make a recursive call again and increment depth
        for(NestedInteger n : myList)
        {
            if(n.isInteger())
            {
                total += n.getInteger() * depth;
            }
            else {
                total += dfs(n.getList(), depth + 1);
            }
        }
        return total;
    }
}
