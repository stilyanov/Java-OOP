package Inheritance.Exercise.P05_Restaurant.Food;

import Inheritance.Exercise.P05_Restaurant.Product;

import java.math.BigDecimal;

public class Food extends Product {

    private double grams;
    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }
}
