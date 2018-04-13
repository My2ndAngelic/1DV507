package eh223im_assign4;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {
    private T t;

    private int size; // Current size
    private Node head; // First node/element
    private Node tail;

    /**
     * Linked Queue constructor
     */
    public LinkedQueue() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Set the type of the elements in the linked queue
     *
     * @param t type of the linked queue
     */
    public void setT(T t) {
        this.t = t;
    }

    /**
     * Return type of the elements in the queue
     *
     * @return types of the elements in the queue
     */
    public T get() {
        return t;
    }

    /**
     * Return the size of the queue
     *
     * @return size of the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Return whether the queue is empty
     *
     * @return true if the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add element to the queue
     *
     * @param element is added into the queue
     */
    @Override
    public void enqueue(T element) {
        if (isEmpty()) {// Add first element
            head = new Node(element);
            size++;
            tail = head;
        } else {
            tail.next = new Node(element);
            tail = tail.next;
            size++;
        }
    }

    /**
     * Remove and return removed element from the queue
     * Remove the first element out of the queue
     *
     * @return removed element
     * @throws EmptyStackException if the queue is empty
     */
    @Override
    public T dequeue() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            Node node = head;
            T temp = node.getValue();
            node = node.next;
            head = node;
            size--;
            return temp;
        }
    }

    /**
     * Print the queue with format [1, 2, 3, ..., n]
     *
     * @return the string contains all the elements of the queue
     */
    @Override
    public String toString() {
        Node node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.getValue()).append(", ");
            node = node.next;
        }
        sb.replace(sb.length() - 2, sb.length() - 1, "]");
        return sb.toString();
    }

    /**
     * Return element at index, throw NoSuchElementException if empty, throw ArrayIndexOutOfBoundsException if index is larger than number of elements in the queue
     *
     * @param index position needed to find
     * @return elements needed
     */
    public T get(int index) {
//        checkIndex(index, size); // Exception if index outside [0, size −1]
        if (size == 0) {
            throw new NoSuchElementException("Element not found");
        } else if (index < size) {
            Node node = head;
            for (int i = 0; i < index; i++) // Move to index node
                node = node.next;
            return node.getValue();
        } else {
            throw new ArrayIndexOutOfBoundsException("Index out of bound");
        }
    }

    /**
     * Find the index of input element
     *
     * @param n is going to be search in the queue
     * @return first position of n
     * @throws NoSuchElementException if not found
     */
    public int indexOf(T n) throws NoSuchElementException {
        Node node = head;
        int index = 0;
        while (node != null) {
            if (node.getValue().equals(n)) {
                return index;
            } else {
                index++;
                node = node.next;
            }
        }
        throw new NoSuchElementException("Object not found");
    }

    /**
     * Return value of the first element of the queue
     *
     * @return value of the first element
     * @throws NoSuchElementException if empty
     */
    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list");
        } else {
            return head.value;
        }
    }

    /**
     * Return value of the last element of the queue
     *
     * @return value of the last element
     * @throws NoSuchElementException if empty
     */
    @Override
    public T last() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list");
        } else {
            return tail.value;
        }
    }

    /**
     * Enqueue a collection of elements
     *
     * @param col collection of elements
     */
    @Override
    public void enqueueAll(Iterable<T> col) {
        for (T t : col) {
            enqueue(t);
        }
    }

    /**
     * Iterating the queue
     *
     * @return new iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator<>();
    }

    private class Node { // Private inner Node class
        Node next = null;
        private T value;
        Node(T t) {
            setValue(t);
        }
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
    }

    class QueueIterator<T> implements Iterator<T> { // Inner iterator class
        private Node node = head; // First node is head
        public QueueIterator() {

        }
        public T next() {
            if (hasNext()) {
                T val = (T) node.value; // Read current value
                node = node.next; // Move one step ahead
                return val;
            } else {
                return null;
            }
        }

        public boolean hasNext() {
            return node != null;
        }

        public void remove() {
            throw new RuntimeException("remove() is not implemented");
        }
    }
}
