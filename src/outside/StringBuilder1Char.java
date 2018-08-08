package outside;

import java.util.Random;

public class StringBuilder1Char {
    public static void main(String[] args) {
        int k;
        long timeBefore;
        long timeAfter;
        double elapsed;
        System.out.println("StringBuilder1 Test");
            k = 0;
            do {
                StringBuilder s = new StringBuilder();
                String test = String.valueOf((char) (Character.toUpperCase(new Random().nextInt(90 - 65 + 1) + 65)));
                timeBefore = System.nanoTime();
                for (int i = 0; i < k; i++) {
                    s.append(test);
                }
                s.toString();
                timeAfter = System.nanoTime();
                elapsed = (double) (timeAfter - timeBefore)/1E9;
                System.out.print("\r" + k + ";"+ elapsed);
                k++;
            } while (elapsed < 1);

            System.out.println(k);
    }
}
