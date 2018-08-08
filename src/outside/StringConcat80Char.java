package outside;

import java.util.Random;

public class StringConcat80Char {
    public static void main(String[] args) {
        int k;
        long timeBefore;
        long timeAfter;
        double elapsed;

        k = 0;
        System.out.println("StringConcat80 Test");
        do {
                String s = "";
                String test = "";
                for (int i = 0; i < 80; i++) {
                    test += String.valueOf((char) (Character.toUpperCase(new Random().nextInt(90 - 65 + 1) + 65)));
                }
                System.gc();
                timeBefore = System.nanoTime();
                for (int i = 0; i < k; i++) {
                    s += test;
                }
                timeAfter = System.nanoTime();
                elapsed = (double) (timeAfter-timeBefore)/1E9;
                k++;
                System.out.print("\r" + k + ";"+ elapsed);
            } while (elapsed < 1);

        System.out.println();
    }
}
