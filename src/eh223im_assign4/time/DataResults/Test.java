package eh223im_assign4.time.DataResults;

import eh223im_assign4.TestKit;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

        int[] a = TestKit.intsGenerator(new int[100000],0,2000000);

        System.out.println(Arrays.toString(a));
//        for (int i = 0;i<100000;i++) {
//            al.add(al.get(i)*10);
//        }
        System.out.println("Done 2");


    }
}
