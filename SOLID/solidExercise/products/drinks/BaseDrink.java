package SOLID.solidExercise.products.drinks;

public abstract class BaseDrink implements Drink {
    private double milliliters;
    private double caloriesPer100Grams;
    private double density;

    public BaseDrink(double milliliters, double caloriesPer100Grams, double density) {
        this.milliliters = milliliters;
        this.caloriesPer100Grams = caloriesPer100Grams;
        this.density = density;
    }

    @Override
    public double getDensity() {
        return density;
    }

    @Override
    public double getCalories() {
        return (caloriesPer100Grams / 100) * (milliliters * density);
    }

    @Override
    public double getLiters() {
        return milliliters / 1000;
    }
}
