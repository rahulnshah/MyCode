package graphs;

import java.util.List;

public class DetectCycleInDirected {
    public boolean search(int nodeVal, boolean [] visited, boolean [] onPath, List<List<Integer>> adjList){
        visited[nodeVal] = true;
        onPath[nodeVal] = true;

        // depth first search all nodes adj to nodeVal
        for(Integer adjNode : adjList.get(nodeVal))
        {
            if(!visited[adjNode])
            {
                if(search(adjNode, visited, onPath, adjList))
                {
                    return true;
                }
            }
            else if(onPath[adjNode]) // adjNode has been visited but what if it also on the current path we have taken, so then return true
            {
                return true;
            }
        }
        // if no cycle found in search or a node has no adjacent nodes, return false, and remove nodeVal from current path
        onPath[nodeVal] = false;
        return false;
    }
    public boolean hasCycle(int V, List<List<Integer>> adjList)
    {
        boolean [] visited = new boolean[V];
        boolean [] onPath = new boolean[V];

        // traversing all nodes by components in the graph, cuz there may be no way to reach a component via dfs from a single starting point
        // in a directed graph
        for(int i = 0; i < visited.length; i++)
        {
            if(!visited[i])
            {
                if(search(i, visited, onPath, adjList)){
                    return true;
                }
            }
        }

        return false;
    }
}
