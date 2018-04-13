package eh223im_assign3.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount2Main {
    public static void main(String[] args) {
        HashWordSet hws = new HashWordSet();

        TreeWordSet tws = new TreeWordSet();

        File f = new File("words.txt");
        try {
            Scanner s = new Scanner(f);
            StringBuilder sb = new StringBuilder();
            while (s.hasNext()) {
                sb.append(s.next()).append(" ");
            }

            String[] sa = sb.toString().split(" ");

            for (String aSa : sa) {
                tws.add(new Word(aSa));
                hws.add(new Word(aSa));
            }

            System.out.println("Result: ");

            System.out.println("HashWordSet: "+ hws.print());
            System.out.println("Total: "+hws.size());
            System.out.println("TreeWordSet: "+ tws.print());
            System.out.println("Total: "+hws.size());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
