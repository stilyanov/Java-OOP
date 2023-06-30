package Inheritance.Exercise.P06_Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("Beast!")) {
            try {
                switch (input) {
                    case "Cat":
                        String[] animalData = scanner.nextLine().split("\\s+");
                        Cat cat = new Cat(animalData[0], Integer.parseInt(animalData[1]), animalData[2]);
                        System.out.println(cat);
                        break;
                    case "Kitten":
                        animalData = scanner.nextLine().split("\\s+");
                        Kitten kitten = new Kitten(animalData[0], Integer.parseInt(animalData[1]));
                        break;
                    case "Tomcat":
                        animalData = scanner.nextLine().split("\\s+");
                        Tomcat tomcat = new Tomcat(animalData[0], Integer.parseInt(animalData[1]));
                        break;
                    case "Frog":
                        animalData = scanner.nextLine().split("\\s+");
                        Frog frog = new Frog(animalData[0], Integer.parseInt(animalData[1]), animalData[2]);
                        System.out.println(frog);
                        break;
                    case "Dog":
                        animalData = scanner.nextLine().split("\\s+");
                        Dog dog = new Dog(animalData[0], Integer.parseInt(animalData[1]), animalData[2]);
                        System.out.println(dog);
                        break;
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
            input = scanner.nextLine();
        }
    }
}
