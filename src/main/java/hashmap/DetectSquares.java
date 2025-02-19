package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {
    private Map<String, Integer> points;
    private List<int []> coords;

    public DetectSquares() {
        points = new HashMap<>();
        coords = new ArrayList<>();
    }

    public void add(int[] point) {
        coords.add(point);
        String key = point[0] + "@" + point[1];
        int val = points.getOrDefault(key, 0) + 1;
        points.put(key, val);
    }

    public int count(int[] point) {
        /*
        You need two diagonal points to form a square.
        Approach:
            Loop all points and find the point that is diagonal to the query point.
            initalize a counter to 1.
            Loop all points again and if any of them match with the diagonal point,
            and if you do find a diagonal points in the map, check how many of the top left and
            bottom right points exist and multiply the counts of each together and add it to the res.
        */
        int res = 0;
        int px = point[0], py = point[1];
        for(int [] coord : coords)
        {
            int x = coord[0], y = coord[1];
            if((Math.abs(x - px) != Math.abs(y - py)) || x == px || y == py)
            {
                continue;
            }
            // else we found our diagonal coord
            String key1 = x + "@" + py;
            String key2 = px + "@" + y;
            res += points.getOrDefault(key1, 0) * points.getOrDefault(key2, 0);
        }
        return res;
    }
}
