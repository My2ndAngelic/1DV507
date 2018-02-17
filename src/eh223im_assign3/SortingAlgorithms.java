package eh223im_assign3;

import java.util.Arrays;
import java.util.Comparator;

public class SortingAlgorithms {

    static int[] insertionSort(int[] in) {
        int[] arr = Arrays.copyOf(in, in.length);
        // Wikipedia pseudo-code rewrite
        // https://en.wikipedia.org/wiki/Insertion_sort
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    static int[] mergesort (int[] arr) {
        return arr;
    }

    // The
    public static int[] mergeSort(int[] in) {
        int[] temp = Arrays.copyOf(in, in.length);

        return temp;
    }         // VG Exercise



    public int[] mergeSortSplit(int[] inA, int[] inB) {
        return new int[0];
    }

    public int[] mergeSortMerge() {
        return new int[0];
    }


    public static Object[] insertionSort(Object[] in, Comparator c) {
        Object[] arr = Arrays.copyOf(in, in.length);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (c.compare(arr[j], arr[j - 1]) < 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    public String[] mergeSort(String[] in, Comparator <String> c) {
        return null;
    }  // VG Exercise
}
