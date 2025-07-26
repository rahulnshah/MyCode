package org.example.graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public boolean search(int i, boolean[] vis, boolean [] onPath, List<List<Integer>> adjList)
    {
        vis[i] = true;
        onPath[i] = true;

        for(int adjI : adjList.get(i))
        {
            if(!vis[adjI])
            {
                if(search(adjI, vis, onPath, adjList))
                {
                    return true;
                }
            }
            else if(onPath[adjI])
            {
                return true;
            }
        }

        onPath[i] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
        Seems like I need to detect a cycle in a directed graph
        I have the pairs I would find in a adjList, so I don't need to make a graph from scratch

        Make adjList first; assume a directed graph

        Detect a cycle using dfs
        */
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int [] preq : prerequisites)
        {
            adjList.get(preq[1]).add(preq[0]);
        }

        boolean [] vis = new boolean[numCourses];
        boolean [] onPath = new boolean[numCourses];

        for(int i = 0; i < vis.length; i++)
        {
            if(!vis[i])
            {
                // if you find a cycle, then it's bad; cannot finish all courses
                if(search(i, vis, onPath, adjList))
                {
                    return false;
                }
            }
        }

        return true;
    }
}
