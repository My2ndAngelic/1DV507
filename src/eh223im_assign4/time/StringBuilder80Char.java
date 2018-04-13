package eh223im_assign4.time;

import java.util.Random;

public class StringBuilder80Char {
    public static void main(String[] args) {
        int k;
        long timeBefore;
        long timeAfter;

        for (int a = 0; a < 100; a++) {
            k = 0;
            // Appending 1 character string
            do {
                StringBuilder s = new StringBuilder();
                StringBuilder test = new StringBuilder();
                for (int i = 0; i < 80; i++) {
                    test.append(String.valueOf((char) (Character.toUpperCase(new Random().nextInt(90 - 65 + 1) + 65))));
                }
                System.gc();
                timeBefore = System.currentTimeMillis();

                for (int i = 0; i < k; i++) {
                    s.append(test);
                }
                s.toString();

                timeAfter = System.currentTimeMillis();
                k++;
                System.out.print("\r" + "String concatenation: " + k + " | "+ ((double) (timeAfter - timeBefore)/1000));

            } while (timeAfter - timeBefore < 1000);

            System.out.print("\n");
        }

        System.out.println();
    }
}
