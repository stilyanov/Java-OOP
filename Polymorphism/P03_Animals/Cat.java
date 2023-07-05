package Polymorphism.P03_Animals;

public class Cat extends Animal {
    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("%s%nMEOWW", super.explainSelf());
    }
}
