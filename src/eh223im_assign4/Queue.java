package eh223im_assign4;

import java.util.Iterator;

public interface Queue<T> {
    int size();                     // current queue size

    boolean isEmpty();              // true if queue is empty

    void enqueue(T element);   // add element at end of queue

    T dequeue();               // return and remove first element.

    T first();                 // return (without removing) first element

    T last();                  // return (without removing) last element

    String toString();              // return a string representation of the queue content

    Iterator<T> iterator();    // element iterator

    void enqueueAll(Iterable<T> col);
}
