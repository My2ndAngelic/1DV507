package eh223im_assign1.transport;

import java.util.ArrayList;

public class Passenger extends My_Ferry {
    private String name;

    Passenger() {
        name = "";
    }

    Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
