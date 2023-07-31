package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {

    //LandArea

    private static final double DEFAULT_KILOGRAMS = 5.50;
    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, DEFAULT_KILOGRAMS, price);
    }

    @Override
    public void eat() {
        this.setKg(this.getKg() + 5.70);
    }
}
