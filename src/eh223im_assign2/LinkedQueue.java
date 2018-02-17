package eh223im_assign2;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.checkIndex;

/**
 * Adopted from example on the class
 */
public class LinkedQueue implements Queue {
    private int size; // Current size
    private Node head; // First node/element

    private class Node { // Private inner Node class
        Object value;
        Node next = null;

        Node(Object o) {
            value = o;
        }
    }

    /**
     * Linked Queue constructor
     */
    LinkedQueue() {
        size = 0;
        head = null;
    }

    /**
     * Return the size of the queue
     * @return size of the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Return whether the queue is empty
     * @return true if the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add element to the queue
     * @param element is added into the queue
     */
    @Override
    public void enqueue(Object element) {
        if (head == null) {// Add first element
            head = new Node(element);
            size++;
        }
        else {
            Node node = head;
            while (node.next != null) { // Find last node
                node = node.next;
            }
            node.next = new Node(element); // Attach new node
            size++;
        }
    }

    /**
     * Remove and return removed element from the queue
     * Remove the first element out of the queue
     * @throws EmptyStackException if the queue is empty
     * @return removed element
     */
    @Override
    public Object dequeue() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            Node node = head;
            Object temp = node.value;
            node = node.next;
            head = node;
            size--;
            return temp;
        }
    }

    /**
     * Print the queue with format [1, 2, 3, ..., n]
     * @return the string contains all the elements of the queue
     */
    @Override
    public String toString() {
        Node node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.value).append(", ");
            node = node.next;
        }
        sb.replace(sb.length()-2,sb.length()-1,"]");
        return sb.toString();
    }

    /**
     * Find the element value of input index
     * @param index is the position of such element
     * @return value of the element
     * @throws IndexOutOfBoundsException if index is larger than size of queue
     */
    public Object get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size); // Exception if index outside [0, size −1]
        Node node = head;
        for (int i = 0; i < index; i++) // Move to index node
            node = node.next;
        return node.value;
    }

    /**
     * Find the index of input element
     * @param n is going to be search in the queue
     * @return first position of n
     * @throws NoSuchElementException if not found
     */
    public int indexOf(Object n) throws NoSuchElementException {
        Node node = head;
        int index = 0;
        while (node != null) {
            if (node.value.equals(n)) {
                return index;
            }
            index++;
            node = node.next;
        }
        throw new NoSuchElementException("Object not found");
    }

    /**
     * Return value of the first element of the queue
     * @return value of the first element
     * @throws NoSuchElementException if empty
     */
    @Override
    public Object first() {
        Node node = head;
        if (size == 0) {
            throw new NoSuchElementException("Empty list");
        } else {
            return node.value;
        }
    }

     /**
      * Return value of the last element of the queue
      * @return value of the last element
      * @throws NoSuchElementException if empty
      */
    @Override
    public Object last() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list");
        } else {
            Node node = head;
            for (int i = 0; i < size-1; i++) {
                node = node.next;
            }
            return node.value;
        }
    }

    /**
     * Iterating the queue
     * @return new iterator
     */
    @Override
    public Iterator <Object> iterator() {
        return new QueueIterator();
    }

    class QueueIterator implements Iterator <Object> { // Inner iterator class
        private Node node = head; // First node is head

        public Object next() {
            Object val = node.value; // Read current value
            node = node.next; // Move one step ahead
            return val;
        }

        public boolean hasNext() {
            return node != null;
        }

        public void remove() {
            throw new RuntimeException("remove() is not implemented");
        }
    }
}
