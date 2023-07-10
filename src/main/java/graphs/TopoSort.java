package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoSort {
    public void search(int index, boolean [] visited, Stack<Integer> traversed, List<List<Integer>> adjList)
    {
        visited[index] = true;

        for(Integer adjNode : adjList.get(index))
        {
            if(!visited[adjNode])
            {
                search(adjNode, visited, traversed, adjList);
            }
        }

        traversed.push(index);
    }

    public List<Integer> topologicalSort(int V, List<List<Integer>> adjList)
    {
        boolean [] visited = new boolean[V];

        Stack<Integer> traversed = new Stack<>();

        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            {
                search(i, visited, traversed, adjList);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!traversed.isEmpty())
        {
            ans.add(traversed.pop());
        }

        return ans;
    }
}
