package outside;

import eh223im_assign4.time.LeSortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class SortingTest {
    public static void MergeTest(int numbers, int max){
        double time;
        int[] initArr = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            initArr[i] = new Random().nextInt(max);
        }
        int[] sortingArr = Arrays.copyOf(initArr,initArr.length);

        System.gc();
        long t1 = System.nanoTime();
        sortingArr = LeSortingAlgorithms.mergeIntSort(sortingArr);
        long t2 = System.nanoTime();
        time = t2 - t1;

        int[] checkArr = Arrays.copyOf(sortingArr,sortingArr.length);
        Arrays.sort(checkArr);

        if (Arrays.equals(sortingArr,checkArr)) {
            System.out.println("Merge Sort;" + numbers + ";" + max + ";" + time / 1000000000.0);
        } else {
            System.out.println("Merge Sort: Error");
        }
    }

    public static void InsertionTest(int numbers, int max){
        double time;
        int[] initArr = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            initArr[i] = new Random().nextInt(max);
        }
        int[] sortingArr = Arrays.copyOf(initArr,initArr.length);

        System.gc();
        long t1 = System.nanoTime();
        sortingArr = LeSortingAlgorithms.insertionIntSort(sortingArr);
        long t2 = System.nanoTime();
        time = t2 - t1;

        int[] checkArr = Arrays.copyOf(sortingArr,sortingArr.length);
        Arrays.sort(checkArr);

        if (Arrays.equals(sortingArr,checkArr)) {
            System.out.println("Insertion Sort;" + numbers + ";" + max + ";" + time / 1000000000.0);
        } else {
            System.out.println("Insertion Sort: Error");
        }
    }

    public static void QuickTest(int numbers, int max){
        double time;
        int[] initArr = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            initArr[i] = new Random().nextInt(max);
        }
        int[] sortingArr = Arrays.copyOf(initArr,initArr.length);

        System.gc();
        long t1 = System.nanoTime();
        Arrays.sort(sortingArr);
        long t2 = System.nanoTime();
        time = t2 - t1;

        int[] checkArr = Arrays.copyOf(sortingArr,sortingArr.length);
        Arrays.sort(checkArr);

        if (Arrays.equals(sortingArr,checkArr)) {
            System.out.println("Quick Sort;" + numbers + ";" + max + ";" + time / 1000000000.0);
        } else {
            System.out.println("Quick Sort: Error");
        }
    }

}
