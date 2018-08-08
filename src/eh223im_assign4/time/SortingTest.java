package eh223im_assign4.time;

import eh223im_assign4.require.TestKit;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Collections;

public class SortingTest {
    public static long MergeTest(int[] initArr) {
        long time;
        long t1 = System.nanoTime();
        initArr = LeSortingAlgorithms.mergeIntSort(initArr);
        long t2 = System.nanoTime();
        time = t2 - t1;
        return time;
    }

    public static long InsertionTest(int[] initArr) {
        long time;
        long t1 = System.nanoTime();
        initArr = LeSortingAlgorithms.insertionIntSort(initArr);
        long t2 = System.nanoTime();
        time = t2 - t1;
        return time;       
    }

    public static long InsertionTest(String[] initArr) {
        long time;
        long t1 = System.nanoTime();
        initArr = LeSortingAlgorithms.insertionStringSort(initArr);
        long t2 = System.nanoTime();
        time = (t2 - t1);
        return time;
    }

    public static long MergeTest(String[] initArr) {
        long time;
        long t1 = System.nanoTime();
        initArr = LeSortingAlgorithms.mergeStringSort(initArr);
        long t2 = System.nanoTime();
        time = (t2 - t1);
        return time;    
    }

    public static void main(String[] args) {
        /**
        * Testing method:
        * > Generating an Array List
        * > Adding neccesary elements 
        * > > for Integer: increment by 100
        * > > for String: using RandomStringsUtils from Apache Commons Lang API (current: 3.7)
        * > Shuffle it using Collections.shuffle
        * > Sort it and test for time
        * NB: The check for correctness using Arrays.sort is removed in order to save time
        * Number of elements has been pre-calibrated
        */

        // Insertion Integer Sort
        for (int l = 0; l < 5; l++) {
            ArrayList<Integer> al = new ArrayList<>();
            double time = 0;
            int i = 75500;
            int[] a = {};
            for (int k=0; k<i; k++) {
                al.add(k);
            }
            while (time < 1) {
                int ext = 10;
                for (int j = i; j<ext+i;j++) {
                    al.add(j);
                }
                i += ext;
                Collections.shuffle(al);
                a = al.stream().mapToInt(z->z).toArray();
                time = InsertionTest(a) / 1E9;
                System.out.print("Insertion;int;" + i + ";" + time + "\r");
            }
            System.out.println();
        }

         // Merge Integer Sort
         for (int l = 0; l < 5; l++) {
             double time = 0;
             ArrayList<Integer> al = new ArrayList<>();
             int[] a = {};
             int i = 3550000;
             for (int k=0; k<i; k++) {
                 al.add(k);
             }
             while (time < 1) {
                 int ext = 10000;
                 for (int j = i; j<ext+i;j++) {
                     al.add(j);
                 }
                 i += ext;
                 Collections.shuffle(al);
                 a = al.stream().mapToInt(z->z).toArray();
                 time = MergeTest(a) / 1E9;
                 System.out.print("Merge;int;" + a.length + ";" + time + "\r");
             }
             System.out.println();
         }

        // Insertion String Sort
        for (int l = 0; l < 5; l++) {
            ArrayList<String> al = new ArrayList<>();
            double k = 0;
            int i = 5000;
            String[] a = TestKit.stringsGenerator(new String[i], 10, 10);
            Collections.addAll(al, a);
            while (k < 1) {
                int ext = 100;
                for (int j = i; j < i+ext; j++) {
                    al.add(RandomStringUtils.randomAlphabetic(10,10));
                }
                i += ext;
                a = al.toArray(new String[0]);
                k = InsertionTest(a) / 1E9;
                System.out.print("Insertion;String;" + i + ";" + k+"\r");
            }
            System.out.println();
        }

        // Merge String Sort
        for (int l = 0; l < 5; l++) {
             ArrayList<String> al = new ArrayList<>();
             double k = 0;
             int i = 200000;
             String[] a = {};
             for (int j = 0; j<i; j++) {
                al.add(RandomStringUtils.randomAlphabetic(10,10));
             }
             while (k < 1) {
                 int ext = 10000;
                 for (int j = i; j < i+ext; j++) {
                     al.add(RandomStringUtils.randomAlphabetic(10,10));
                 }
                 i += ext;
                 a = al.toArray(new String[0]);
                 k = MergeTest(a) / 1E9;
                 System.out.print("Merge;String;" + i + ";" + k+"\r");
             }
             System.out.println();
         }
    }
}
