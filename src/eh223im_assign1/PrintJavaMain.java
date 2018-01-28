package eh223im_assign1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class PrintJavaMain {

    // Adopted from: https://stackoverflow.com/questions/3154488/how-do-i-iterate-through-the-files-in-a-directory-in-java

    public static void printAllJavaFiles(File[] directory) {

        for (File file : directory) {
            if (file.isDirectory()) {
//                System.out.println(file.getName()+"/");
                printAllJavaFiles(file.listFiles());
            } else if (isJava(file)){
                System.out.println(file.getName() + " - " + file.length() + " bytes");
                printJavaOnScreen(file);
                System.out.println();
            }
        }
    }

    // Adopted from: Google Code Jam quickstart guide
    // https://code.google.com/codejam/resources/quickstart-guide
    // My old code, reused, for printing file on screen
    public static void printJavaOnScreen(File f) {
        try {
            Scanner scan = new Scanner(f);
            do {
                System.out.println(scan.nextLine());
            } while (scan.hasNextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isJava(File file) {
        return file.getName().endsWith("java");
    }
    public static File[] listFile (File file) {
        if (file.isDirectory()) {
            return file.listFiles();
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        String s = "/Users/My2ndAngelic/test";
        printAllJavaFiles(new File(s).listFiles());
    }
}
