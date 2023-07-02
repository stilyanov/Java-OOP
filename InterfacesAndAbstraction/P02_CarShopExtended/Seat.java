package InterfacesAndAbstraction.P02_CarShopExtended;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return String.format("%s sells for %f", getModel(), this.getPrice());
    }
}
