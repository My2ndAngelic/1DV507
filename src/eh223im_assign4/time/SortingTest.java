package eh223im_assign4.time;

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
        sortingArr = LeSortingAlgorithms.MergeSort(sortingArr);
        long t2 = System.nanoTime();
        time = t2 - t1;

        t2 = System.nanoTime();
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
        sortingArr = LeSortingAlgorithms.InsertionSort(sortingArr);
        long t2 = System.nanoTime();
        time = t2 - t1;

        t1 = System.nanoTime();
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

        t1 = System.nanoTime();
        int[] checkArr = Arrays.copyOf(sortingArr,sortingArr.length);
        Arrays.sort(checkArr);

        if (Arrays.equals(sortingArr,checkArr)) {
            System.out.println("Quick Sort;" + numbers + ";" + max + ";" + time / 1000000000.0);
        } else {
            System.out.println("Quick Sort: Error");
        }
    }


    public static void main(String[] args) {
        int num = 1000000000;
        int max = 1000000000;

        for (int i = 0; i < num; i+=1000000) {
            QuickTest(i, max);
        }

        System.out.println("\n---\n");

        for (int i = 0; i < num; i+=1000000) {
            MergeTest(i, max);
        }

        System.out.println("\n---\n");

        for (int i = 0; i < num; i+=1000000) {
            InsertionTest(i, max);
        }
    }
}
