package eh223im_assign4;

public class BinaryIntHeap implements BinaryHeapInterface {
    private int size;

    private class Node {
        private int value;

        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            Node left;
            Node right; 

        }
    }


    BinaryIntHeap() {
        size = 0;

    }

    @Override
    public void insert(int n) {

    }

    @Override
    public int pullHighest() {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
