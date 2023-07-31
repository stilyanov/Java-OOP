package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {

    //WaterArea

    private static final double DEFAULT_KILOGRAMS = 2.50;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, DEFAULT_KILOGRAMS, price);
    }

    @Override
    public void eat() {
        this.setKg(this.getKg() + 7.50);
    }
}
