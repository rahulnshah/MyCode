package arrays;

import java.util.ArrayList;
import java.util.List;

public class MovingAverage {

    List<Integer> window;
    int n;
    double sum;
    public MovingAverage(int n)
    {
        this.window = new ArrayList<>();
        this.n = n;
        this.sum = 0.0;
    }

    public double next(int num)
    {
        if(window.size() == this.n)
        {
            sum -= window.get(0);
            window.remove(0);
        }
        window.add(num);
        sum += num;
        return sum / window.size();
    }
}
