package Polymorphism.P03_Animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    protected String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    protected String getFavouriteFood() {
        return favouriteFood;
    }

    protected void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s", name, favouriteFood);
    }
}
