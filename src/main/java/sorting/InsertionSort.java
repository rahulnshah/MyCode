package sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static boolean compare(int a, int b, int [] compcount){
        compcount[0] += 1;
        return a > b;
    }
    public static void insertionSort(int [] A, int [] compcount) {
        for(int i = 1; i < A.length; i++)
        {
            int j = i;
            while(j > 0 && compare(A[j - 1], A[j], compcount))
            {
                int temp = A[j - 1];
                A[j - 1] = A[j];
                A[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        // for globally storing the # of key comparisons
        int[] compcount = new int[1];

        Random random = new Random();

        int n = 32, n1 = 100, n2 = 1000, n3 = 10000;
        int [] bestA = new int[n];
        int [] worstA = new int[n];
        int [] randomA = new int[n];
        int [] randomA1 = new int[n1];
        int [] randomA2 = new int[n2];
        int [] randomA3 = new int[n3];

        System.out.println("n = " + n);
        // best case for A - A is sorted prior
        for (int i = 0; i < n; i++) {
            bestA[i] = i;
        }
        System.out.println("bestA: " + Arrays.toString(bestA));
        insertionSort(bestA, compcount);
        System.out.println("Sorted bestA: " + Arrays.toString(bestA));
        System.out.println("key comps: " + compcount[0]);
        compcount[0] = 0;
        // worst case for A - sorted in reverse order
        for (int i = 0; i < n; i++) {
            worstA[i] = n - (i + 1);
        }
        System.out.println("worstA: " + Arrays.toString(worstA));
        insertionSort(worstA, compcount);
        System.out.println("Sorted worstA: " + Arrays.toString(worstA));
        System.out.println("key comps: " + compcount[0]);
        compcount[0] = 0;
        // random case for A
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(n) ; // Generates a random number between 0 and 31 inclusive
            randomA[i] = randomNumber;
        }
        System.out.println("randomA: " + Arrays.toString(randomA));
        insertionSort(randomA, compcount);
        System.out.println("Sorted randomA: " + Arrays.toString(randomA));
        System.out.println("key comps: " + compcount[0]);
        compcount[0] = 0;
        // for A1
        System.out.println("n = " + n1);
        for (int i = 0; i < n1; i++) {
            int randomNumber = random.nextInt(n3) + 1; // Generates a random number between 1 and 10000
            randomA1[i] = randomNumber;
        }
        System.out.println("randomA1: " + Arrays.toString(randomA1));
        insertionSort(randomA1, compcount);
        System.out.println("Sorted randomA1: " + Arrays.toString(randomA1));
        System.out.println("key comps: " + compcount[0]);
        compcount[0] = 0;
        // for A2
        System.out.println("n = " + n2);
        for (int i = 0; i < n2; i++) {
            int randomNumber = random.nextInt(n3) + 1; // Generates a random number between 1 and 10000
            randomA2[i] = randomNumber;
        }
        System.out.println("randomA2: " + Arrays.toString(randomA2));
        insertionSort(randomA2, compcount);
        System.out.println("Sorted randomA2: " + Arrays.toString(randomA2));
        System.out.println("key comps: " + compcount[0]);
        compcount[0] = 0;
        // for A3
        System.out.println("n = " + n3);
        for (int i = 0; i < n3; i++) {
            int randomNumber = random.nextInt(n3) + 1; // Generates a random number between 1 and 10000
            randomA3[i] = randomNumber;
        }
        System.out.println("randomA3: " + Arrays.toString(randomA3));
        insertionSort(randomA3, compcount);
        System.out.println("Sorted randomA3: " + Arrays.toString(randomA3));
        System.out.println("key comps: " + compcount[0]);
    }
}
