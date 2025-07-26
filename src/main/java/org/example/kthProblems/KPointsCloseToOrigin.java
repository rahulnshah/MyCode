package org.example.kthProblems;

import java.util.PriorityQueue;
import java.util.Queue;

public class KPointsCloseToOrigin {
    public int[][] kClosest(int[][] points, int k) {
       /* you're going to order the pairs of points by the priority of their distance to the origin
       Then while k > 0, store the pars one by one in the ret Arr and decrement k

       Space: O(n) where n is the number of points
       Time: klogn where you want to poll k times and a poll ops is logn */

        Queue<int []> pq = new PriorityQueue<int []>((int [] s1, int [] s2) -> {
            int dist1 = (int)(Math.pow(s1[0], 2) + Math.pow(s1[1], 2));
            int dist2 = (int)(Math.pow(s2[0], 2) + Math.pow(s2[1], 2));
            if(dist1 > dist2)
            {
                return 1;
            }
            else if(dist1 < dist2){
                return -1;
            }
            else
            {
                return 0;
            }
        });
        for(int [] point : points)
        {
            pq.offer(point);
        }

        int [][] closePoints = new int [k][2];
        int i = 0;
        while(k > 0)
        {
            closePoints[i] = pq.poll();
            i++;
            k--;
        }
        return closePoints;
    }
}
