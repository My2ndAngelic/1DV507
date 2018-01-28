package eh223im_assign1.transport;

public class Car extends Vehicle {
    // Fields
    private final int MAX_PASSENGER = 4;
    private int passenger = 0;
    private int availableEmptyPassenger = (MAX_PASSENGER - passenger);

    private int fee = 0;
    private final int DEFAULT_FEE = 100;

    Car(String[] passengersNameRecord) {
        super(objectID.CAR,passengersNameRecord);
        fee = 100 + 15*passengersNameRecord.length;
    }

    Car() {
        super(objectID.CAR,0);
    }

    public void addPassenger(Passenger p) {
        if (availableEmptyPassenger != 0) {
            passenger++;
            availableEmptyPassenger--;
            fee += 15;
        }
    }

    @Override
    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
