package eh223im_assign3.count_words;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

public class IdentifyWordsMain {
    public static void main(String[] args) {
        try {
            /*
             * Code reuse. Download file to current folder for testing
             */
            System.out.print("Do you want to download the file from \nhttp://homepage.lnu.se/staff/jlnmsi/java2/HistoryOfProgramming.txt?\nEnter N to give the path to your file instead.\nYour choice: ");
            Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            String path = scan.nextLine(); // Google Code Jam method of keyboard reading.

            if (!(path.equals("N") || path.equals("n"))) {
                download("http://homepage.lnu.se/staff/jlnmsi/java2/HistoryOfProgramming.txt", "HistoryOfProgramming.txt"); // For easier testing, I will get the file directly. It requires internet connection.
                path = "HistoryOfProgramming.txt";
            } else {
                System.out.print("Enter the path to your text file: ");
                path = scan.nextLine();
            }

            path = (path.equals("")) ? "HistoryOfProgramming.txt" : path;

            /*
             * Main working
             */
            File f = new File(path);
            Scanner sf = new Scanner(f);
            StringBuilder sb = new StringBuilder();

            /*
             * Read the file & build raw strings
             */
            while (sf.hasNextLine()) {
                sb.append(sf.nextLine()).append("\n");
            }
            char[] c = sb.toString().toCharArray();
            StringBuilder sb2 = new StringBuilder();

            // Read from string array
            try {
                for (int i = 0; i < c.length; i++) { // Replace unneeded characters with ASCII 00010100
                    if (!Character.isLetter(c[i]) && !Character.isWhitespace(c[i])) {
                        c[i] = 20;
                    }
                }
                for (char aC : c) { // Remove them from the string
                    if (aC != 20) {
                        sb2.append(aC);
                    }
                }
            } catch (Exception ignored) {
                // Do not care if something happened
            }

            // SOF: remove blank lines + remove last final empty lines + double space
            String text = sb2.delete(sb2.length() - 1, sb2.length()).toString().replaceAll("(?m)^[ \t]*\r?\n", "").replaceAll(" {2}", " ");

            // Write to file
            File oF = new File("words.txt");
            PrintWriter pw = new PrintWriter(oF);
            pw.write(text);
            pw.close();

            // Export result
            System.out.println("\n" + text);
            System.out.println("\n" + "File length: " + oF.length());
            System.out.println("Exported file: " + oF.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
   Download file to read, in case there is no file
   SOF: Download file with Java
   For testing purpose only.
   */
    private static void download(String url, String path) {
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
