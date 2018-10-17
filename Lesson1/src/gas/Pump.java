package gas;

public class Pump {

    // Вид топлива
    private FuelType fuelType;
    // Остаток топлива
    int level;

    // Конструктор
    public Pump(int amount, FuelType fuelType) {
        this.fuelType = fuelType;
        this.level = amount;
    }

    public int getLevel() {
        return level;
    }

    // Выдача топлива
    public void deliver(int amount) throws NoSuchAmountException {
        if (level - amount > 0) {
            level = level - amount;
        } else {
            throw new NoSuchAmountException("Бензина совсем нет");
        }
    }

    public FuelType getFuelType() {
        return fuelType;
    }
}