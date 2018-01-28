package eh223im_assign1;

import java.util.Arrays;

public class PascalMain {
    public static int[] pascalRow(int n) {
        int[] arr = new int[n+1];
        for (int i = 0; i<=n; i++) {
            arr[i] = valAtPos(n,i);
        }
        return arr;
    }

    // Return factorial value
    public static int factorial (int n) {
        if (n == 0) {
            return 1;
        } else return n * factorial(n-1);
    }

    // Return value at row @i and position @j. SOF if i>j.
    public static int valAtPos(int i, int j) {
        if (j == 0) {
            return 1;
        } else if (j == i) {
            return 1;
        } else {
            return valAtPos(i - 1, j - 1) + valAtPos(i - 1, j);
        }

    }

    public static void main(String[] args) {
        int n = 0;
//        System.out.println(factorial(n));
        System.out.println(Arrays.toString(pascalRow(n)));

    }
}
