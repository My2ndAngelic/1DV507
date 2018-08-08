package outside;

import java.util.Random;

public class StringConcat1Char {
    public static void main(String[] args) {

        int k;
        long timeBefore;
        long timeAfter;
        double elapsed;

        k = 0;

        System.out.println("StringConcat1 Test");
        do {
                String s = "";
                String test = String.valueOf((char) (Character.toUpperCase(new Random().nextInt(90 - 65 + 1) + 65)));
                timeBefore = System.nanoTime();
                for (int i = 0; i < k; i++) {
                    s += test;
                }
                timeAfter = System.nanoTime();
                elapsed = (double) (timeAfter - timeBefore)/1E9;
                System.out.print("\r" + k + ";"+ elapsed);
                k++;
            } while (elapsed < 1);

            System.out.print("\n");
    }
}
