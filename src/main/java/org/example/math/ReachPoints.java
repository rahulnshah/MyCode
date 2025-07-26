package org.example.math;

public class ReachPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        /*
        Intution:
Keep subtracting the smaller of (tx, ty) from the larger of (tx, ty) and stop if tx becomes less than sx OR ty becomes less than sy.

        Why not start from sx and sy and go upto tx and ty.
        - Ans: Try it out, only to reach TLE since there are multiple paths to try if you start from sx and sy and only one if you go from tx and ty to sx and sy.
        Why % instead of subtraction:
        - Ans: Instead of doing tx = tx - ty OR ty = ty - tx we can do tx = tx % ty OR ty = ty % tx. Using % does the same thing but reduces multiple operations to a single one.

        */
        while(tx >= sx && ty >= sy)
        {
            if(tx > ty)
            {
                if(sy == ty)
                {
                    // since source y = target y, we only need to change their x's, so we have to see if we can get to source x from target x, by subtraticng ty from tx n number of times (aka the following expression)
                    return (tx - sx) % ty == 0;
                }
                tx %= ty;
            }
            else
            {
                // tx <= ty, if ty > tx, then we need to subtract tx from ty
                // if ty = tx, fine we can have smthing like target: (5,5)
                // if sx = tx, then only their y's need to change
                if(sx == tx)
                {
                    return (ty - sy) % tx == 0;
                }
                ty %= tx;
            }
        }
        return false;
    }
}
