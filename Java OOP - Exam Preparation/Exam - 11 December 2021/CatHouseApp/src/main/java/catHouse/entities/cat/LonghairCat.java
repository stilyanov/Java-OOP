package catHouse.entities.cat;

public class LonghairCat extends BaseCat {

    private static final int DEFAULT_KG = 9;
    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(DEFAULT_KG);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + 3);
    }
}
