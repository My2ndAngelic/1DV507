package eh223im_assign4.time;

import org.apache.commons.lang3.RandomStringUtils;

public class StringTimeTest {
    public static long stringConcatTest(int length, int num) {
        System.gc();
        String s = RandomStringUtils.randomAlphanumeric(length);
        String test = "";
        long t1 = System.nanoTime();
        for (int i = 0; i<num; i++) {
                test += s;
        }
        s.toString();
        long t2 = System.nanoTime();
        return t2-t1;
    }

    public static long stringBuilderTest(int length, int num) {
        System.gc();
        String s = RandomStringUtils.randomAlphanumeric(length);
        StringBuilder sb = new StringBuilder();
        long t1 = System.nanoTime();
        for (int i = 0; i<num; i++) {
            sb.append(s);
        }
        sb.toString();
        long t2 = System.nanoTime();
        return t2 - t1;
    }

    public static void main(String[] args) {

         // 1 char
         for (int l = 0; l < 5; l++) {
             double k = 0;
             int i = 96000;
             while (k < 1) {
                 i += 100;
                 k = stringConcatTest(1,i) / 1E9;
                 System.out.print("StringConcat;1;" + i + ";" + k+"\r");
             }
             System.out.println();
         }

         for (int l = 0; l < 5; l++) {
             double k = 0;
             int i = 79000000;
             while (k < 1) {
                 i += 100;
                 k = stringBuilderTest(1,i) / 1E9;
                 System.out.print("StringBuilder;1;" + i + ";" + k+"\r");
             }
             System.out.println();
         }

         // 80 chars
         for (int l = 0; l < 5; l++) {
             double k = 0;
             int i = 10000;
             while (k < 1) {
                 i += 100;
                 k = stringConcatTest(80,i) / 1E9;
                 System.out.print("StringConcat;80;" + i + ";" + k+"\r");
             }
             System.out.println();
         }

        for (int l = 0; l < 5; l++) {
            double k = 0;
            int i = 4298100;
            while (k < 1) {
                i += 100;
                k = stringBuilderTest(80,i) / 1E9;
                System.out.print("StringBuilder;80;" + i + ";" + k+"\r");
            }
            System.out.println();
        }
    }
}
