package eh223im_assign4.time;

import java.util.Arrays;

public class LeSortingAlgorithms {

    public static int[] InsertionSort(int[] in) {
        int[] arr = Arrays.copyOf(in, in.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
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
     * Adopted from: https://stackoverflow.com/questions/1557894/non-recursive-merge-sort
     * Used as an example for time-complexity test
     */

    public static int[] MergeSort(int[] in) {
        int[] a = Arrays.copyOf(in,in.length);
        int[] b = new int[a.length];
        int num = a.length;

        int right, rend;
        int i,j,l;

        for (int k=1; k < num; k *= 2 ) {
            for (int left=0; left+k < num; left += k*2 ) {
                right = left + k;
                rend = right + k;
                if (rend > num) rend = num;
                l = left; i = left; j = right;
                while (i < right && j < rend) {
                    if (a[i] <= a[j]) {
                        b[l] = a[i]; i++;
                    } else {
                        b[l] = a[j]; j++;
                    }
                    l++;
                }
                while (i < right) {
                    b[l]=a[i];
                    i++; l++;
                }
                while (j < rend) {
                    b[l]=a[j];
                    j++; l++;
                }
                for (l=left; l < rend; l++) {
                    a[l] = b[l];
                }
            }
        }

        return b;
    }
}
