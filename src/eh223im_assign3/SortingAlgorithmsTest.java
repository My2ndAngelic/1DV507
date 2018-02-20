package eh223im_assign3;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortingAlgorithmsTest {

    @Test
    void insertionSortT1() {
        int[] f = new int[1000000];
        for (int i = 0; i<f.length;i++) {
            f[i] = new Random().nextInt(f.length)+1;
        }
//        int[] k = SortingAlgorithms.insertionSort(f);
        Arrays.sort(f);

        System.out.print("[");
        for (int aF : f) {
            System.out.print(aF + ", ");
        }
        System.out.println("]");

//        System.out.println(Arrays.toString(f));

//        assertArrayEquals(f,k);
    }

    @Test
    void insertionSortT2() {
        ArrayList <BigInteger> albi = new ArrayList <>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 10000; j++) {
                sb.append(new Random().nextInt(9));
            }
            albi.add(new BigInteger(sb.toString()));
            sb = new StringBuilder();
        }
        BigInteger[] k1 = new BigInteger[albi.size()];

        for (int i = 0; i < albi.size(); i++) {
            k1[i] = albi.get(i);
        }

        //            @Override
        System.out.println(k1[0].doubleValue());
//        k1 = (BigInteger[]) SortingAlgorithms.insertionSort(k1, (o1, o2) -> (new BigInteger(o1.toString()).compareTo(new BigInteger(o2.toString()))));

        BigInteger[] k2 = new BigInteger[albi.size()];
        for (int i = 0; i < albi.size(); i++) {
            k2[i] = albi.get(i);
        }

        Collections.sort(Arrays.asList(k2));

        System.out.println(Arrays.toString(k1));
        System.out.println(Arrays.toString(k2));

        assertArrayEquals(k1,k2);
    }

    @Test
    void insertionSort1() {
    }
}