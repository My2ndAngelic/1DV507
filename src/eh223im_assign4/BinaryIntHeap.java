package eh223im_assign4;

import java.util.Arrays;

/**
 * Implementation method: Max Heap
 * Resource used:
 * >Textbook in class
 * >https://www.geeksforgeeks.org/binary-heap/
 * >https://www.youtube.com/watch?v=t0Cq6tVNRBA
 * Since array starts counting at 0, n-th element counts has position (n-1).
 */
public class BinaryIntHeap implements BinaryHeapInterface{
    private int size;

    private int[] keyList; //Key storage of BIH

    /**
     * Create new Binary Heap
     */
    BinaryIntHeap() {
        size = 0;
        keyList = new int[10];
    }


    /**
     * Insert integer into the tree
     * @param n integer insert to tree
     */
    @Override
    public void insert(int n) {
        arrayCheck();
        keyList[size] = n;
        size++;
        traverseUp();
    }

    // Swap up after insert
    private void traverseUp() {
        int i = size-1;
        while(hasParent(i) && keyList[i]>getParentValue(i)) {
            swapItem(i, getParentIndex(i));
            i = getParentIndex(i);
        }
    }

    // Expand if full
    private void arrayCheck() {
        if (size == keyList.length) {
            keyList = Arrays.copyOf(keyList, keyList.length * 2);
        }
    }

    /**
     * Return highest element in the tree
     * @return value of the highest element
     * @throws RuntimeException if empty
     */
    @Override
    public int pullHighest() throws IllegalArgumentException{
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty heap");
        } else { // Replace with the last element then traverse down
            int k = keyList[0];
            keyList[0] = keyList[size-1];
            size--;
            traverseDown();
            return k;
        }
    }

    // Swap down after delete
    private void traverseDown() {
        int i = 0, state = -1;
        while (hasLeftChild(i)) { // Repeat until no left child
            int maxChild = 0;
            if (hasRightChild(i) && getLeftChildValue(i) < getRightChildValue(i)) {
                maxChild = 1;
            }
            if (maxChild == 0) {
                if (getLeftChildValue(i) > keyList[i]) {
                    swapItem(i, getLeftChildIndex(i));
                }
                i = getLeftChildIndex(i);
            } else {
                if (getRightChildValue(i) > keyList[i]) {
                    swapItem(i, getRightChildIndex(i));
                }
                i = getRightChildIndex(i);
            }
        }
    }

    /**
     * Return size of the tree
     * @return size of the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Check if tree is empty
     * @return true if empty
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public int[] printArray() {
        int[] a = new int[size];
        System.arraycopy(keyList, 0, a, 0, size);
        return a;
    }


    // Utility functions: Parent
    private int getParentIndex(int child) {return (child - 1) / 2;}
    private int getParentValue(int child) {return keyList[getParentIndex(child)];}
    private boolean hasParent(int child) {return getParentIndex(child) >= 0;}
    // Utility functions: Left child
    private int getLeftChildIndex(int parent) {return (parent*2)+1;}
    private int getLeftChildValue(int parent) {return keyList[getLeftChildIndex(parent)];}
    private boolean hasLeftChild(int parent){return getLeftChildIndex(parent) < size;}
    // Utility functions: Right child
    private int getRightChildIndex(int parent) {return (parent*2)+2;}
    private int getRightChildValue(int parent) {return keyList[getRightChildIndex(parent)];}
    private boolean hasRightChild(int parent){return getRightChildIndex(parent) < size;}
    // Utility function: swapping item
    private void swapItem(int indexA, int indexB) {
        int temp = keyList[indexA];
        keyList[indexA] = keyList[indexB];
        keyList[indexB] = temp;
    }
}
