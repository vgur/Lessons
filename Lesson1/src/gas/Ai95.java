package gas;

public class Ai95 implements FuelType{

    private static final float PRICE = 45.00f;

    public String toString(){
        return "АИ-95";
    }

    public float getPrice() {
        return PRICE;
    }
}
