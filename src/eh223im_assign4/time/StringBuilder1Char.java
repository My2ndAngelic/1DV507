package eh223im_assign4.time;

import java.util.Random;

public class StringBuilder1Char {
    public static void main(String[] args) {
        int k;
        long timeBefore;
        long timeAfter;

        for (int a = 0; a < 100; a++) {
            k = 0;
            do {
                StringBuilder s = new StringBuilder();
                String test = String.valueOf((char) (Character.toUpperCase(new Random().nextInt(90 - 65 + 1) + 65)));
                timeBefore = System.currentTimeMillis();
                for (int i = 0; i < k; i++) {
                    s.append(test);
                }
                s.toString();
                timeAfter = System.currentTimeMillis();
                System.out.print("\r" + "StringBuilder: " + k);
                k++;
            } while (timeAfter - timeBefore < 1000);

            System.out.println(k);
        }
    }
}
