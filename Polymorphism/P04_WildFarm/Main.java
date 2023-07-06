package Polymorphism.P04_WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int counter = 0;
        Animal animal = null;
        List<Animal> animals = new ArrayList<>();
        while (!input.equals("End")) {
            String[] animalLines = input.split("\\s+");

            if (counter % 2 == 0) {
                String animalType = animalLines[0];
                String animalName = animalLines[1];
                Double animalWeight = Double.parseDouble(animalLines[2]);
                String animalLivingRegion = animalLines[3];

                if (animalType.equals("Cat")) {
                    String breed = animalLines[4];

                    animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, breed);

                } else if (animalType.equals("Tiger")) {
                    animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);

                } else if (animalType.equals("Zebra")) {
                    animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);

                } else if (animalType.equals("Mouse")) {
                    animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);

                }
                animals.add(animal);

            } else {
                String foodType = animalLines[0];
                int foodQuantity = Integer.parseInt(animalLines[1]);
                Food food = null;
                if (foodType.equals("Meat")) {
                    food = new Meat(foodQuantity);
                } else if (foodType.equals("Vegetable")) {
                    food = new Vegetable(foodQuantity);
                }

                animals.get(animals.size() - 1).makeSound();
                animal.eat(food);
            }

            input = scanner.nextLine();
            counter++;
        }
        animals.forEach(System.out::println);
    }
}
