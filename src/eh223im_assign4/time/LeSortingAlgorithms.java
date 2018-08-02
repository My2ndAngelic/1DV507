package eh223im_assign4.time;

import java.util.Arrays;

public class LeSortingAlgorithms {

    public static int[] InsertionSort(int[] in) {
        int[] arr = Arrays.copyOf(in, in.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] > arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    /*
     * Textbook (Horstmann) p. 640
     * Used as an example for time-complexity test
     */

    public static int[] MergeSort(int[] in) {
        int[] arr = Arrays.copyOf(in,in.length);
        sort(arr);
        return arr;
    }

    private static void sort(int[] in) {
        if (in.length <= 1) {
            return;
        }
        // Create new array
        int[] first = new int[in.length/2];
        int[] second = new int[in.length - first.length];
        for (int i = 0; i<first.length; i++) {
            first[i] = in[i];
        }
        for (int i = 0; i<second.length; i++) {
            second[i] = in[first.length+i];
        }
        // Split them and sort
        sort(first);
        sort(second);
        merge(first,second,in);
    }

    private static void merge (int[] first, int[] second, int[] in) {
        int iF = 0;
        int iS = 0;
        int j = 0;

        // Merge them and sort
        while (iF < first.length && iS < second.length) {
            if (first[iF] < second[iS]) {
                in[j] = first[iF];
                iF++;
            } else {
                in[j] = second[iS];
                iS++;
            }
            j++;
        }

        // Copy the remainer
        while (iF < first.length) {
            in[j] = first[iF];
            iF++; j++;
        }
        while (iS < second.length) {
            in[j] = second[iS];
            iS++; j++;
        }
    }
}
