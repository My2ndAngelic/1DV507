package eh223im_assign3;

import java.util.Arrays;
import java.util.Comparator;

public class SortingAlgorithms {

    public static int[] insertionSort(int[] in) {
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

    // The
    public int[] mergeSort(int[] in) {
        int[] temp = Arrays.copyOf(in, in.length);

        int j, k, l, m;
        int fi, en, no;

        fi = 0;
        en = in.length - 1;

        for (int i = 0; i < in.length; i *= 2) {

        }

        return temp;
    }         // VG Exercise


    public String[] insertionSort(String[] in, Comparator<String> c) {
        String[] arr = Arrays.copyOf(in, in.length);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (c.compare(arr[j], arr[j - 1]) < 0) {
                    String temp = arr[j];
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
