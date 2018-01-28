package eh223im_assign1.da1031;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {
    @Override
    public void push(int n) {
        int[] temp = new int[size+1];
        System.arraycopy(values,0,temp,1,size);
        temp[size] = n;
        values = temp;
        size++;
    }

    @Override
    // Throw exception if size = 0, else resize
    public int pop() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            int[] temp = new int[size - 1];
            int k = values[0];
            System.arraycopy(values,1,temp,0,size);
            return k;
        }
    }

    @Override
    public int peek() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            return values[0];
        }
    }
}
