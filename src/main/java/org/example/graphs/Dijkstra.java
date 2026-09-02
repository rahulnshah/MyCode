package org.example.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    public List<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        /*
        Turn the edges into an adj list first mapping the
        node -> {adjNode, weight}
        for ex: [0,1,1] -> 0 : [1,1] , 1: [0, 1]

        to do this loop edges, and for each edge do
        edges.get(u).add(new ArrayList<>(edges.get(v), edges.get(w)))

        Dijkstra's algorithm: allows you to find the shortest distance from
        src node to all nodes; does not work with negative weights (causes infinite loop)

        Mai
        */

        List<List<List<Integer>>> adjList = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adjList.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(Arrays.asList(v, w));
            adjList.get(v).add(Arrays.asList(u, w));
        }

        // default shortest distance will be int.MAX
        List<Integer> dist = new ArrayList<>(V);

        for(int i = 0; i < V; i++){
            dist.add(i, Integer.MAX_VALUE);
        }
        // init a priority queue that will store in min heap {dist from src, traversable node}
        PriorityQueue<int []> q = new PriorityQueue<>((int [] x, int [] y) -> x[0] - y[0]);
        // dist from src to src is always 0
        dist.set(src, 0);
        // add src to q
        q.add(new int[]{0, src});

        while(!q.isEmpty()){
            // pop it
            int distFromSrc = q.peek()[0];
            int node = q.peek()[1];
            q.remove();

            // Skip stale entry
            if (distFromSrc > dist.get(node)) {
                continue;
            }

            // set the shortest dist for all adj nodes of currNode
            for(int i = 0; i < adjList.get(node).size(); i++){
                int edgeWeight = adjList.get(node).get(i).get(1);
                int adjNode =  adjList.get(node).get(i).get(0);

                if((distFromSrc + edgeWeight) < dist.get(adjNode)){
                    dist.set(adjNode, (distFromSrc + edgeWeight));
                    q.add(new int [] {dist.get(adjNode), adjNode});
                }
            }
        }

        return dist;

    }
}
