/**
 * It will work somehow, especially with enqueue and dequeue.
 * Abusing if condition would not be a good idea.
 * I will write a LaTeX document to explain how this works.
 * Known bug:
 *  - Empty queue will be reset on the next enqueue/dequeue call.
 */

package eh223im_assign2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Modified slightly from Linked Queue
 * It will not work, I am not sure why.
 * */
public class CircularQueue implements Queue {

    CircularQueue() {
        size = 0;
        first = 0;
        last = -1;
        queue = new Object[10];
    }

    private int size;

    private Object[] queue;

    private int first;

    /**
     * Return the first index position.
     * @return first index in the queue.
     */
    public int getFirstIndex() {
        return first;
    }


    private int last;

    /**
     * Return the last index position
     * @return last index position in the array.
     */
    public int getLastIndex() {
        return last;
    }

    /**
     * Get the current queue size.
     * @return current queue size.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Check if the array is empty.
     * @return true if empty, false otherwise,
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    // Not ready yet
    public int indexOf(Object n) {
        return 0;
    }

    // NOt ready
    public int get(Object n) {
        return 0;
    }

    private void reset() {
        size = 0;
        first = 0;
        last = -1;
        queue = new Object[10];
    }

    private void resize() {
        ArrayList <Object> al = new ArrayList <>();
        if (last < first) {
            al.addAll(Arrays.asList(queue).subList(first, queue.length));
            al.addAll(Arrays.asList(queue).subList(0, last));
            queue = al.toArray();
            first = 0;
            last = queue.length - 1;
            size = queue.length;
            Object[] temp = new Object[size * 2];
            System.arraycopy(queue, 0, temp, 0, queue.length);
            queue = temp;
        } else {
            al.addAll(Arrays.asList(queue).subList(first,last));
            queue = al.toArray();
            first = 0;
            last = queue.length - 1;
        }
    }

    /**
     * Add element to the last position of the queue,
     * resize if the Object array field if the length is limited.
     * @param element add the element to the last position of the array.
     */
    @Override
    public void enqueue(Object element) {
        if (isEmpty()) {
            first = 0;
            last = 0;
            queue[last] = element;
            size = 1;
        } else if (first == 0) {
            if (last < queue.length - 1) {
                last++;
                queue[last] = element;
                size++;
            } else {
                Object[] temp = new Object[size * 2];
                System.arraycopy(queue, 0, temp, 0, queue.length);
                queue = temp;
                last++;
                queue[last] = element;
                size++;
            }
        } else {
            if (last < first - 1) {
                last++;
                queue[last] = element;
                size++;
            } else if (last < queue.length - 1) {
                last++;
                queue[last] = element;
                size++;
            } else if (last == queue.length - 1){
                last = 0;
                queue[last] = element;
                size++;
            } else {
                Object[] temp = new Object[queue.length*2];
                System.arraycopy(queue,first,temp,0,last+1);
                temp[last] = element;
                queue = temp;
                last++;
                size++;
            }
        }
    }

    /**
     * Remove the first element from the queue and return the dequeue element
     * @return the removed element
     * @throws IndexOutOfBoundsException if the queue is empty.
     */
    @Override
    public Object dequeue() throws IndexOutOfBoundsException {
        Object tempO = queue[first];
        if (isEmpty()) {
            reset();
            throw new IndexOutOfBoundsException("Empty queue");
        } else if (first < queue.length) {
            queue[first] = null;
            first++;
            size--;
            return tempO;
        } else if (first == queue.length) {
            if (first < last) {
                queue[first] = null;
                first++;
                size--;
                return tempO;
            } else if (first > last) {
                queue[first] = null;
                first = 0;
                size--;
                return tempO;
            }
            else {
                reset();
                return tempO;
            }
        } else {
            Object[] temp = new Object[queue.length];
            System.arraycopy(queue, 0,temp,0,last+1);
            queue = temp;
            first = 0;
            size--;
            last = size;
            return tempO;
        }
    }

    /**
     * Get the first element in the queue.
     * @return first element in the queue
     * @throws IndexOutOfBoundsException if the queue is empty.
     */
    @Override
    public Object first() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty queue.");
        } else {
            return queue[first];
        }
    }

    /**
     * Get the last element in the queue.
     *
     * @return last element in the queue
     * @throws IndexOutOfBoundsException if the queue is empty.
     */
    @Override
    public Object last() throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty queue.");
        } else {
            return queue[last];
        }
    }

    /**
     * Print all the element in the queue with the fixed format: [first, second, ..., last]
     *
     * @return string contains all elements in the queue.
     */
    @Override
    public String toString() {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (first  < last) {
            for (int i = first; i<size; i++) {
                sb.append(queue[i]).append(", ");
            }
        } else {
            for (int i = first; i<size; i++) {
                sb.append(queue[i]).append(", ");
            }
            for (int i = 0; i==last; i++) {
                sb.append(queue[i]).append(", ");
            }
        }
        sb.replace(sb.length()-2, sb.length()-1, "]");
        return sb.toString();
    }

    /**
     * Iterate the queue
     *
     * @return new method to iterate the queue.
     */
    @Override
    public Iterator <Object> iterator() {
        return new QueueIterator <>(queue, size);
    }

    class QueueIterator<Object> implements Iterator <Object> {
        private Object[] objects;
        private int max;             // final element in array
        private int nextElement = 0;      // first element at start

        public QueueIterator(Object[] obj, int maxIndex) {
            objects = obj;
            max = maxIndex;
        }

        public boolean hasNext() {
            return nextElement < max;
        }

        public Object next() {
            return objects[nextElement++];  // Pick out and increase
        }
    }
}


