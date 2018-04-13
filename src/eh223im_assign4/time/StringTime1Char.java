package eh223im_assign4.time;

import java.util.Random;

public class StringTime1Char {
    public static void main(String[] args) throws InterruptedException {

        int k;
        long timeBefore ;
        long timeAfter;

        for (int a = 0; a < 100; a++) {
            k = 0;
            // Appending 1 character string
            do {
                String s = "";
                String test = String.valueOf((char) (Character.toUpperCase(new Random().nextInt(90 - 65 + 1) + 65)));
                timeBefore = System.currentTimeMillis();
                for (int i = 0; i < k; i++) {
                    s += test;
                }
                timeAfter = System.currentTimeMillis();
                k++;
                System.out.print("\r"+"String concatenation: "+k);
//                Thread.sleep(500);
//                System.out.print("\r"+k);
            } while (timeAfter - timeBefore < 1000);

            System.out.print("\n");

            System.gc();
        }

        System.out.println();

//        do {
//            StringBuilder s = new StringBuilder();
//            String test = String.valueOf((char) (Character.toUpperCase(new Random().nextInt(90-65+1)+65)));
//            timeBefore = System.currentTimeMillis();
//            for (int i = 0; i < k; i++){
//                s.append(test);
//            }
//            timeAfter = System.currentTimeMillis();
//            k++;
//        } while (timeAfter - timeBefore < 1);
//
//        System.out.println(k);
    }
}
