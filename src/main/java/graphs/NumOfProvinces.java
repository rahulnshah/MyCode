package graphs;

import java.util.ArrayList;
import java.util.List;

public class NumOfProvinces {
    public void bfs(int index, List<List<Integer>> adjList, boolean [] visited)
    {
        // add the starting point first to q, then while q is not empty, remove it, and loop all its neighbors and if they have not been visited, add them to the q and mark them visited
        List<Integer> q = new ArrayList<>();
        q.add(index);
        visited[index] = true;

        while(q.size() > 0)
        {
            int visitedInd = q.remove(0);
            for(Integer i : adjList.get(visitedInd))
            {
                if(!visited[i])
                {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        /*
        This problem is basically asking us to find the number of connected components

        We can use either bfs/dfs to traverse a whole component; and each connected component will have
        a different starting point. A node that has not been visited from previous traversal, will become the starting point for its component.  We can keep a counter to increment whenever we find a node that has not been visited.

        Approach:
            Convert adjMatrix isConnected into a adjList; skip when i == j because for simplicity we assume a vertex can't be connected to itself
            Loop visited array from 1 to n and when visited[i] == false, run bfs on i

        Time:
        Space:
        */
        List<List<Integer>> adjList = new ArrayList<>();
        // Fill up arraylist with empty buckets just like u did in Top K freq elements problem
        for(int i = 0; i < isConnected.length + 1; i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < isConnected.length; i++)
        {
            for(int j = 0; j < isConnected[i].length; j++)
            {
                if(j != i && isConnected[i][j] == 1)
                {
                    // add j + 1 to i + 1's List
                    adjList.get(i + 1).add(j + 1);
                }
            }
        }
        // we are given n vertices so the length of the visited array will be n + 1; indexed from 0 to n
        boolean [] visited = new boolean[isConnected.length + 1];

        int count = 0;

        for(int i = 1; i < visited.length; i++)
        {
            if(!visited[i])
            {
                bfs(i, adjList, visited);
                count++;
            }
        }
        return count;
    }
}
