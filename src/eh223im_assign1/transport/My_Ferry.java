package eh223im_assign1.transport;

import java.util.ArrayList;
import java.util.Iterator;

public class My_Ferry implements Ferry {

    public enum objectID {
        LORRY, BUS, CAR, BICYCLE, PASSENGER
    }

    My_Ferry() {
        availablePassengersSpace = 200;
        availableVehiclesSpace = 200;
        money = 0;
        The_Vehicles = new ArrayList <>();
    }

    private ArrayList<Vehicle> The_Vehicles;
    private ArrayList<Passenger> The_Passengers;

    // Default maximum number of Vehicles & Passengers
    private final int MAX_VEHICLES = 200;
    private final int MAX_PASSENGERS = 200;
    private int availablePassengersSpace;
    private int availableVehiclesSpace;

    private int money;

    public int countPassengers() {
        int i = 0;
        for (int k = 0; k < The_Vehicles.size(); k++) {
            i += The_Vehicles.get(k).getPassengers();
        }
        return i + The_Passengers.size();
    }             // Number of passengers on board

    public int countVehicleSpace() {
        return The_Vehicles.size();
    }           // Used Vehicle space. One bicycle is 1.

    //
    public int countMoney() {
        int m = 0;
        for (int i = 0; i<The_Vehicles.size(); i++) {
            m+= The_Vehicles.get(i).getFee();
        }
        for (int i = 0; i<The_Passengers.size(); i++) {
            m += 20 * The_Vehicles.size();
        }
        return m;
    }                  // Earned money

    public void setMoney() {
        money += countMoney();
    }

    public Iterator<Vehicle> iterator() {
        return new VehicleIterator();
    }      // Vehicle iterator


    public int getMoney() {
        return money;
    } // Get fee information

    public int getAvailablePassengersSpace() {
        return availablePassengersSpace;
    }

    public int getAvailableVehiclesSpace() {
        return availableVehiclesSpace;
    }

    // Inner-class, taken from Abs.Int.Collection
    class VehicleIterator implements Iterator<Vehicle> {
        private int count = 0;
        public Vehicle next() {
            return The_Vehicles.get(count++);
        }

        public boolean hasNext() {
            return count < countVehicleSpace();
        }
        public void remove() {
            throw new RuntimeException("remove() is not implemented");
        }
    }

    // Working on this one
    public void embark(Vehicle v) {
        if (hasSpaceFor(v)) {
            The_Vehicles.add(v);
            availableVehiclesSpace -= v.getVSize();
            availablePassengersSpace -= v.getPassengers();
        }
        else {
            System.out.println("Cannot embark, not enough space.");
        }
    }            // Embark Vehicle, warning if not enough space

    public void embark(Passenger p) {
        if (hasRoomFor(p)) {
            The_Passengers.add(p);
            availablePassengersSpace--;
        } else {
            System.out.println("Cannot embark, not enough room.");
        }
    }          // Embark passenger, warning if not enough room

    public void disembark() {
        The_Vehicles.clear();
        The_Passengers.clear();
    }                  // Clear (empty) ferry. The money earned remains,

    // i.e., is not reset to zero
    public boolean hasSpaceFor(Vehicle v) {
        return v.getVSize() <= getAvailableVehiclesSpace() && v.getPassengers() <= getAvailablePassengersSpace();
    }    // true if we can embark Vehicle v

    public boolean hasRoomFor(Passenger p) {
        return countPassengers() < MAX_PASSENGERS;
    }   // true if we can embark passenger p

    public String toString() {
        return "Ferry status:\n" + "Vehicles: " +The_Vehicles.size() + "\nPassengers: "+countPassengers();
    }                 // Nice looking ferry status print out
}
