package math;

public class ColNumToTitle {
    public String convertToTitle(int columnNumber) {
        /*
        Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

        We will be filling column title starting from the end of the string

        to get the last letter of the title, do (number - 1)%26 + 'A' except you'll always get a value between 0 and 25 which is what we want to be able to add to 'A' to avoid using a hashmap

        (index - 1) % n is a techinque to backwards in a circular array, but when number = 0, we have a problem

        then reassign number to (number - 1) / 26 because you want the remainder that you get in the next iteration to be again between [0,25] for the right range of numbers.  for example numbers 27 - 52 represent A_, where is (1 - 1) + 'A' for all numbers except 52 because 52/26 = 2, not 1.  But if we fo (52 - 1) / 26, we get a quotient of 1.

        Keep doing this as long as number > 0, cuz 0 is never a colNumber
    */
        String res = "";
        while(columnNumber > 0)
        {
            int remainder = (columnNumber - 1) % 26;
            res = ((char) ('A' + remainder)) + res;
            columnNumber = (columnNumber - 1) / 26;
        }
        return res;
    }
}
