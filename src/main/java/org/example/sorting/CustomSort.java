package org.example.sorting;

import java.util.Arrays;

public class CustomSort {
    public String customSortString(String order, String s) {
        /*
        Convert s to an array of characters, but using split("")
        Sort the array like this:
            if the indexof(a in order) == indexOf(b in order)
                return 0
            else if the indexof(a in order) < indexOf(b in order)
                return -1
            else
                return 1

        Reconcatenate the string
        */
        String [] arr = s.split("");

        Arrays.sort(arr, (String a, String b) -> {
            if(order.indexOf(a) == order.indexOf(b))
            {
                return 0;
            }
            else if(order.indexOf(a) > order.indexOf(b))
            {
                return 1;
            }
            else
            {
                return -1;
            }
        });

        String result = "";
        for(String c : arr)
        {
            result += c;
        }
        return result;
    }
}
