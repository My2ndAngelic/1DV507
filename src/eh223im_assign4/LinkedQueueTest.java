package eh223im_assign4;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

    private LinkedQueue<String> STR = new LinkedQueue<>();
    private LinkedQueue<Integer> INT = new LinkedQueue<>();

    @org.junit.jupiter.api.Test
    void setT() {

    }

    @org.junit.jupiter.api.Test
    void get() {
        System.out.println(STR.size());
    }

    @org.junit.jupiter.api.Test
    void size() {
        STR.enqueue("Hi");
        STR.enqueue("Hi");
        assertEquals(STR.size(),2);

        INT.enqueue(5);
        INT.enqueue(9);
        assertEquals(INT.size(),2);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void enqueue() {
    }

    @org.junit.jupiter.api.Test
    void dequeue() {
    }

//    @org.junit.jupiter.api.Test
//    void toString() {
//    }

    @org.junit.jupiter.api.Test
    void get1() {
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
    }

    @org.junit.jupiter.api.Test
    void first() {
    }

    @org.junit.jupiter.api.Test
    void last() {
    }

    @org.junit.jupiter.api.Test
    void enqueueAll() {
    }

    @org.junit.jupiter.api.Test
    void iterator() {
    }
}