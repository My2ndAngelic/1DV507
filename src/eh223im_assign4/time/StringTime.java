package eh223im_assign4.time;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class StringTime {
    public static void main(String[] args) {
        String s = "";

        long sTimer = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s += "abcdefghijklmnopqrstuvwxyz";
        }
        sTimer = System.currentTimeMillis() - sTimer;
        System.out.println(sTimer);

        File f = new File("stringTimer.txt");
        try {
            PrintWriter pw = new PrintWriter(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        long sbTimer = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyz");
        }
        sbTimer = System.currentTimeMillis() - sbTimer;
        System.out.println(sbTimer);
    }
}
