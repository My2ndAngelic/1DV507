package eh223im_assign1.transport;

public class Bicycle extends Vehicle {
    // Fields
    private final int MAX_PASSENGER = 1;
    private int passenger = 1;
    private int availableEmptyPassenger = (MAX_PASSENGER - passenger);

    private int fee;
    private final int DEFAULT_FEE = 40;

    Bicycle(String[] passengersNameRecord) {
        super(objectID.BICYCLE,passengersNameRecord);
        fee = DEFAULT_FEE;
    }

    Bicycle() {
        super(objectID.BICYCLE,1);
        fee = DEFAULT_FEE;
    }

    @Override
    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
