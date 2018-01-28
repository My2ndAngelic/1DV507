package eh223im_assign1;

public class SumMain {
    // Solving using summing number within a range, first sum 1 ~ n/2, then n/2+1 ~ n
    public static int sum(int n) { // Return result here
        return sumRange(1,n/2) + sumRange(n/2+1,n);
    }

    public static int sumRange(int begin, int end) { // Summing in range from @begin to @end
        if (end == begin) {
            return begin;
        } else return end + sumRange(begin,end-1);
    }

    public static int sumStd(int n) { // Standard sum method from 1 to @end
        if (n == 0) {
            return 0;
        } else {
            return n + sumStd(n-1);
        }
    }

    public static int sumTest(int n) { // Testing using for loop
        int k = 0;
        for (int i = 1; i <= n; i++) {
            k = k + i;
        }
        return k;
    }

    public static void main(String[] args) { // psvm
        int n = 10;
        System.out.println("Half-divided: " + "\t "+sum(n));
        System.out.println("Standard: "+ "   \t "+ sumStd(n));
        System.out.println("Expected: "+ "   \t " +sumTest(n));

        if (sum(n) == sumStd(n) && sum(n) == sumTest(n)) {
            System.out.println("Correct.");
        } else System.out.println("Incorrect.");
    }

    /*
     * Comment on the solution
     * I do not know if this is a good strategy or not, it's seems that I just found a different strategy.
     * If I understand the requirement correctly, it should be dividing n into 2 ranges,
     * from 1 to n/2 and from n/2 + 1 to n, respectively.
     * However, the strategy I chose is not really impressive nor interesting (though I would not say
     * it is boring, but it is really what it is, dull and unpolished).
     *
     */
}
