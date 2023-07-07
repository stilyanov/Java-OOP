package Polymorphism.Exercise.P01_Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(input[1]), (Double.parseDouble(input[2])));

        input = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(input[1]), (Double.parseDouble(input[2])));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            input = scanner.nextLine().split("\\s+");

            switch (input[0]) {
                case "Drive":
                    double distance = Double.parseDouble(input[2]);
                    switch (input[1]) {
                        case "Polymorphism.Exercise.P01_Vehicles.Car":
                            System.out.println(car.drive(distance));
                            break;
                        case "Polymorphism.Exercise.P01_Vehicles.Truck":
                            System.out.println(truck.drive(distance));
                            break;
                    }
                    break;
                case "Refuel":
                    double refuel = Double.parseDouble(input[2]);
                    switch (input[1]) {
                        case "Polymorphism.Exercise.P01_Vehicles.Car":
                            car.refuel(refuel);
                            break;
                        case "Polymorphism.Exercise.P01_Vehicles.Truck":
                            truck.refuel(refuel);
                            break;
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
