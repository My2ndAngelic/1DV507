package eh223im_assign3;

// Import this: https://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.7
// or use maven to get Apache Common Lang 3.7

import java.util.Arrays;
import java.util.Random;

public class SortingMain {
    public static void main(String[] args) {

//        Insertion sort
        int[] arr = new int[11];

        for (int i = 0; i<arr.length; i++) {
            arr[i] = new Random().nextInt(10)+1;
        }

//        int[] k = new SortingAlgorithms().mergesort(arr);

        System.out.println("Original: \n"+ Arrays.toString(arr));
//        System.out.println("Sorted: \n"+Arrays.toString(k));

////        Insertion String sort
//        String[] arr2 = new String[100];
//
//        int truess = 0;
//        int truesss = 0;
//        int iter = 10000;
//        for (int k = 1; k <= iter; k++) {
//            int trues = 0;
//            for (int i = 0; i < arr2.length; i++) {
//                int length = new Random().nextInt(10) + 2;
//                arr2[i] = RandomStringUtils.randomAlphabetic(1,length);
//                if (arr2[i].length() >= 10) {
//                    trues++;
//                    truesss++;
//                }
//            }
//
//            if (trues > 0) {
//                truess++;
//            }
//
//            System.out.println(Arrays.toString(arr2));
//            System.out.println("From 10: " + trues);
//            System.out.println("Total: "+truesss);
//
//            double percentage = (double) truess / (double) iter;
//            System.out.println("Percentage: " + (percentage));
//
//            System.out.println("Test "+k+" completed.\n");
//          }


    }
}
