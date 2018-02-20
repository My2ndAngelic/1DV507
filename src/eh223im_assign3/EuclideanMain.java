package eh223im_assign3;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EuclideanMain {
    public static void main(String[] args) {
        // Google Code Jam reader method (because it is interesting?)
        Scanner scan = new Scanner(new InputStreamReader(new BufferedInputStream(System.in)));

        // Input
        System.out.print("Enter first number: ");
        int f = scan.nextInt();
        System.out.print("Enter second number: ");
        int s = scan.nextInt();

        // Backup
        int n1 = f;
        int n2 = s;

        // Euclidean algorithm
        while (f != s) {
            if (f > s) {
                f -= s;
            } else {
                s -= f;
            }
        }

        System.out.println("GCD(" + n1 + "," + n2 + ") = " + f);
    }
}
