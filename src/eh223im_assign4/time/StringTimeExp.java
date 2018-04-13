package eh223im_assign4.time;

import java.util.Random;

public class StringTimeExp {
    public static void main(String[] args) {
        System.out.println(Character.toUpperCase((char) 65));
        System.out.println(Character.toUpperCase((char) (new Random().nextInt(90-65+1)+65)));
    }
}
