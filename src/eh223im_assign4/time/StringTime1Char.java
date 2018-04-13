package eh223im_assign4.time;

import java.util.Random;

public class StringTime1Char {
    public static void main(String[] args) {

        int k = 0;
        long timeBefore = 0;
        long timeAfter = 0 ;

        // Appending 1 character string
        do {
            String s = "";
            String test = String.valueOf((char) (Character.toUpperCase(new Random().nextInt(90-65+1)+65)));
            timeBefore = System.currentTimeMillis();
            for (int i = 0; i < k; i++){
                s += test;
            }
            timeAfter = System.currentTimeMillis();
            k++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (timeAfter - timeBefore < 1);


        System.out.print(k+ " ");

        System.gc();
        k = 0;

        do {
            StringBuilder s = new StringBuilder();
            String test = String.valueOf((char) (Character.toUpperCase(new Random().nextInt(90-65+1)+65)));
            timeBefore = System.currentTimeMillis();
            for (int i = 0; i < k; i++){
                s.append(test);
            }
            timeAfter = System.currentTimeMillis();
            k++;
        } while (timeAfter - timeBefore < 1);

        System.out.println(k);
    }
}
