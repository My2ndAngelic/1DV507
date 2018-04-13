package eh223im_assign4.time;

import java.util.Arrays;
import java.util.Random;

public class SortingTest {
    public static void main(String[] args){
        double time = 0;

        int numbers = 1000000;

        int[] initArr = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            initArr[i] = new Random().nextInt(99999);
        }

        System.out.println(Arrays.toString(initArr));

        int[] sortingArr = Arrays.copyOf(initArr,initArr.length);

        System.gc();
        long t1 = System.nanoTime();
        sortingArr = LeSortingAlgorithms.MergeSort(sortingArr);
        long t2 = System.nanoTime();

        time = t2 - t1;
        System.out.println(Arrays.toString(sortingArr));
        System.out.println("Time: "+time/1000000000.0 + " seconds");
    }
}
