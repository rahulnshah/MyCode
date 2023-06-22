import arrays.*;
import java.util.Arrays;
import treemap.HighFive;
import backtracking.Subsets;
import deques.*;
/*
 * First Java Program
 */
public class HelloWorld {
	public static void main(String [] args) {
		System.out.println("Hello world!!!");
		System.out.println("Hello world 2 !!!");
		Chessboard a = new Chessboard();
		a.printChessBoard(4);
		HighFive b = new HighFive();
		int [][] studentsScores = {{1,91}, {1,92}, {2,93}, {2,97}, {1,60}, {2,77}, {1,65}, {1,87}, {1,100}, {2,100}, {2,76}};
		int [][] avgScores = b.highFive(studentsScores);
		for(int [] avgScore : avgScores)
		{
			System.out.println(Arrays.toString(avgScore));
		}

		Subsets i = new Subsets();
		int [] nums = {1,2,3};
		System.out.println(i.subsets(nums));

	}

}
