package eh223im_assign3.count_words;

import java.io.File;
import java.util.*;

public class WordCount1Main {
    public static void main(String[] args) {
        try {

//            IdentifyWordsMain.main(new String[0]);

            File f = new File("words.txt");
            Scanner scanner = new Scanner(f);

            System.out.println();

            ArrayList<Word> alw = new ArrayList <>();
            while (scanner.hasNext()) {
                alw.add(new Word(scanner.next()));
            }
            System.out.println(alw.size());

            scanner = new Scanner(f);
            Set <Word> hsW = new HashSet <>();
            while (scanner.hasNext()) {
                hsW.add(new Word(scanner.next()));
            }
            System.out.println(hsW.size());

            scanner = new Scanner(f);
            Set <Word> tsW = new TreeSet <>();
            while (scanner.hasNext()) {
                tsW.add(new Word(scanner.next()));
            }
            System.out.println(tsW.size());

            System.out.println(Arrays.toString(tsW.toArray()));

            System.out.println(Character.getNumericValue('c') + " " + Character.getNumericValue('C'));

        } catch(Exception e) {
            e.printStackTrace();
        }


    }
}
