package arrays;

public class LeftMostColumnsWithOne {
    public int leftMostWithOne(int [][] binMatrix)
    {
        /*
        Approach: Notice how the input is always given like this:
        [0, 0, 0, 1],
        [0, 0, 1, 1],
        [0, 1, 1, 1]
        We almost see a staircase of 1's
        Start from the top-right corner of the matrix.
        If the current element is 1, move left to see if there are any more 1s to the left in the current row. Update the leftmost variable accordingly.
        If the current element is 0, move down to the next row.
        Repeat this until either you find the leftmost 1 or exhaust all rows and columns.
         */

        int n = binMatrix.length, m = binMatrix[0].length;

        int leftMost = -1;

        int r = 0, c = n - 1;

        while(r < n && c >= 0)
        {
            if(binMatrix[r][c] == 1)
            {
                // look more the left
                leftMost = c;
                c--;
            }
            else
            {
                // else you saw a 0 so jump down 1 row
                r++;

            }
        }

        return leftMost;
    }
}
