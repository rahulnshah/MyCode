package sorting;

import java.util.Arrays;

public class ThreeSorts {

    public static void heapify(int [] A, int arr_len, int root_index)
    {
        // this function is responsible for creating maxheaps
        // in this function, A is the array, arr_len is the lenght of the array, and i refers to the index of the subtree's root
        int largest_element_index = root_index;
        int left_child_index = 2 * root_index + 1;
        int right_child_index = 2 * root_index + 2;


        if(left_child_index < arr_len && A[root_index] < A[left_child_index])
        {
            largest_element_index = left_child_index;
        }

        if(right_child_index < arr_len && A[largest_element_index] < A[right_child_index])
        {
            largest_element_index = right_child_index;
        }

        // if u find that the largest element in the subtree is actually one of the chidren, swap the root with it and call heapify again
        if(largest_element_index != root_index)
        {
            int temp = A[root_index];
            A[root_index] = A[largest_element_index];
            A[largest_element_index] = temp;
            heapify(A, arr_len, largest_element_index);
        }
    }
    public static void heapSnort(int [] A)
    {
        // Get the length of array A
        int arr_len = A.length;

        // Create a maxheap from the array A for the first time
        for(int i = arr_len - 1; i > -1; i--)
        {
            heapify(A, arr_len, i);
        }

        for(int i = arr_len - 1; i > 0; i--)
        {
            // Swap first element (which will be the max) with the current (last element); our window of elements will get shorter
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            heapify(A, i, 0);
        }
    }
    public static void merge(int [] L, int [] R, int [] A)
    {
        int nL = L.length, nR = R.length, i = 0, j = 0, k = 0;
        while(i < nL && j < nR)
        {
            if(L[i] < R[j])
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
    public static void mergeSnort(int [] A)
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
        mergeSnort(L);
        mergeSnort(R);
        merge(L, R, A);
    }

    public static int partition(int [] A, int start, int end)
    {
        int pviot = A[end];
        int pIndex = start;
        for(int i = start; i < end; i++)
        {
            if(A[i] < pviot)
            {
                int temp = A[i];
                A[i] = A[pIndex];
                A[pIndex] = temp;
            }
        }
        int temp = A[pIndex];
        A[pIndex] = A[end];
        A[end] = temp;
        return pIndex;
    }
    public static void quickSnort(int [] A, int start, int end)
    {
        if(start < end)
        {
            int pIndex = partition(A, start, end);
            quickSnort(A, start, pIndex - 1);
            quickSnort(A, pIndex + 1, end);
        }
    }
    public static void main(String[] args) {
        int [] A = {1,11,3,4};
        heapSnort(A);
        System.out.println(Arrays.toString(A));
    }
}
