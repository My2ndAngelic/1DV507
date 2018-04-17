package eh223im_assign4.time;

import java.util.Random;

public class StringConcat1Char {
    public static void main(String[] args) {

        int k;
        long timeBefore;
        long timeAfter;

        for (int a = 0; a < 10; a++) {
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
                k+=100;
                System.out.print("\r" + "String Concatenation: " + k + " | "+ ((double) (timeAfter - timeBefore)/1000));
            } while (timeAfter - timeBefore < 1000);

            System.out.print("\n");

            System.gc();
        }

        System.out.println();
    }
}
