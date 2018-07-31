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
public class BinaryIntHeap_new implements BinaryHeapInterface{
    private int size;

    private int[] keyList; //Key storage of BIH

    /**
     * Create new Binary Heap
     */
    BinaryIntHeap_new() {
        size = 0;
        keyList = new int[10];
    }


    /**
     * Insert integer into the tree
     * @param n integer insert to tree
     */
    @Override
    public void insert(int n) {
        keyList[size] = n;
        size++;
        traverseUp();
        arrayCheck();
    }

    // Swap up after insert
    private void traverseUp() {
        int i = size-1;
        while(hasParent(i)) {
            if (keyList[i]>getParentValue(i)) {
                swapItem(i, getParentIndex(i));
            }
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
        int i = 0, state = 0;
        while (state >= 0) { //Check if children exist
            if (hasLeftChild(i)) {
                if(keyList[i] < getLeftChildValue(i)) {
                    state = 0;
                }
                if(hasRightChild(i)) {
                    if (getLeftChildValue(i) < getRightChildValue(i)) {
                        state = 1;
                    }
                }
            } else {
                state = -1;
            }

            switch (state) { // Check the state, then do it
                case 0:     swapItem(i,getLeftChildIndex(i));
                            i = getLeftChildIndex(i);
                            break;
                case 1:     swapItem(i,getRightChildIndex(i));
                            i = getRightChildIndex(i);
                            break;
                default:    break;
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

    /**
     * Output array
     * @return array of the heap
     */
    public int[] printArray() {
        int[] out = new int[size];
        for (int i = 0; i<size; i++) {
            out[i] = keyList[i];
        }
        return out;
    }


    // Utility functions: Parent
    private int getParentIndex(int child) {return Math.floorDiv(child-1,2);}
    private int getParentValue(int child) {return keyList[getParentIndex(child)];}
    private boolean hasParent(int child) {return getParentIndex(child) >= 0;}
    // Utility functions: Left child
    private int getLeftChildIndex(int parent) {return (parent+1)*2-1;}
    private int getLeftChildValue(int parent) {return keyList[getLeftChildIndex(parent)];}
    private boolean hasLeftChild(int parent){return getLeftChildIndex(parent) <= size-1;}
    // Utility functions: Right child
    private int getRightChildIndex(int parent) {return (parent+1)*2;}
    private int getRightChildValue(int parent) {return keyList[getRightChildIndex(parent)];}
    private boolean hasRightChild(int parent){return getRightChildIndex(parent) <= size-1;}
    // Utility function: swapping item
    private void swapItem(int indexA, int indexB) {
        int temp = keyList[indexA];
        keyList[indexA] = keyList[indexB];
        keyList[indexB] = temp;
    }
}
