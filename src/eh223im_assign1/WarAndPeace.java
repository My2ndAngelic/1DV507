package eh223im_assign1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WarAndPeace {
    public static void main(String[] args) {
        try {
            System.out.print("Do you want to download the file from \nhttp://homepage.lnu.se/staff/jlnmsi/java2/2018/WarAndPeace.txt?\nEnter N to give the path to your file instead.\nYour choice: ");
            String path = new Scanner(new BufferedReader(new InputStreamReader(System.in))).nextLine(); // Google Code Jam method of keyboard reading.
            if (!(path.equals("N") || path.equals("n"))) {
                downloadFile("http://homepage.lnu.se/staff/jlnmsi/java2/2018/WarAndPeace.txt","WarAndPeace.txt"); // For easier testing, I will get the file directly. It requires internet connection.
                path = "WarAndPeace.txt";
            } else {
                System.out.print("Enter the path to your text file: ");
                path = new Scanner(new BufferedReader(new InputStreamReader(System.in))).nextLine();
            }

            System.out.println(); // Empty line
            String text = readText(path);   // My own method
            String[] words = text.split(" ");  // Simple split, will be cleaned up later on

            System.out.println("Initial word count: "+words.length);   // I found (NOT) 577091, but 577092.

            // Open Stream and cleaning up List
            Stream stream = Arrays.stream(words);
            List<String> ls = toList(stream);
            ls = applyFunction(ls,String::toUpperCase);
            ls = applyFunction(ls,WarAndPeace::cleanString);

            // Export to String[]
            String[] words2 = toStringArray(ls);

            // Testing part
            System.out.println("Total words (cleaned up): "+countWords(words2));
            System.out.println("Unique words: "+ Arrays.toString(getUniqueWords(words2)).length());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    Uniqueness check for each and every words, requires long computational power
    Return array full of unique words, requires cleaned array.
    */
    public static String[] getUniqueWords (String[] args) {
        ArrayList <String> temp = new ArrayList <>(Arrays.asList(args));

        // Remove duplication in the ArrayList
        for (int i = 0; i<temp.size(); i++) {
            for (int j = i+1; j<temp.size(); j++) {
                if (temp.get(j).equals(temp.get(i))) {
                    temp.remove(j);
                    j--;
                }
            }
        }

        // Export
        String[] result = new String[temp.size()];
        int index = 0;
        for (Object ignored : temp) {
            result[index] = temp.get(index);
            index++;
        }

        // Output
        return result;
    }

    /*
    Count words, requires cleaning up arrays;
    High computational time
     */
    public static int countWords (String[] args) {
        int i = 0;
        for (String s : args) {
            try {
                s.substring(0,1); // Test if string is empty, if not then count
                i++;
            } catch (Exception ignored) {

            }
        }
        return i;
    }

    // Read text from file and export to a string
    public static String readText(String file) {
        try {
            List <String> ls = Files.readAllLines(Paths.get(file)); // SOF: how to read files into String
            return ls.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // Function mapper
    public static List<String> applyFunction(List<String> list, Function <String, String> fx) {
        return list.stream()
                .map(fx)
                .collect(Collectors.toList());
    }

    // Convert from List<String> to Stream
    public static Stream toStream (List<String> list) {
        return list.stream();
    }

    // SOF: Convert List<Object> to List<String>
    public static List <String> toList (Stream s) { // Convert Stream to List<String>
        int index = 0;
        List <Object> l = Arrays.asList(s.toArray());
        String[] array = new String[l.size()];

        for (Object v : l) {
            array[index] = (String) v;
            index++;
        }
        return Arrays.asList(array);
    }

    // Convert List<String> to StringArray
    public static String[] toStringArray (List<String> l) {
        String[] array = new String[l.size()];
        int index = 0;
        for (Object v : l) {
            array[index] = (String) v;
            index++;
        }
        return array;
    }

    // Conver ArrayList<String> to StringArray
    public static String[] toStringArray (ArrayList<String> ls) {
        int index = 0;
        String[] result = new String[ls.size()];
        for (Object o : ls) {
            result[index] = ls.get(index);
            index++;
        }
        return result;
    }

    /*
    Clean the word in string, only letter is leftover, everything else removed, empty strings expected
    Expected don't and do not are two different words; "well-known" and "known" are also different, both are considered words.
    */
    public static String cleanString (String s) {
        char[] k = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char a : k) {
            if (Character.isLetter(a))  {
                sb.append(a);
            }
        }
        s = sb.toString().toUpperCase();
        return s;
    }

    /*
    Download file to read, in case there is no file
    SOF: Download file with Java
    For testing purpose only.
    */
    public static void downloadFile (String url, String path) {
        try {
            URL website = new URL(url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(path);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
