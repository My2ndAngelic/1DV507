package eh223im_assign1.transport;

public class Bus extends Vehicle {
    // Fields
    private final int MAX_PASSENGER = 20;
    private int passenger = 0;
    private int availableEmptyPassenger = (MAX_PASSENGER - passenger);

    private int fee;
    private final int DEFAULT_FEE = 200;

    Bus(String[] passengersNameRecord) {
        super(objectID.BUS,passengersNameRecord);
        fee = DEFAULT_FEE + passengersNameRecord.length;
    }

    Bus() {
        super(objectID.BUS,0);
        fee = DEFAULT_FEE;
    }

    public void addPassenger(Passenger p) {
        if (availableEmptyPassenger != 0) {
            passenger++;
            availableEmptyPassenger--;
            fee += 10;
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
