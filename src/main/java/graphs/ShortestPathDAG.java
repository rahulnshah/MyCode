package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAG {

    /*
    To find the shortest path from st pt to all nodes in a DAG,

    1. Do a TopoSort of the graph from st pt
    2. Take out nodes one by one from Stack and calc the shortest path from st pt to each node.

    Space:
    Time:
     */
    public void TopoSort(int index, boolean [] visited, Stack<Integer> traversed, List<List<int []>> adjList)
    {
        visited[index] = true;

        for(int [] adjNode : adjList.get(index))
        {
            if(!visited[adjNode[0]])
            {
                TopoSort(adjNode[0], visited, traversed, adjList);
            }
        }

        traversed.push(index);
    }
    public int [] shortestPath(int N, int[][] edges)
    {
        List<List<int []>> adjlist = new ArrayList<>();
        for(int i = 0; i < N; i++)
        {
            adjlist.add(new ArrayList<>());
        }

        /* loop edges and fill up adjList with list of {adjNode, weight} */
        for(int [] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adjlist.get(u).add(new int [] {v, wt});
        }

        boolean [] vis = new boolean[N];

        /* Here's where TopoSort comes in play */
        Stack<Integer> traversed = new Stack<>();
        for(int i = 0; i < vis.length; i++)
        {
            if(!vis[i])
            {
                TopoSort(i, vis, traversed, adjlist);
            }
        }

        int [] distance = new int[N];

        /* For now set all shortest distances to inf of int.MAX */
        Arrays.fill(distance, Integer.MAX_VALUE);

        /* shortest distance from starting pt to itself is always 0 */
        distance[0] = 0;

        /* Since we assume our starting point as 0, 0 will be the first node popped */

        while(!traversed.isEmpty())
        {
            int node = traversed.pop();

            for(int i = 0; i < adjlist.get(node).size(); i++) {
                int wt = adjlist.get(node).get(i)[1];
                int v = adjlist.get(node).get(i)[0];
                distance[v] = Math.min(distance[v], wt + distance[node]);
            }
        }
        return distance;
    }
}
