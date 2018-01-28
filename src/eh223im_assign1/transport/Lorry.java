package eh223im_assign1.transport;

public class Lorry extends Vehicle {
    // Fields
    private final int MAX_PASSENGER = 2;
    private int passenger = 0;
    private int availableEmptyPassenger = (MAX_PASSENGER - passenger);

    private int fee = 0;
    private final int DEFAULT_FEE = 300;

    Lorry(String[] passengersNameRecord) {
        super(objectID.LORRY,passengersNameRecord);
        fee = DEFAULT_FEE + passengersNameRecord.length;
    }

    Lorry() {
        super(objectID.LORRY,0);
        fee = DEFAULT_FEE;
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
