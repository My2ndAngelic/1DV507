package eh223im_assign3.count_words;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class TWSTest {
    public static void main(String[] args) {
        TreeWordSet hws = new TreeWordSet();

        try {
            Scanner scan = new Scanner(new File("words.txt"));

            do {
                hws.add(new Word(scan.next()));
            } while (scan.hasNext());


            System.out.println(hws.print());
            System.out.println(hws.size());


            Iterator k = hws.iterator();
            while (k.hasNext()) {
                System.out.println(k.next().toString());
            }
//                            hws.iterator().next();


//            hws.add(new Word("Hello"));
//            hws.iterator();
//            do {
//                System.out.println(hws.iterator().next().toString());
//            } while (hws.iterator().hasNext());
//
//            for (int i = 0; i < 100; i++) {
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
