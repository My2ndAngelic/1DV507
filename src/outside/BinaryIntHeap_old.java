package eh223im_assign4;

import eh223im_assign4.data_structure.BinaryHeapInterface;

import java.util.Arrays;

public class BinaryIntHeap_old implements BinaryHeapInterface {
    private int size;

    private int[] keyList; //Key storage of BIH

    private class Node {
        public int value;
        Node left;
        Node right;
    }

    private Node tree; // Tree storage

    /**
     * Create new Binary Heap
     */
    BinaryIntHeap_old() {
        tree = null;
        size = 0;
        keyList = new int[10];
    }


    /**
     * Insert integer into the tree
     * @param n integer insert to tree
     */
    @Override
    public void insert(int n) {
        //Temporary node
        Node inserting = new Node();
        inserting.value = n;
        inserting.left = null;
        inserting.right = null;

        //Add to tree (first stage, when nothing is empty
        if (isEmpty()) {
            tree = inserting;
        } else {
            while (tree != null) {
                if (inserting.value < tree.right.value) {
                    tree = tree.right;
                } else {
                    tree = tree.left;
                }
            }
        }

        // Add to array after add to tree
        keyList[size] = n;
        size++;

        traverseUp();

        // Expand if full
        arrayCheck();
    }

    private void traverseUp() {

    }

    private void traverseDown() {

    }

    // Swap two item in the keys array
    private void swapItem(int indexA, int indexB) {
        int k = keyList[indexA];
        keyList[indexA] = indexB;
        keyList[indexB] = k;
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
    public int pullHighest() throws RuntimeException{
        if (isEmpty()) {
            throw new RuntimeException("Empty tree");
        } else {
            int k = tree.value;
            traverseDown();
            return k;
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
}
