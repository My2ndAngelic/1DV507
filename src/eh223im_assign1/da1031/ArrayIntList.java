package eh223im_assign1.da1031;

//Implementation of IntList

public class ArrayIntList extends AbstractIntCollection implements IntList {

    /* Add integer n to the end of the list. */
    public void add(int n) {
        values[size++] = n;
        resize();
    }

    /* Inserts integer n at position index. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right.  */
    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException {
        try {
            int[] temp = new int[super.size + 1];
            System.arraycopy(super.values, 0, temp, 0, index);
            temp[index] = n;
            System.arraycopy(super.values, index, temp, index + 1, size - index);
            super.values = temp;
            size++;
            resize();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    /* Remove integer at position index. */
    // Create a temp array, copy all from 0 to index to temp-1, copy the rest to temp without the element at index, reassign
    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            int[] temp = new int[super.size - 1];
            System.arraycopy(super.values, 0, temp, 0, index);
            System.arraycopy(super.values, index + 1, temp, index, size - index - 1);
            super.values = temp;
            size--;
        }
    }

    /* Get integer at position index. */
    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if (index < size) {
            return super.values[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /* Number of integers currently stored. */
    @Override
    public int size() {
        return size;
    }

    /* Returns true if collection is empty. */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /* Find position of integer n, otherwise return -1 */
    @Override
    public int indexOf(int n) {
        for (int i = 0; i < size - 1; i++) {
            if (super.values[i] == n) {
                return i;
            }
        }
        return -1;
    }

//    public String toString() {
//        return super.toString();
//    }
}