package gas;

import java.util.*;

class GasStation {

    // Всего 2 насоса
    public EnumMap<FuelEnum, Pump> pumps = new EnumMap<FuelEnum, Pump>(FuelEnum.class);
    {
        pumps.put(FuelEnum.AI92, new Pump(1000, new Ai92()));
        pumps.put(FuelEnum.AI95, new Pump(1500, new Ai95()));
    }

    // Получить насос для требуемого топлива
    public Pump getPump(FuelEnum type) {
        return pumps.get(type);
    }

    // Заправка машины
    public void pumping(Car car) throws NoSuchAmountException {
        car.fillUp();
    }

    // Печать чека на оплату
    public float printCheck(Car car) {
        float price = pumps.get(car.getFuelType()).getFuelType().getPrice();
        return car.getAmount() * price;
    }
}