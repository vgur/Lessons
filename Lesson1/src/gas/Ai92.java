package gas;

public class Ai92 implements FuelType {

    private static final float PRICE = 40.35f;

    public String toString(){
        return "АИ-92";
    }

    public float getPrice() {
        return PRICE;
    }

}
