package graphs;

import java.util.*;

public class ShortestPathInUndirected {
    /*
    We're told to find the shortest path from the starting point to every other node in our undirected graph, given a adjList.
    Assume each edge has a weight of 1
    Assume starting point is 0.

    Approach:
    We will use BFS.
     */
    public int [] shortestPathInUnd(int N, int [][] edges)
    {
        /* Since we're not given a adjList, we have to make one; each edge is a two-way street */
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < N; i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int [] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        /* init a dist array of len N and default distances of INT.MAX */
        int [] dist = new int[N];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;

        /* Start BFS; insert 0 into Queue first */
        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while(!q.isEmpty())
        {
            int node = q.poll();

            for(Integer adjNode : adjList.get(node))
            {
                if(dist[node] + 1 < dist[adjNode])
                {
                    dist[adjNode] = dist[node] + 1;
                    q.add(adjNode);
                }

            }
        }

        /* There could be some unvisited nodes, but we don't care about them here */

        return dist;

    }

}
