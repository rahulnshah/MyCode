package main.sorting;

import java.util.Arrays;

public class ReorderLogs {
    public String[] reorderLogFiles(String[] logs) {
        /*
        We'll solve this problem by passing a comparator in Arrays.sort that tells the sort function how to sort the array. Ids are unique

        log1 > log2 -> 0
        log1 == log2 -> 1
        log1 < log2 -> -1

        If we have a letter log and a digit log, the letter log must come before the digit log
        If we two different letter logs, compare their contents
        If we have two same letter logs, compare their ids
        If we have two digit logs, they stay in the same place

        We will separate the ids and the log contenets first into two separate strings for each log
        */
        Arrays.sort(logs, (String log1, String log2) -> {
            int indexOfFirstSpace1 = log1.indexOf(" ");
            String log1id = log1.substring(0, indexOfFirstSpace1);
            String log1content = log1.substring(indexOfFirstSpace1 + 1);

            int indexOfFirstSpace2 = log2.indexOf(" ");
            String log2id = log2.substring(0, indexOfFirstSpace2);
            String log2content = log2.substring(indexOfFirstSpace2 + 1);

            boolean log1IsDigit = Character.isDigit(log1content.charAt(0));
            boolean log2IsDigit = Character.isDigit(log2content.charAt(0));

            if(log1IsDigit && log2IsDigit)
            {
                return 0; // don't touch the logs leave them in their position
            }
            else if(!log1IsDigit && !log2IsDigit)
            {
                if(log1content.equals(log2content))
                {
                    return log1id.compareTo(log2id);
                }
                return log1content.compareTo(log2content);
            }
            else if(log1IsDigit) // if they are both not digit logs or letter logs, then both of them are different types of logs
            {
                return 1; // becuz digit ogs come after letter logs
            }
            else
            {
                return -1; // becuz letterLogs come before digit logs
            }
        });

        return logs;
    }
}
