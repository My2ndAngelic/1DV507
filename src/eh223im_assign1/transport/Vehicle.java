package eh223im_assign1.transport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class Vehicle extends My_Ferry{

    private int vSize;
    private int passengers;
    private int MAX_PASSENGER;
    private int fee;
    private objectID objectID;
    private ArrayList<String> passengersNameRecord = new ArrayList <>();

    public int getPassengers() {
        return passengers;
    }


    private boolean checkValidPassenger(objectID oID, int pass) {
        switch (oID) {
            case LORRY:
                return pass <= 2;
            case BUS:
                return pass <= 20;
            case CAR:
                return pass <= 4;
            case BICYCLE:
                return pass <= 1;
            default: return false;
        }
    }

    // A vehicle contains ID and number of passengers
    Vehicle (objectID vID, int passengers) {
        if(checkValidPassenger(vID, passengers)) {
            this.objectID = vID;
            setvSize(vID);
            this.passengers = passengers;
            setMAX_PASSENGER(objectID);
        }
    }

    // Just in case if someone wants to extend the record
    Vehicle (objectID vID, String[] passengerName) {
        if(checkValidPassenger(vID, passengerName.length)) {
            this.passengers = passengers;
            this.objectID = vID;
            setvSize(vID);
            passengersNameRecord.addAll(Arrays.stream(passengerName).collect(Collectors.toList()));
            this.passengers = passengerName.length;
            setFee(vID);
        }
    }

    Vehicle() {

    }

    // Fee structure
    private void setFee(objectID vID) {
        switch (vID) {
            case LORRY:
                fee += 300;
                fee += 15 * passengers;

                break;
            case BUS:
                fee += 200;
                fee += 10 * passengers;


                break;
            case CAR:
                fee += 100;
                fee += 15 * passengers;


                break;
            case BICYCLE:
                fee += 40;
                break;
            default:
                break;
        }
    }

    private void setvSize(objectID vID) {
        switch (vID) {
            case LORRY: vSize = 40; break;
            case BUS: vSize = 20; break;
            case CAR: vSize = 5; break;
            case BICYCLE: vSize = 1; break;
            default: vSize = 0;
        }
    }

    public int getVSize() {
        return vSize;
    }

    public int getFee() {
        return fee;
    }

    public objectID getType() {
        return objectID;
    }

    public objectID getObjectID() {
        return objectID;
    }

    public void setPassengersNo(int pass) {
        this.passengers = pass;
    }

    public void setObjectID(objectID oID) {
        this.objectID = oID;
    }

    public ArrayList <String> getPassengersNameRecord() {
        return passengersNameRecord;
    }

    public void addPassenger(String name) {
        if (passengers < MAX_PASSENGER) {
            passengersNameRecord.add(name);
        } else {
            System.out.println("Cannot add passenger to the vehicle. Not enough spaces.");
        }
    }

    public void addPassenger(String[] name) {
        if (passengers + name.length < MAX_PASSENGER) {
            passengersNameRecord.addAll(Arrays.stream(name).collect(Collectors.toList()));
        } else {
            System.out.println("Cannot add passenger to the vehicle. Not enough spaces.");
        }
    }

    public int getMAX_PASSENGER() {
        return MAX_PASSENGER;
    }

    public void setMAX_PASSENGER(objectID oID) {
        switch (objectID) {
            case LORRY:
                MAX_PASSENGER = 2;
                break;
            case BUS:
                MAX_PASSENGER = 20;
                break;
            case CAR:
                MAX_PASSENGER = 4;
                break;
            case BICYCLE:
                MAX_PASSENGER = 1;
                break;
            default: break;
        }
    }
}
