package eh223im_assign4.require;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Random;

public class TestKit {
    // Generate int[] for checking, also require requires arr <= max - min + 1 to avoid duplication
    public static int[] intsGenerator(int[] arr, int min, int max) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (min <= max && (max - min) > arr.length) {
            for (int i = 0; i < arr.length; i++) {
                int f = new Random().nextInt(max - min + 1) + min;
                arrayList.add(f);
                while (arrayList.indexOf(f) < i) { // Check duplication by existence of previously added element
                    arrayList.remove(i);
                    f = new Random().nextInt(max - min + 1) + min;
                    arrayList.add(f);
                }
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arrayList.get(i);
            }
            return arr;
        } else throw new IllegalArgumentException("Check range.");
    }

    public static String[] stringsGenerator(String[] arr, int min, int max) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (min <= max) {
            for (int i = 0; i < arr.length; i++) {
                String a = RandomStringUtils.randomAlphanumeric(min, max);
                arrayList.add(a);
                while (arrayList.indexOf(a) < i) { // Check duplication by existence of previously added element
                    arrayList.remove(i);
                    a = RandomStringUtils.randomAlphanumeric(min, max);
                    arrayList.add(a);
                }
            }
            return arrayList.toArray(new String[0]);
        } else {
            throw new IllegalArgumentException("Check range");
        }
    }
}
