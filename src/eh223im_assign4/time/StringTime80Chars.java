package eh223im_assign4.time;

import java.util.Random;

public class StringTime80Chars {
    public static void main(String[] args) {

        int k;
        long timeBefore;
        long timeAfter;

        // Appending 1 character string
        for (int a = 0;a<100;a++) {
            k = 0;

            do {
                String s = "";
                String test = "";
                for (int i = 0; i < 80; i++) {
                    test += String.valueOf((char) (Character.toUpperCase(new Random().nextInt(90 - 65 + 1) + 65)));
                }
                System.gc();
                timeBefore = System.currentTimeMillis();
                for (int i = 0; i < k; i++) {
                    s += test;
                }
                timeAfter = System.currentTimeMillis();
                k++;
            } while (timeAfter - timeBefore < 1);


            System.out.println("String: " + k + " times.");

        }


        for (int a = 0;a<100;a++) {
            k = 0;

            do {
                StringBuilder s = new StringBuilder();
                String test;
                for (int i = 0; i < 80; i++) {
                    s.append(String.valueOf((char) (Character.toUpperCase(new Random().nextInt(90 - 65 + 1) + 65))));
                }
                test = s.toString();
                s = new StringBuilder();
                System.gc();
                timeBefore = System.currentTimeMillis();
                for (int i = 0; i < k; i++) {
                    s.append(test);
                }
                s.toString();
                timeAfter = System.currentTimeMillis();
                k++;
            } while (timeAfter - timeBefore < 1);

            System.out.println("StringBuilder: " + k + " times.");
        }
    }
}
