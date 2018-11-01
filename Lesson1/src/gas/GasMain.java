package gas;

public class GasMain {

    public static void main(String [] argv){

        GasStation station = new GasStation();


        Car mersedes = new Car("MERSEDES", FuelEnum.AI95, 60);
        Car bmw = new Car("BMW", FuelEnum.AI95, 70);
        Car lada = new Car("LADA", FuelEnum.AI92, 40);

        // Определить насос для заданного топлива
        mersedes.setPump(
                station.getPump(mersedes.getFuelType()));
        bmw.setPump(
                station.getPump(bmw.getFuelType()));
        lada.setPump(
                station.getPump(lada.getFuelType()));

        // Заправка
        try {
            station.pumping(mersedes);
            station.pumping(bmw);
            station.pumping(lada);
        } catch (NoSuchAmountException e) {
            e.printStackTrace();
        }

        station.printCheck(mersedes);

        System.out.println("Остаток 92 топлива после "+station.getPump(FuelEnum.AI92).getLevel());
        System.out.println("Остаток 95 топлива после "+station.getPump(FuelEnum.AI95).getLevel());

        System.out.println(mersedes.getModel() + " : " + mersedes.getAmount() + " литров " + station.printCheck(mersedes) + " руб.");
        System.out.println(bmw.getModel() + " : " + bmw.getAmount() + " литров " + station.printCheck(bmw) + " руб.");
        System.out.println(lada.getModel() + " : " + lada.getAmount() + " литров " + station.printCheck(lada) + " руб.");

    }

}
