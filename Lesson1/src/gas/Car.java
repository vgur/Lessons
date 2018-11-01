package gas;

public class Car {
    private String model;
    private int amount;
    private FuelEnum fuelType;

    private Pump pump = null;


    public Car(String model, FuelEnum fuelType, int amount) {
        this.model = model;
        this.fuelType = fuelType;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setPump(Pump pump) {
        this.pump = pump;
    }

    public FuelEnum getFuelType() {
        return fuelType;
    }

    public String getModel() {
        return model;
    }

    public void fillUp() throws NoSuchAmountException {
        pump.deliver(getAmount());
    }

}
