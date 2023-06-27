package Encapsulation.Exercise.P02_AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }


    @Override
    public String toString() {
        //Chicken Choko (age 6) can produce 1.00 eggs per day.
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day",
                name, age, productPerDay());
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double egg = 0.75;
        if (age < 6) {
            egg = 2;
        } else if (age < 12) {
            egg = 1;
        }
        return egg;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }
}
