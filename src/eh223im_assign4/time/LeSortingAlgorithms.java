package eh223im_assign4.time;

import java.util.Arrays;

public class LeSortingAlgorithms { // Sorting: ascending
    public static int[] insertionIntSort(int[] in) {
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

    //Textbook (Horstmann) p. 64, used as an example for time-complexity test
    public static int[] mergeIntSort(int[] in) {
        int[] arr = Arrays.copyOf(in, in.length);
        int_mergeSplit(arr);
        return arr;
    }

    private static void int_mergeSplit(int[] in) {
        if (in.length <= 1) {
            return;
        }
        // Create new array
        int[] first = new int[in.length / 2];
        int[] second = new int[in.length - first.length];
        for (int i = 0; i < first.length; i++) {
            first[i] = in[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = in[first.length + i];
        }
        // Split them and int_mergeSplit
        int_mergeSplit(first);
        int_mergeSplit(second);
        int_mergeCompare(first, second, in);
    }

    private static void int_mergeCompare(int[] first, int[] second, int[] in) {
        int iF = 0;
        int iS = 0;
        int j = 0;
        // Merge them and int_mergeSplit
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
            iF++;
            j++;
        }
        while (iS < second.length) {
            in[j] = second[iS];
            iS++;
            j++;
        }
    }

    // String sorting: case insensitive
    public static String[] insertionStringSort(String[] in) {
        String[] arr = Arrays.copyOf(in, in.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if ((arr[j].toUpperCase()).compareTo(arr[j - 1].toUpperCase()) < 0) {
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

    public static String[] mergeStringSort(String[] in) {
        String[] arr = Arrays.copyOf(in, in.length);
        string_mergeSplit(arr);
        return arr;
    }

    private static void string_mergeSplit(String[] in) {
        if (in.length <= 1) {
            return;
        }
        // Create new array
        String[] first = new String[in.length / 2];
        String[] second = new String[in.length - first.length];
        for (int i = 0; i < first.length; i++) {
            first[i] = in[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = in[first.length + i];
        }
        // Split them and int_mergeSplit
        string_mergeSplit(first);
        string_mergeSplit(second);
        string_mergeCompare(first, second, in);
    }

    private static void string_mergeCompare(String[] first, String[] second, String[] in) {
        int iF = 0;
        int iS = 0;
        int j = 0;
        // Merge them and int_mergeSplit
        while (iF < first.length && iS < second.length) {
            if (first[iF].toUpperCase().compareTo(second[iS].toUpperCase()) < 0) {
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
            iF++;
            j++;
        }
        while (iS < second.length) {
            in[j] = second[iS];
            iS++;
            j++;
        }
    }
}
