package eh223im_assign2;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class LinkedQueueTest {

    @org.junit.jupiter.api.Test
    void size() {
        // New queue
        LinkedQueue lq = new LinkedQueue();
        // Check initial = 0
        assertEquals(0, lq.size());

        lq.enqueue(1);
        assertEquals(1, lq.size());

        for (int i = 0; i < 999; i++) {
            lq.enqueue(i);
        }

        // Check if 1000 items added
        assertEquals(1000, lq.size());

        // Add the random number of items
        int k = new Random().nextInt(10 ^ 7);
        for (int i = 0; i < k; i++) {
            lq.enqueue(i);
        }
        assertEquals(1000 + k, lq.size());

        // Dequeue them
        for (int i = 0; i < k; i++) {
            lq.dequeue();
        }
        assertEquals(1000, lq.size());

        // Dequeue to 1
        for (int i = 0; i < 999; i++) {
            lq.dequeue();
        }
        assertEquals(1, lq.size());

        // Empty
        lq.dequeue();
        assertEquals(0, lq.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        // New queue
        LinkedQueue lq = new LinkedQueue();
        // Check initial = 0
        assertEquals(true, lq.isEmpty());

        lq.enqueue(1);
        assertEquals(false, lq.isEmpty());

        for (int i = 0; i < 999; i++) {
            lq.enqueue(i);
        }

        // Check if 1000 items added
        assertEquals(false, lq.isEmpty());

        // Add the random number of items
        int k = new Random().nextInt(10 ^ 7);
        for (int i = 0; i < k; i++) {
            lq.enqueue(i);
        }
        assertEquals(false, lq.isEmpty());

        // Dequeue them
        for (int i = 0; i < k; i++) {
            lq.dequeue();
        }
        assertEquals(false, lq.isEmpty());

        // Dequeue to 1
        for (int i = 0; i < 999; i++) {
            lq.dequeue();
        }
        assertEquals(false, lq.isEmpty());

        // Empty
        lq.dequeue();
        assertEquals(true, lq.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void enqueue() {

    }

    @org.junit.jupiter.api.Test
    void dequeue() {
        // New queue
        LinkedQueue lq = new LinkedQueue();
        // Check initial = 0
        try {
            lq.dequeue();
            fail("");
        } catch (EmptyStackException e) {
            // expected
        }

        lq.enqueue(1);
        assertEquals(1, lq.dequeue());

        for (int i = 0; i < 999; i++) {
            lq.enqueue(i);
        }

        // Check if 1000 items added
        assertEquals(0, lq.dequeue());

        // Add the random number of items
        final int k = new Random().nextInt(10 ^ 7) + 5;
        for (int i = 0; i < k; i++) {
            lq.enqueue(i);
        }
        assertEquals(1, lq.dequeue());

        // Dequeue them
        for (int i = 0; i < k - 3; i++) {
            lq.dequeue();
        }
        assertEquals(k - 1, lq.dequeue());

        // Dequeue to 1
        for (int i = 0; i < 998; i++) {
            lq.dequeue();
        }
        assertEquals(k - 1, lq.dequeue());

        // Empty
        try {
            lq.dequeue();
            fail("");
        } catch (EmptyStackException e) {
            //expected
        }
    }

//    @Override
//    @org.junit.jupiter.api.Test
//    private void toString() {
//    }

    @org.junit.jupiter.api.Test
    void get() {
        // New queue
        LinkedQueue lq = new LinkedQueue();

        // Check initial = 0
        try {
            lq.get(0);
            fail("");
        } catch (IndexOutOfBoundsException e) {
            // expected
        }

        // Check
        lq.enqueue(1);
        assertEquals(1, lq.get(0));

        try {
            lq.get(1);
            fail("");
        } catch (IndexOutOfBoundsException e) {
            // expected
        }

        for (int i = 0; i < 999; i++) {
            lq.enqueue(i);
        }

        // Check if 1000 items added
        assertEquals(1, lq.get(0));

        // Add the random number of items
        final int k = new Random().nextInt(10 ^ 7) + 5;
        for (int i = 0; i < k; i++) {
            lq.enqueue(i);
        }
        assertEquals(1, lq.get(0));

        // Dequeue them
        for (int i = 0; i < k - 3; i++) {
            lq.dequeue();
        }

        assertEquals(k - 3, lq.get(1));

        // Dequeue to 1
        for (int i = 0; i < 998; i++) {
            lq.dequeue();
        }
        assertEquals(k-5,lq.get(0));

        // Empty
        try {
            lq.get(15);
            fail("");
        } catch (IndexOutOfBoundsException e) {
            //expected
        }
    }

    @org.junit.jupiter.api.Test
    void indexOf () {
        // New queue
        LinkedQueue lq = new LinkedQueue();

        // Check initial = 0
        try {
            lq.indexOf(0);
            fail("");
        } catch (NoSuchElementException e) {
            // expected
        }

        // Check
        lq.enqueue(1);
        assertEquals(0, lq.indexOf(1));

        try {
            lq.indexOf(10);
            fail("");
        } catch (NoSuchElementException e) {
            // expected
        }

        for (int i = 0; i < 999; i++) {
            lq.enqueue(i);
        }

        // Check if 1000 items added
        assertEquals(991, lq.indexOf(990));

        // Add the random number of items
        final int k = new Random().nextInt(10 ^ 7) + 5;
        for (int i = 0; i < k; i++) {
            lq.enqueue(i);
        }
        assertEquals(k - 2, lq.indexOf(k - 3));

        // Dequeue them
        for (int i = 0; i < k - 3; i++) {
            lq.dequeue();
        }
        assertEquals(1000 - (k - 2), lq.indexOf(998));

        // Dequeue
        for (int i = 0; i < 998; i++) {
            lq.dequeue();
        }
        assertEquals(k - 5, lq.get(0));

        // Out of bound check again
        try {
            lq.indexOf(15);
            fail("");
        } catch (NoSuchElementException e) {
            //expected
        }
    }

    @org.junit.jupiter.api.Test
    void first() {
        // New queue
        LinkedQueue lq = new LinkedQueue();

        // Check initial = 0
        try {
            lq.first();
            fail("");
        } catch (NoSuchElementException e) {
            // expected
        }

        // Check
        lq.enqueue(1);
        assertEquals(1, lq.first());

        for (int i = 0; i < 999; i++) {
            lq.enqueue(i);
        }

        // Check if 1000 items added
        assertEquals(1, lq.first());

        // Add the random number of items
        final int k = new Random().nextInt(100) + 5;
        for (int i = 0; i < k; i++) {
            lq.enqueue(i);
        }
        assertEquals(1, lq.first());

        // Dequeue them
        for (int i = 0; i < k - 3; i++) {
            lq.dequeue();
        }
        assertEquals(k-4, lq.first());

        // Dequeue
        for (int i = 0; i < 998; i++) {
            lq.dequeue();
        }
        assertEquals(k-5, lq.first());

        while (lq.size() > 0) {
            lq.dequeue();
        }

        // Empty
        try {
            lq.first();
            fail("");
        } catch (NoSuchElementException e) {
            //expected
        }
    }

    @org.junit.jupiter.api.Test
    void last() {
        // New queue
        LinkedQueue lq = new LinkedQueue();

        // Check initial = 0
        try {
            lq.last();
            fail("");
        } catch (NoSuchElementException e) {
            // expected
        }

        // Check
        lq.enqueue(1);
        assertEquals(1, lq.last());

        for (int i = 0; i < 999; i++) {
            lq.enqueue(i);
        }

        // Check if 1000 items added
        assertEquals(998, lq.last());

        // Add the random number of items
        final int k = new Random().nextInt(100) + 5;
        for (int i = 0; i < k; i++) {
            lq.enqueue(i);
        }
        assertEquals(k-1, lq.last());

        // Dequeue them
        for (int i = 0; i < k - 3; i++) {
            lq.dequeue();
        }
        assertEquals(k-1, lq.last());

        // Dequeue
        for (int i = 0; i < 998; i++) {
            lq.dequeue();
        }
        assertEquals(k-1, lq.last());

        // Empty
        while (lq.size() > 0) {
            lq.dequeue();
        }

        // Empty
        try {
            lq.last();
            fail("");
        } catch (NoSuchElementException e) {
            //expected
        }
    }
}