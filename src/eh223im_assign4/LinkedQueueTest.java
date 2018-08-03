package eh223im_assign4;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

    private LinkedQueue<String> STR = new LinkedQueue<>();
    private LinkedQueue<Integer> INT = new LinkedQueue<>();

    //Test sample: List of counties in JSON | https://gist.github.com/keeguon/2310008 (self-generated)
    private final String[] world = {"AD","AE","AF","AG","AI","AL","AM","AO","AQ","AR","AS","AT","AU","AW","AX","AZ","BA","BB","BD","BE","BF","BG","BH","BI","BJ","BL","BM","BN","BO","BQ","BR","BS","BT","BV","BW","BY","BZ","CA","CC","CD","CF","CG","CH","CI","CK","CL","CM","CN","CO","CR","CU","CV","CW","CX","CY","CZ","DE","DJ","DK","DM","DO","DZ","EC","EE","EG","EH","ER","ES","ET","FI","FJ","FK","FM","FO","FR","GA","GB","GD","GE","GF","GG","GH","GI","GL","GM","GN","GP","GQ","GR","GS","GT","GU","GW","GY","HK","HM","HN","HR","HT","HU","ID","IE","IL","IM","IN","IO","IQ","IR","IS","IT","JE","JM","JO","JP","KE","KG","KH","KI","KM","KN","KP","KR","KW","KY","KZ","LA","LB","LC","LI","LK","LR","LS","LT","LU","LV","LY","MA","MC","MD","ME","MF","MG","MH","MK","ML","MM","MN","MO","MP","MQ","MR","MS","MT","MU","MV","MW","MX","MY","MZ","NA","NC","NE","NF","NG","NI","NL","NO","NP","NR","NU","NZ","OM","PA","PE","PF","PG","PH","PK","PL","PM","PN","PR","PS","PT","PW","PY","QA","RE","RO","RS","RU","RW","SA","SB","SC","SD","SE","SG","SH","SI","SJ","SK","SL","SM","SN","SO","SR","SS","ST","SV","SX","SY","SZ","TC","TD","TF","TG","TH","TJ","TK","TL","TM","TN","TO","TR","TT","TV","TW","TZ","UA","UG","UM","US","UY","UZ","VA","VC","VE","VG","VI","VN","VU","WF","WS","XK","YE","YT","ZA","ZM","ZW"};
    private final String[] random100Country  = new String[100];
    //Test samples: Number (self-generated)
    private int[] smallInt = new int[100];
    private int[] mediumInt = new int[10000];

    // Select random counties
    private static String[] worldSelector(String[] strings, int req) {
        String[] s = new String[req];
        for (int i = 0; i<req; i++) {
            s[i] = strings[new Random().nextInt(strings.length - 1)];
        }
        return s;
    }

    @org.junit.jupiter.api.Test
    void get() {
        // String
        // // Empty
        assertThrows(NoSuchElementException.class, () -> STR.get(0));
        // // Big case
        STR.enqueueAll(Arrays.asList(world));
        for (String aWorld : world) {
            int k = new Random().nextInt(world.length - 1);
            assertEquals(world[k], STR.get(k));
        }

        // Integer
        // // Empty
        assertEquals(INT.size(),0);
        // // Small case
        INT.enqueueAll(IntStream.of(TestKit.intGenerator(smallInt, -100, 100)).boxed().collect(Collectors.toList()));
        for (int aSmallInt : smallInt) {
            int k = new Random().nextInt(smallInt.length - 1);
            assertEquals(String.valueOf(smallInt[k]), String.valueOf(INT.get(k)));
        }
        for (int i : smallInt) {
            INT.dequeue();
        }
        // // Empty again
        assertThrows(NoSuchElementException.class, () -> INT.get(10));
    }

    @org.junit.jupiter.api.Test
    void size() {
        // String
        // // Empty
        assertEquals(STR.size(),0);
        // // Big case
        STR.enqueueAll(Arrays.asList(world));
        assertEquals(STR.size(),250);
        // // Small case
        int i = STR.size();
        for (int k = 0; k<i;k++) {
            STR.dequeue();
        }
        STR.enqueueAll(Arrays.asList(worldSelector(world, 100)));
        assertEquals(STR.size(),100);

        // Integer
        // // Empty
        assertEquals(INT.size(),0);
        // // Small case
        INT.enqueueAll(IntStream.of(TestKit.intGenerator(smallInt, -100, 100)).boxed().collect(Collectors.toList()));
        assertEquals(INT.size(),100);
        // // Medium case
        i = INT.size();
        for (int k = 0; k<i;k++) {
            INT.dequeue();
        }
        INT.enqueueAll(IntStream.of(TestKit.intGenerator(mediumInt, -10000, 10000)).boxed().collect(Collectors.toList()));
        assertEquals(INT.size(),10000);

        for (int k = 0; k<i;k++) {
            INT.dequeue();
        }
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        // String
        // // Empty
        assertTrue(STR.isEmpty());
        // // Big case
        STR.enqueueAll(Arrays.asList(world));
        assertFalse(STR.isEmpty());
        // // Small case
        int i = STR.size();
        for (int k = 0; k<i;k++) {
            STR.dequeue();
        }
        assertTrue(STR.isEmpty());
        STR.enqueueAll(Arrays.asList(worldSelector(world, 100)));
        assertFalse(STR.isEmpty());

        // Integer
        // // Empty
        assertTrue(INT.isEmpty());
        // // Small case
        INT.enqueueAll(IntStream.of(TestKit.intGenerator(smallInt, -100, 100)).boxed().collect(Collectors.toList()));
        assertFalse(INT.isEmpty());
        // // Medium case
        i = INT.size();
        for (int k = 0; k<i;k++) {
            INT.dequeue();
        }
        assertTrue(INT.isEmpty());
        INT.enqueueAll(IntStream.of(TestKit.intGenerator(mediumInt, -10000, 10000)).boxed().collect(Collectors.toList()));
        assertFalse(INT.isEmpty());
        // // Big case
        i = INT.size();
        for (int k = 0; k<i;k++) {
            INT.dequeue();
        }
        assertTrue(INT.isEmpty());

    }

    @org.junit.jupiter.api.Test
    void dequeue() {
        // String
        // // Empty
        assertThrows(EmptyStackException.class, () -> STR.dequeue());
        // // Each and every element
        STR.enqueueAll(Arrays.asList(world));
        for (String aWorld : world) {
            assertEquals(STR.dequeue(), aWorld);
        }
        // // Empty again
        assertThrows(EmptyStackException.class, () -> STR.dequeue());

        // Integer
        // // Empty
        assertThrows(EmptyStackException.class, () -> INT.dequeue());
        // // Each and every element
        INT.enqueueAll(IntStream.of(TestKit.intGenerator(smallInt, -100, 100)).boxed().collect(Collectors.toList()));
        for (int aSmallInt : smallInt) {
            assertEquals(Integer.parseInt(String.valueOf(INT.dequeue())), Integer.parseInt(String.valueOf(aSmallInt)));
        }
        INT.enqueueAll(IntStream.of(TestKit.intGenerator(mediumInt, -10000, 10000)).boxed().collect(Collectors.toList()));
        for (int aMediumInt : mediumInt) {
            assertEquals(Integer.parseInt(String.valueOf(INT.dequeue())), Integer.parseInt(String.valueOf(aMediumInt)));
        }

        // // Empty again
        assertThrows(EmptyStackException.class, () -> INT.dequeue());

    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        // String
        // // Empty
        assertThrows(NoSuchElementException.class, () -> STR.indexOf("AB"));
        // // Each and every element
        STR.enqueueAll(Arrays.asList(world));
        for (int i = 0; i<world.length; i++) {
            assertEquals(STR.indexOf(world[i]),i);
        }
        // // Not found
        assertThrows(NoSuchElementException.class, () -> STR.indexOf("ZZ"));

        // Integer
        // // Empty
        assertThrows(NoSuchElementException.class, () -> INT.indexOf(10));
        // // Each and every element
        // // // Small
        INT.enqueueAll(IntStream.of(TestKit.intGenerator(smallInt, -100, 100)).boxed().collect(Collectors.toList()));

        for (int i = 0; i<smallInt.length; i++) {
            assertEquals(i,INT.indexOf(smallInt[i]));
        }
        for (int i : smallInt) {
            INT.dequeue();
        }
        // // // Medium
        INT.enqueueAll(IntStream.of(TestKit.intGenerator(mediumInt, -10000, 10000)).boxed().collect(Collectors.toList()));
        int rand = new Random().nextInt(mediumInt.length - 1);
        for (int i = 0; i<rand; i++) {
            assertEquals(i,INT.indexOf(mediumInt[i]));
        }
        for (int i : mediumInt) {
            INT.dequeue();
        }
        // // Empty again
        assertThrows(NoSuchElementException.class, () -> INT.indexOf(10));
    }

    @org.junit.jupiter.api.Test
    void first() {
        // String
        // // Empty
        assertThrows(NoSuchElementException.class, () -> STR.first());
        // // Each and every element
        STR.enqueueAll(Arrays.asList(world));
        for (String aWorld : world) {
            assertEquals(STR.first(), aWorld);
            STR.dequeue();
        }
        // // Empty again
        assertThrows(NoSuchElementException.class, () -> STR.first());

        // Integer
        // // Empty
        assertThrows(NoSuchElementException.class, () -> INT.first());
        // // Each and every element
        // // // Small
        INT.enqueueAll(IntStream.of(TestKit.intGenerator(smallInt, -100, 100)).boxed().collect(Collectors.toList()));
        for (int aSmallInt : smallInt) {
            assertEquals(aSmallInt,Integer.parseInt(String.valueOf(INT.first())));
            INT.dequeue();
        }
        // // // Medium
        INT.enqueueAll(IntStream.of(TestKit.intGenerator(mediumInt, -10000, 10000)).boxed().collect(Collectors.toList()));
        for (int aMediumInt : mediumInt) {
            assertEquals(aMediumInt, Integer.parseInt(String.valueOf(INT.first())));
            INT.dequeue();
        }
        // // Empty again
        assertThrows(NoSuchElementException.class, () -> INT.first());
    }

    @org.junit.jupiter.api.Test
    void last() {
        // String
        // // Empty
        assertThrows(NoSuchElementException.class, () -> STR.last());
        // // Each and every element
        STR.enqueueAll(Arrays.asList(world));
        for (String aWorld : world) {
            assertEquals(world[world.length - 1], STR.last());
            STR.dequeue();
        }
         // Empty again
        assertThrows(NoSuchElementException.class, () -> STR.last());

        // Integer
        // // Empty
        assertThrows(NoSuchElementException.class, () -> INT.last());
        // // Each and every element
        // // // Small
        INT.enqueueAll(IntStream.of(TestKit.intGenerator(smallInt, -100, 100)).boxed().collect(Collectors.toList()));
        for (int aSmallInt : smallInt) {
            assertEquals(smallInt[smallInt.length - 1],Integer.parseInt(String.valueOf(INT.last())));
            INT.dequeue();
        }
        // // // Medium
        INT.enqueueAll(IntStream.of(TestKit.intGenerator(mediumInt, -10000, 10000)).boxed().collect(Collectors.toList()));
        for (int aMediumInt : mediumInt) {
            assertEquals(mediumInt[mediumInt.length - 1], Integer.parseInt(String.valueOf(INT.last())));
            INT.dequeue();
        }
        // // Empty again
        assertThrows(NoSuchElementException.class, () -> INT.first());
    }
}