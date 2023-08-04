package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {

    private static final int DEFAULT_KG = 7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(DEFAULT_KG);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + 1);
    }
}
