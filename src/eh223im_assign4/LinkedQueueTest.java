package eh223im_assign4;

import java.util.*;
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
    private int[] largeInt = new int[1000000];

    // Select random counties
    private static String[] worldSelector(String[] strings, int req) {
        String[] s = new String[req];
        for (int i = 0; i<req; i++) {
            s[i] = strings[new Random().nextInt(strings.length - 1)];
        }
        return s;
    }

    // Generate int[] for checking
    private static int[] intGenerator(int[] req, int min, int max) {
        for (int i = 0; i < req.length; i++) {
            req[i] = new Random().nextInt(max - min + 1) - min;
        }
        return req;
    }

    @org.junit.jupiter.api.Test
    void get() {

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
        INT.enqueueAll(IntStream.of(intGenerator(smallInt,-100,100)).boxed().collect(Collectors.toList()));
        assertEquals(INT.size(),100);
        // // Medium case
        i = INT.size();
        for (int k = 0; k<i;k++) {
            INT.dequeue();
        }
        INT.enqueueAll(IntStream.of(intGenerator(mediumInt,-10000,10000)).boxed().collect(Collectors.toList()));
        assertEquals(INT.size(),10000);
        // Big case
        i = INT.size();
        for (int k = 0; k<i;k++) {
            INT.dequeue();
        }
        INT.enqueueAll(IntStream.of(intGenerator(largeInt,-1000000,1000000)).boxed().collect(Collectors.toList()));
        assertEquals(INT.size(),1000000);
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
        INT.enqueueAll(IntStream.of(intGenerator(smallInt,-100,100)).boxed().collect(Collectors.toList()));
        assertFalse(INT.isEmpty());
        // // Medium case
        i = INT.size();
        for (int k = 0; k<i;k++) {
            INT.dequeue();
        }
        assertTrue(INT.isEmpty());
        INT.enqueueAll(IntStream.of(intGenerator(mediumInt,-10000,10000)).boxed().collect(Collectors.toList()));
        assertFalse(INT.isEmpty());
        // // Big case
        i = INT.size();
        for (int k = 0; k<i;k++) {
            INT.dequeue();
        }
        assertTrue(INT.isEmpty());
        INT.enqueueAll(IntStream.of(intGenerator(largeInt,-1000000,1000000)).boxed().collect(Collectors.toList()));
        assertFalse(INT.isEmpty());
        // // Empty again
        i = INT.size();
        for (int k = 0; k<i;k++) {
            INT.dequeue();
        }
        assertTrue(INT.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void enqueue() {

    }

    @org.junit.jupiter.api.Test
    void dequeue() {
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