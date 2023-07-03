package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirected {
    public boolean IsCycle(int V, List<List<Integer>> adjList){
        boolean [] visited = new boolean[V];
        Queue<int []> q = new LinkedList<>();

        // add starting node to q and mark it as visited; we're assuming that node with value 0 is the starting point here
        visited[0] = true;
        int [] temp = {0,-1};
        q.add(temp);

        while(!q.isEmpty())
        {
            // dequeue first node and add it to traversed and save it to a variable
            // We will use this node as an index and fill up its adjacent nodes from the adjList into our q
            int [] pair = q.poll();
            int child = pair[0], parent = pair[1];

            for(Integer adjNode : adjList.get(child))
            {
                if(!visited[adjNode])
                {
                    visited[adjNode] = true;
                    temp = new int[]{adjNode, child};
                    q.add(temp);
                }
                else if(adjNode != parent)
                {
                    return true;
                }
            }
        }

        return false;
    }
}
