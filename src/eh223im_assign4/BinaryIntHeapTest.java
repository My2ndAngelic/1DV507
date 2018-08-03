package eh223im_assign4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryIntHeapTest {

    // Samples names reflects their nature, all have value up to 100 and sizes 100, except zeroOne.
    private int[] sampleArray = {15, 40, 96, 20, 25, 43, 23, 80, 70, 28, 90, 29, 78, 39, 64, 17, 93, 9, 46, 21, 32, 41, 33, 26, 34, 8, 94, 38, 85, 58, 2, 71, 18, 97, 100, 74, 53, 92, 51, 82, 57, 4, 13, 47, 50, 61, 99, 83, 55, 7, 22, 76, 14, 36, 16, 42, 19, 59, 30, 91, 77, 52, 68, 65, 24, 87, 48, 6, 84, 31, 60, 62, 56, 79, 66, 45, 89, 54, 27, 37, 69, 63, 1, 35, 86, 5, 10, 88, 95, 75, 49, 72, 3, 73, 81, 11, 44, 98, 67, 12};

    static boolean isHeap(int[] heap) {
        for (int i = 0; i<(heap.length - 2) / 2;i++) {
            if (heap[i] < heap[(i+1)*2]-1 || heap[i] < heap[(i+1)*2]) return false;
        }
        return true;
    }

    @Test
    void insert() {
        BinaryIntHeap bih1 = new BinaryIntHeap();
        assertTrue(bih1.isEmpty());
        for (int i : sampleArray) {
            bih1.insert(i);
        }
        assertTrue(isHeap(bih1.printArray()));
    }

    @Test
    void pullHighest() {
        BinaryIntHeap bih1 = new BinaryIntHeap();
        for (int i : sampleArray) {
            bih1.insert(i);
        }
        int[] a = Arrays.copyOf(sampleArray,sampleArray.length);
        for (int i = 0; i<sampleArray.length;i++) {
            a[i] = bih1.pullHighest();
            assertTrue(isHeap(bih1.printArray()));
        }
        for (int i = 0; i<sampleArray.length-1;i++) {
            assertTrue(a[i] > a[i+1]);
        }
    }

    @Test
    void size() {
        BinaryIntHeap bih1 = new BinaryIntHeap();
        assertEquals(0, bih1.size());
        for (int i = 0; i< sampleArray.length; i++) {
            bih1.insert(i);
            assertEquals(i+1,bih1.size());
        }
        for (int i = 0; i< sampleArray.length; i++) {
            bih1.pullHighest();
            assertEquals(sampleArray.length - 1 - i,bih1.size());
        }
        assertEquals(0, bih1.size());
    }

    @Test
    void isEmpty() {
        BinaryIntHeap bih1 = new BinaryIntHeap();
        assertTrue(bih1.isEmpty());
        for (int i = 0; i< sampleArray.length; i++) {
            bih1.insert(i);
            assertFalse(bih1.isEmpty());
        }
        for (int aPositiveOnly : sampleArray) {
            assertFalse(bih1.isEmpty());
            bih1.pullHighest();
        }
        assertTrue(bih1.isEmpty());
    }
}