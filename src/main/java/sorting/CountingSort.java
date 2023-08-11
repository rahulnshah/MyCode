package sorting;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;

public class CountingSort {

    public static int getNumOfUniqueChars(char arr[])
    {
        // assume the min and max chars are the char at 1st index
        char min = arr[0], max = arr[0];

        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        return (max - min) + 1;
    }
    public static void countSort(char arr[])
    {
        // Find the number of unique characters first in arr to get the length of count
        int [] count = new int[getNumOfUniqueChars(arr)];
        // make a temp arr same length as arr
        char [] temp = new char[arr.length];
        // get the smallest letter
        char smallestLetter = arr[0];

        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] < smallestLetter)
            {
                smallestLetter = arr[i];
            }
        }

        // let count sort begin
        for(int i = 0; i < arr.length; i++)
        {
            count[arr[i] - smallestLetter]++;
        }

        for(int i = 1; i < count.length; i++)
        {
            count[i] = count[i] + count[i - 1];
        }

        for(int i = arr.length - 1; i >= 0; i--)
        {
            temp[--count[arr[i] - smallestLetter]] = arr[i];
        }
        // copy all elements from temp into a
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = temp[i];
        }

    }

    // Driver method
    public static void main(String args[])
    {
        char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's' };

        countSort(arr);
        System.out.println("Ater count sorting: " + Arrays.toString(arr));
    }
}
