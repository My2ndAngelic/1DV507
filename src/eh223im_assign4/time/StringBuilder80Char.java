package eh223im_assign4.time;

import java.util.Random;

public class StringBuilder80Char {
    public static void main(String[] args) {
        int k;
        long timeBefore;
        long timeAfter;
        double elapsed;
        k = 0;

        System.out.println("StringBuilder80 Test");
        do {
                StringBuilder s = new StringBuilder();
                StringBuilder test = new StringBuilder();
                for (int i = 0; i < 80; i++) {
                    test.append(String.valueOf((char) (Character.toUpperCase(new Random().nextInt(90 - 65 + 1) + 65))));
                }
                String s2 = test.toString();
                System.gc();
                timeBefore = System.nanoTime();
                for (int i = 0; i < k; i++) {
                    s.append(s2);
                }
                s.toString();
                timeAfter = System.nanoTime();
                elapsed = (timeAfter - timeBefore)/1E9;

                System.out.print("\r" + k + ";"+ elapsed);
                k++;
            } while (elapsed < 1);

            System.out.print("\n");
//        }

        System.out.println();
    }
}
