package outside;

import java.lang.reflect.Method;
import java.util.Arrays;

public class javaInt {

    public static void main(String[] args) {
        int[] arr = new int[100];
        try {
            Class<?> c = Class.forName("eh223im_assign4.LinkedQueueTest");
            Method[] methods = c.getDeclaredMethods();
            Method method = null;

            for (Method m : methods) {
                String s = m.getName();
                if (s.startsWith("intG")) {
                    method = m;
                    method.setAccessible(true);
                    break;
                }
            }
            //                System.out.println(method.getName());
            System.out.println(Arrays.toString((int[]) method.invoke(arr, arr, -100, 100)));

            Class c2 = Class.forName("eh223im_assign4.time.LeSortingAlgorithms");
            Method m = c2.getMethod("mergeIntSort", int[].class);
            System.out.println(Arrays.toString((int[]) m.invoke("",arr)));

            int[] carr = Arrays.copyOf(arr,arr.length);
            Arrays.sort(carr);
            int[] carr2 = Arrays.copyOf(carr,carr.length);
            for (int i = 0;i<carr.length;i++) {
                carr2[i] = carr[carr.length - i -1];
            }
            System.out.println(Arrays.toString(carr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
