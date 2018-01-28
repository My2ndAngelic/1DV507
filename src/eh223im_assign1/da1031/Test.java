package eh223im_assign1.da1031;

import java.util.Arrays;

public class Test {

    public static void print (int[] a, int n) {
        if (n<a.length) {
            System.out.println(a[n]);
            print(a,n+1);
        }
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else
            return (fib(n-1)) + (fib(n-2));
    }

    public static void main(String[] args) {
//        int[] k = {0,1,2,3,4,5,6,7,8,9};

        System.out.println("Fib value: "+fib(50));
//        print(k,0);

//        int index = 3, n = 7;
//        int[] ints = {1,2,3,4,5,6,7};
//
//        ArrayIntList k = new ArrayIntList();
//        for (int i =5; i<15;i++) {
//            k.add(i);
//        }
//        System.out.println(k.toString());
//        System.out.println(k.indexOf(1));
//        System.out.println(k.get(1));


//        int[] temp = new int[ints.length+1];
//        System.arraycopy(ints,0,temp,0,index);
//        temp[index] = n;
//        System.arraycopy(ints,index,temp,index+1,ints.length-index);
//        ints = temp;
//        System.out.println(k.toString());


    }
}
