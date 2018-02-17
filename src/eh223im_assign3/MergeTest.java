package eh223im_assign3;

import java.util.Arrays;
import java.util.Random;

public class MergeTest {
    public static void main(String[] args) {
        int[] code = new int[7];

        for (int i = 0; i<code.length; i++) {
            code[i] = new Random().nextInt(100)+1;
        }
        System.out.println(Arrays.toString(code));

        int[][] code2 = new int[code.length+1][code.length];
        boolean a = true;

        for (int k = 0, i = 0; k < code.length / 2; k++) {
            code2[k][i] = code[i];
            i++;
            code2[k][i] = code[i];
            i++;
        }
       if (code.length %2 != 0) {
            code2[code.length/2][code.length-1] = code[code.length-1];
        }

        for (int first = 0,second = 0, k = code.length/2; k<code.length-1;k++) {
            first++;
            second++;
            first = second;
            second = first;
        }

        System.out.println(Arrays.deepToString(code2));
//
//        try {
//            for (int e = 0, s = 0; e < code.length; e++) {
//                if (code2[e][s] > code2[e][s+1]) {
//                    int z = code2[e][s];
//                    code2[e][s] = code2[e][s+1];
//                    code2[e][s+1] = z;
//                }
//                s = s+2;
//            }
//        } catch (ArrayIndexOutOfBoundsException ignored) {
//
//        }
//
//        try {
//            int counter = 0;
//            i = 0; k = (code.length % 2 == 0) ? code.length/2 : code.length/2+1;
//            int first = 0;
//            int second = 0;
//
//
//            while (a) {
////
////                for (i = 0; i < code.length; i++) {
////                    code2[k][i] = code2[counter][i];
////                }
////
////                for (i = 0; i<code.length; i++) {
////                    if (code2[counter][i] < code2[counter+1][i+2]) {
////                        code2[k][i] = code2[counter][i];
////                        code2[k][i+1] = code2[counter+1][i+2];
////                    } else {
////                        code2[k][i] = code2[counter][i+2];
////                        code2[k][i+1] = code2[counter][i];
////                    }
////                    if (code2[counter][i++] < code2[counter+1][i+2]) {
////                        code2[k][i] = code2[counter][i];
////                        code2[k][i+1] = code2[counter][i+2];
////                    } else {
////                        code2[k][i] = code2[counter][i+2];
////                        code2[k][i+1] = code2[counter][i];
////                    }
////                    k++;
////                    counter+=2;
////                }
//////
//                int max = k+2;
//                for (k=k; k<max; k++) {
//                    if (code2[counter][i] < code2[counter + 1][i + 2]) {
//                        code2[k][i] = code2[counter][i];
//                        code2[k][i + 1] = code2[counter + 1][i + 2];
//                    } else {
//                        code2[k][i] = code2[counter + 1][i + 2];
//                        code2[k][i + 1] = code2[counter][i];
//                    }
//                    i++;
//                    if (code2[counter][i] < code2[counter + 1][i + 2]) {
//                        code2[k][i+1] = code2[counter][i];
//                        code2[k][i + 2] = code2[counter + 1][i + 2];
//                    } else {
//                        code2[k][i+1] = code2[counter + 1][i + 2];
//                        code2[k][i + 2] = code2[counter][i];
//                    }
//                    i++;
//                    counter++;
//                }
//                //                k++;
////                code2[k][i] = code2[counter][i];
////                i++;
////                code2[k][i] = code2[counter][i];
////                i++;
////                counter++;
////                code2[k][i] = code2[counter][i];
////                i++;
////                code2[k][i] = code2[counter][i];
////                i++;
////                counter++;
////                k++;
//                if (i == code.length) {
//                    a = false;
//                }
//            }
//        } catch(ArrayIndexOutOfBoundsException ignored) {
//
//        }
//
//        System.out.println(Arrays.deepToString(code2));
//
//
//
//        try {
//            int first = 0;
//            int second = (code.length % 2 == 0) ? code.length/2 : code.length/2+1;
//
//            for (i = 0; i < code.length; i++) {
//
//            }
//        } catch (ArrayIndexOutOfBoundsException ignored) {
//
//        }
//        System.out.println(Arrays.deepToString(code2));
    }

    static void mergeSplit() {

    }

    static void merge() {

    }


}
