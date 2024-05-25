package sorting;

import java.util.Arrays;
import java.util.Random;

public class ThreeSorts {

    public static boolean smaller(int a, int b, int [] pointer){
        pointer[0] += 1;
        return a < b;
    }
    public static void heapify(int [] A, int arr_len, int root_index, int [] pointer)
    {
        // this function is responsible for creating maxheaps
        // in this function, A is the array, arr_len is the lenght of the array, and i refers to the index of the subtree's root
        int largest_element_index = root_index;
        int left_child_index = 2 * root_index + 1;
        int right_child_index = 2 * root_index + 2;


        if(left_child_index < arr_len && smaller(A[root_index], A[left_child_index], pointer))
        {
            largest_element_index = left_child_index;
        }

        if(right_child_index < arr_len && smaller(A[largest_element_index], A[right_child_index], pointer))
        {
            largest_element_index = right_child_index;
        }

        // if u find that the largest element in the subtree is actually one of the chidren, swap the root with it and call heapify again
        if(largest_element_index != root_index)
        {
            int temp = A[root_index];
            A[root_index] = A[largest_element_index];
            A[largest_element_index] = temp;
            heapify(A, arr_len, largest_element_index, pointer);
        }
    }
    public static void heapSort(int [] A, int [] pointer)
    {
        // Get the length of array A
        int arr_len = A.length;

        // Create a maxheap from the array A for the first time
        for(int i = arr_len - 1; i > -1; i--)
        {
            heapify(A, arr_len, i, pointer);
        }

        for(int i = arr_len - 1; i > 0; i--)
        {
            // Swap first element (which will be the max) with the current (last element); our window of elements will get shorter
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            heapify(A, i, 0, pointer);
        }
    }
    public static void merge(int [] L, int [] R, int [] A, int [] pointer)
    {
        int nL = L.length, nR = R.length, i = 0, j = 0, k = 0;
        while(i < nL && j < nR)
        {
            if(smaller(L[i], R[j], pointer))
            {
                A[k] = L[i];
                i++;
            }
            else
            {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < nL)
        {
            A[k] = L[i];
            i++;
            k++;
        }
        while(j < nR)
        {
            A[k] = R[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int [] A, int [] pointer)
    {
        int n = A.length;
        if(n < 2)
        {
            return;
        }
        int mid = n / 2;
        int nL = mid;
        int nR = n - mid;
        int [] L = new int[nL];
        int [] R = new int[nR];
        for(int i = 0; i < mid; i++)
        {
            L[i] = A[i];
        }
        for(int i = 0; i < R.length; i++)
        {
            R[i] = A[mid];
            mid++;
        }
        mergeSort(L, pointer);
        mergeSort(R, pointer);
        merge(L, R, A, pointer);
    }

    public static int partition(int [] A, int start, int end, int [] pointer)
    {
        int pviot = A[end];
        int pIndex = start;
        for(int i = pIndex; i < end; i++)
        {
            if(smaller(A[i], pviot, pointer))
            {
                int temp = A[i];
                A[i] = A[pIndex];
                A[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = A[pIndex];
        A[pIndex] = A[end];
        A[end] = temp;
        return pIndex;
    }
    public static void quickSort(int [] A, int start, int end, int [] pointer)
    {
        if(start < end)
        {
            int pIndex = partition(A, start, end, pointer);
            quickSort(A, start, pIndex - 1, pointer);
            quickSort(A, pIndex + 1, end, pointer);
        }
    }
    public static void main(String[] args) {
        int [] pointer = new int[1];
        Random random = new Random();
        int n = 32, n1 = 1024, n2 = 32768, n3 =  1048576;

        // Save these for all 3 algos
        int [] bestMerge = new int[n];
        int [] worstMerge = new int[n];
        int [] randomMerge = new int[n];
        int [] bestHeap;
        int [] worstHeap;
        int [] randomHeap;
        int [] bestQuick;
        int [] worstQuick;
        int [] randomQuick;

        int [] randomMergeN1 = new int[n1];
        int [] randomMergeN2 = new int[n2];
        int [] randomMergeN3 = new int[n3];
        int [] randomHeapN1;
        int [] randomHeapN2;
        int [] randomHeapN3;
        int [] randomQuickN1;
        int [] randomQuickN2;
        int [] randomQuickN3;

        // best case for A - A is sorted prior
        for (int i = 0; i < n; i++) {
            bestMerge[i] = i;
        }
        // worst case for A - sorted in reverse order
        for (int i = 0; i < n; i++) {
            worstMerge[i] = n - (i + 1);
        }
        // random case for A
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(n) ; // Generates a random number between 0 and 31
            randomMerge[i] = randomNumber;
        }

        // for merge sort
        for (int i = 0; i < n1; i++) {
            int randomNumber = random.nextInt(n3) + 1; // Generates a random number between 1 and 1048576
            randomMergeN1[i] = randomNumber;
        }

        for (int i = 0; i < n2; i++) {
            int randomNumber = random.nextInt(n3) + 1; // Generates a random number between 1 and 1048576
            randomMergeN2[i] = randomNumber;
        }

        for (int i = 0; i < n3; i++) {
            int randomNumber = random.nextInt(n3) + 1; // Generates a random number between 1 and 1048576
            randomMergeN3[i] = randomNumber;
        }

        // fill up other arrays of n = 32
        bestHeap = Arrays.copyOf(bestMerge, n);
        worstHeap = Arrays.copyOf(worstMerge, n);
        randomHeap = Arrays.copyOf(randomMerge, n);
        bestQuick = Arrays.copyOf(bestMerge, n);
        worstQuick = Arrays.copyOf(worstMerge, n);
        randomQuick = Arrays.copyOf(randomMerge, n);

        // fill up the rest
        randomHeapN1 = Arrays.copyOf(randomMergeN1, n1);
        randomHeapN2 = Arrays.copyOf(randomMergeN2, n2);
        randomHeapN3 = Arrays.copyOf(randomMergeN3, n3);
        randomQuickN1 = Arrays.copyOf(randomMergeN1, n1);
        randomQuickN2 = Arrays.copyOf(randomMergeN2, n2);
        randomQuickN3 = Arrays.copyOf(randomMergeN3, n3);

        // run the sorts on arrays of n = 32
        System.out.println("bestMerge: " + Arrays.toString(bestMerge));
        long s = System.currentTimeMillis();
        mergeSort(bestMerge, pointer);
        long e = System.currentTimeMillis();
        System.out.println("clock time: " + (e - s) + " ms");
        System.out.println("Sorted bestA: " + Arrays.toString(bestMerge));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        System.out.println("worstMerge: " + Arrays.toString(worstMerge));
        s = System.currentTimeMillis();
        mergeSort(worstMerge, pointer);
        e = System.currentTimeMillis();
        System.out.println("clock time: " + (e - s) + " ms");
        System.out.println("Sorted worstMerge: " + Arrays.toString(worstMerge));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        System.out.println("randomMerge: " + Arrays.toString(randomMerge));
        s = System.currentTimeMillis();
        mergeSort(randomMerge, pointer);
        e = System.currentTimeMillis();
        System.out.println("clock time: " + (e - s) + " ms");
        System.out.println("Sorted randomMerge: " + Arrays.toString(randomMerge));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        System.out.println("bestHeap: " + Arrays.toString(bestHeap));
        s = System.currentTimeMillis();
        heapSort(bestHeap, pointer);
        e = System.currentTimeMillis();
        System.out.println("clock time: " + (e - s) + " ms");
        System.out.println("Sorted bestHeap: " + Arrays.toString(bestHeap));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        System.out.println("worstHeap: " + Arrays.toString(worstHeap));
        s = System.currentTimeMillis();
        heapSort(worstHeap, pointer);
        e = System.currentTimeMillis();
        System.out.println("clock time: " + (e - s) + " ms");
        System.out.println("Sorted worstHeap: " + Arrays.toString(worstHeap));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        System.out.println("randomHeap: " + Arrays.toString(randomHeap));
        s = System.currentTimeMillis();
        heapSort(randomHeap, pointer);
        e = System.currentTimeMillis();
        System.out.println("clock time: " + (e - s) + " ms");
        System.out.println("Sorted randomHeap: " + Arrays.toString(randomHeap));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        System.out.println("bestQuick: " + Arrays.toString(bestQuick));
        s = System.currentTimeMillis();
        quickSort(bestQuick, 0, n - 1, pointer);
        e = System.currentTimeMillis();
        System.out.println("clock time: " + (e - s) + " ms");
        System.out.println("Sorted bestQuick: " + Arrays.toString(bestQuick));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        System.out.println("worstQuick: " + Arrays.toString(worstQuick));
        s = System.currentTimeMillis();
        quickSort(worstQuick,  0, n - 1, pointer);
        e = System.currentTimeMillis();
        System.out.println("clock time: " + (e - s) + " ms");
        System.out.println("Sorted worstQuick: " + Arrays.toString(worstQuick));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        System.out.println("randomQuick: " + Arrays.toString(randomQuick));
        s = System.currentTimeMillis();
        quickSort(randomQuick,  0, n - 1, pointer);
        e = System.currentTimeMillis();
        System.out.println("clock time: " + (e - s) + " ms");
        System.out.println("Sorted randomQuick: " + Arrays.toString(randomQuick));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        // run the sorts on arrays of n1, n2, n3
        // System.out.println("randomMergeN1: " + Arrays.toString(randomMergeN1));
        s = System.currentTimeMillis();
        mergeSort(randomMergeN1, pointer);
        e = System.currentTimeMillis();
        System.out.println("randomMergeN1 clock time: " + (e - s) + " ms");
        // System.out.println("Sorted randomMergeN1: " + Arrays.toString(randomMergeN1));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        // System.out.println("randomMergeN2: " + Arrays.toString(randomMergeN2));
        s = System.currentTimeMillis();
        mergeSort(randomMergeN2, pointer);
        e = System.currentTimeMillis();
        System.out.println("randomMergeN2 clock time: " + (e - s) + " ms");
        // System.out.println("Sorted randomMergeN2: " + Arrays.toString(randomMergeN2));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        // System.out.println("randomMergeN3: " + Arrays.toString(randomMergeN3));
        s = System.currentTimeMillis();
        mergeSort(randomMergeN3, pointer);
        e = System.currentTimeMillis();
        System.out.println("randomMergeN3 clock time: " + (e - s) + " ms");
        // System.out.println("Sorted randomMergeN3: " + Arrays.toString(randomMergeN3));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        // System.out.println("randomHeapN1: " + Arrays.toString(randomHeapN1));
        s = System.currentTimeMillis();
        heapSort(randomHeapN1, pointer);
        e = System.currentTimeMillis();
        System.out.println("randomHeapN1 clock time: " + (e - s) + " ms");
        // System.out.println("Sorted randomHeapN1: " + Arrays.toString(randomHeapN1));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        // System.out.println("randomHeapN2: " + Arrays.toString(randomHeapN2));
        s = System.currentTimeMillis();
        heapSort(randomHeapN2, pointer);
        e = System.currentTimeMillis();
        System.out.println("randomHeapN2 clock time: " + (e - s) + " ms");
        // System.out.println("Sorted randomHeapN2: " + Arrays.toString(randomHeapN2));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        // System.out.println("randomHeapN3: " + Arrays.toString(randomHeapN3));
        s = System.currentTimeMillis();
        heapSort(randomHeapN3, pointer);
        e = System.currentTimeMillis();
        System.out.println("randomHeapN3 clock time: " + (e - s) + " ms");
        // System.out.println("Sorted randomHeapN3: " + Arrays.toString(randomHeapN3));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        // System.out.println("randomQuickN1: " + Arrays.toString(randomQuickN1));
        s = System.currentTimeMillis();
        quickSort(randomQuickN1, 0, n1 - 1, pointer);
        e = System.currentTimeMillis();
        System.out.println("randomQuickN1 clock time: " + (e - s) + " ms");
        // System.out.println("Sorted randomQuickN1: " + Arrays.toString(randomQuickN1));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        // System.out.println("randomQuickN2: " + Arrays.toString(randomQuickN2));
        s = System.currentTimeMillis();
        quickSort(randomQuickN2, 0, n2 - 1, pointer);
        e = System.currentTimeMillis();
        System.out.println("randomQuickN2 clock time: " + (e - s) + " ms");
        // System.out.println("Sorted randomQuickN2: " + Arrays.toString(randomQuickN2));
        System.out.println("key comps: " + pointer[0]);
        pointer[0] = 0;

        // System.out.println("randomQuickN3: " + Arrays.toString(randomQuickN3));
        s = System.currentTimeMillis();
        quickSort(randomQuickN3, 0, n3 - 1, pointer);
        e = System.currentTimeMillis();
        System.out.println("randomQuickN3 clock time: " + (e - s) + " ms");
        // System.out.println("Sorted randomQuickN3: " + Arrays.toString(randomQuickN3));
        System.out.println("key comps: " + pointer[0]);
    }
}
