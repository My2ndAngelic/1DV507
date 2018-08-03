package eh223im_assign4.time.new_time;

import eh223im_assign4.TestKit;
import eh223im_assign4.time.LeSortingAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class SortingTest {
    public static long MergeTest(int[] initArr) {
        long time;

        int[] sortingArr = Arrays.copyOf(initArr, initArr.length);

        System.gc();
        long t1 = System.nanoTime();
        sortingArr = LeSortingAlgorithms.mergeIntSort(sortingArr);
        long t2 = System.nanoTime();
        time = t2 - t1;

        int[] checkArr = Arrays.copyOf(sortingArr, sortingArr.length);
        Arrays.sort(checkArr);

        if (Arrays.equals(sortingArr, checkArr)) {
            return time;
        } else {
            throw new RuntimeException("Sorting Error");
        }
    }

    public static long InsertionTest(int[] initArr) {
        long time;

        int[] sortingArr = Arrays.copyOf(initArr, initArr.length);

        System.gc();
        long t1 = System.nanoTime();
        sortingArr = LeSortingAlgorithms.insertionIntSort(sortingArr);
        long t2 = System.nanoTime();
        time = t2 - t1;

        int[] checkArr = Arrays.copyOf(sortingArr, sortingArr.length);
        Arrays.sort(checkArr);

        if (Arrays.equals(sortingArr, checkArr)) {
            return time;
        } else {
            throw new RuntimeException("Sorting Error");
        }
    }

    public static long InsertionTest(String[] initArr) {
        long time;

        String[] sortingArr = Arrays.copyOf(initArr, initArr.length);

        System.gc();
        long t1 = System.nanoTime();
        sortingArr = LeSortingAlgorithms.insertionStringSort(sortingArr);
        long t2 = System.nanoTime();
        time = (t2 - t1);

        String[] checkArr = Arrays.copyOf(sortingArr, sortingArr.length);
        Arrays.sort(checkArr, Comparator.comparing(String::toUpperCase));

        if (Arrays.equals(sortingArr, checkArr)) {
            return time;
        } else {
            throw new RuntimeException("Sorting Error");
        }
    }

    public static long MergeTest(String[] initArr) {
        long time;

        String[] sortingArr = Arrays.copyOf(initArr, initArr.length);

        System.gc();
        long t1 = System.nanoTime();
        sortingArr = LeSortingAlgorithms.mergeStringSort(sortingArr);
        long t2 = System.nanoTime();
        time = (t2 - t1);

        String[] checkArr = Arrays.copyOf(sortingArr, sortingArr.length);
        Arrays.sort(checkArr, Comparator.comparing(String::toUpperCase));

        if (Arrays.equals(sortingArr, checkArr)) {
            return time;
        } else {
            throw new RuntimeException("Sorting Error");
        }
    }

    public static void main(String[] args) {
        for (int l = 0; l < 5; l++) {
            double k = 0;
            int i = 0;
            while (k < 1) {
                String[] a = TestKit.stringsGenerator(new String[i], 1, 10);
                k = InsertionTest(a) / 1E9;
                i += 100;
                System.out.println("Insertion;String;" + i + ";" + k);
            }
        }

        for (int l = 0; l < 5; l++) {
            double k = 0;
            int i = 0;
            while (k < 1) {
                String[] a = TestKit.stringsGenerator(new String[i], 1, 10);
                k = MergeTest(a) / 1E9;
                i += 100;
                System.out.println("Merge;String;" + i + ";" + k);
            }
        }

        for (int l = 0; l < 5; l++) {
            double k = 0;
            int i = 0;
            while (k < 1) {
                int[] a = TestKit.intGenerator(new int[i], 1, 10);
                k = InsertionTest(a) / 1E9;
                i += 100;
                System.out.println("Insertion;int;" + i + ";" + k);
            }
        }

        for (int l = 0; l < 5; l++) {
            double k = 0;
            int i = 0;
            while (k < 1) {
                int[] a = TestKit.intGenerator(new int[i], 1, 10);
                k = MergeTest(a) / 1E9;
                i += 100;
                System.out.println("Merge;int;" + i + ";" + k);
            }
        }
    }
}
