package Graphs;

import java.util.ArrayList;
import java.util.List;

public class RecursiveDepthFirstSearch {
    public void search(int nodeVal, boolean [] visited, List<List<Integer>> adjList, List<Integer> traversedNodes){
        visited[nodeVal] = true;
        traversedNodes.add(nodeVal);

        // no adjacent nodes to this node with nodeVal? Then no need to dfs
        if(adjList.get(nodeVal).size() == 0)
        {
            return;
        }
        // depth first search all nodes adj to nodeVal
        for(Integer adjNode : adjList.get(nodeVal))
        {
            if(!visited[adjNode])
            {
                search(adjNode, visited, adjList, traversedNodes);
            }
        }
    }
    public List<Integer> bfs(int V, List<List<Integer>> adjList){
        List<Integer> traversedNodes = new ArrayList<>();
        // we're making length of visited array V because we are assuming there are V 0-indexed nodes
        boolean [] visited = new boolean[V];
        // our starting point is node with val 0
        search(0, visited, adjList, traversedNodes);

        return traversedNodes;
    }
}