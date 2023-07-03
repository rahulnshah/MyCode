package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public List<Integer> bfs(int V, List<List<Integer>> adjList){
        List<Integer> traversedNodes = new ArrayList<>();
        boolean [] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        // add starting node to q and mark it as visited; we're assuming that node with value 0 is the starting point here
        visited[0] = true;
        q.add(0);

        while(!q.isEmpty())
        {
            // dequeue first node and add it to traversed and save it to a variable
            // We will use this node as an index and fill up its adjacent nodes from the adjList into our q
            Integer nodeVal = q.poll();
            traversedNodes.add(nodeVal);

            for(Integer adjNode : adjList.get(nodeVal))
            {
                if(!visited[adjNode])
                {
                    visited[adjNode] = true;
                    q.add(adjNode);
                }
            }
        }

        return traversedNodes;
    }
}
