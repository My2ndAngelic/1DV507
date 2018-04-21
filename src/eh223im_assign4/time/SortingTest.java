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
        System.out.println("Merge Sort;"+numbers+";"+max+";"+time /1000000000.0);
    }

    public static void InsertionSort(int numbers, int max){
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
        System.out.println("Insertion Sort;"+numbers+";"+max+";"+ time /1000000000.0);
    }

    public static void main(String[] args) {
        int num = 1000000000;
        int max = 1000000000;

        for (int i = 0; i < num; i++) {
            InsertionSort(i, max);
        }

        for (int i = 0; i < num; i++) {
            MergeTest(i, max);
        }
    }
}
