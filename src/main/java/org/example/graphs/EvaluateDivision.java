package org.example.graphs;

import java.util.*;

public class EvaluateDivision {
    public double bfs(String src, String target, Map<String, List<List<Object>>> adj)
    {
        if(!adj.containsKey(src) || !adj.containsKey(target))
        {
            return -1.0;
        }

        Set<String> visited = new HashSet<>();
        Queue<List<Object>> q = new LinkedList<>();


        visited.add(src);
        q.add(Arrays.asList(src, 1.0));

        while(!q.isEmpty())
        {
            // dequeue first node and add it to traversed and save it to a variable
            // We will use this node as an index and fill up its adjacent nodes from the adjList into our q
            List<Object> node = q.poll();
            String nodeVal = (String) node.get(0);
            double w = (Double) node.get(1);

            // If you found the target return the accumalated weight or in this case, our quotient
            if(target.equals(nodeVal))
            {
                return w;
            }

            for(List<Object> adjNode: adj.get(nodeVal))
            {
                nodeVal = (String) adjNode.get(0);
                double weight = (Double) adjNode.get(1);
                if(!visited.contains(nodeVal))
                {
                    visited.add(nodeVal);
                    q.add(Arrays.asList(nodeVal, w * weight));
                }
            }
        }

        return -1.0;
    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /*
        This problem is like find if path exists from src to destination.
        To find such a path just do dfs or bfs from src to target.

        In queries, we're given a bunch of lists like [numerator, denominator] so we will make an bi-directional adj list first
        and see then perform bfs on each of those queries to return a / b where a / b answers does a path from a to b exist? if so return the products of it, else return -1.
        */

        Map<String, List<List<Object>>> adj = new HashMap<>();
        for(int i = 0; i < values.length; i++)
        {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            // add empty buckets for each a and b
            if(!adj.containsKey(a))
            {
                adj.put(a, new ArrayList<>());
            }
            if(!adj.containsKey(b))
            {
                adj.put(b, new ArrayList<>());
            }

        }

        for(int i = 0; i < values.length; i++)
        {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            // add empty buckets for each a and b
            adj.get(a).add(Arrays.asList(b, values[i]));
            adj.get(b).add(Arrays.asList(a, 1.0 / values[i]));
        }

        double [] res = new double[queries.size()];

        for(int i = 0; i < res.length; i++)
        {
            res[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), adj);
        }

        return res;

    }
}
