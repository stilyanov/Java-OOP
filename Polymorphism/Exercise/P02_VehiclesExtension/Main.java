package Polymorphism.Exercise.P02_VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(input[1]), (Double.parseDouble(input[2])), (Double.parseDouble(input[3])));

        input = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(input[1]), (Double.parseDouble(input[2])), (Double.parseDouble(input[3])));

        input = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(input[1]), (Double.parseDouble(input[2])), (Double.parseDouble(input[3])));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            input = scanner.nextLine().split("\\s+");

            try {
                switch (input[0]) {
                    case "Drive":
                        double distance = Double.parseDouble(input[2]);
                        switch (input[1]) {
                            case "Car":
                                System.out.println(car.drive(distance));
                                break;
                            case "Truck":
                                System.out.println(truck.drive(distance));
                                break;
                            case "Bus":
                                if (bus.isEmpty()) {
                                    bus.setEmpty(false);
                                    bus.setFuelConsumption(bus.getFuelConsumption() + 1.4);
                                }
                                System.out.println(bus.drive(distance));
                                break;
                        }
                        break;
                    case "Refuel":
                        double liters = Double.parseDouble(input[2]);
                        switch (input[1]) {
                            case "Car":
                                car.refuel(liters);
                                break;
                            case "Truck":
                                truck.refuel(liters);
                                break;
                            case "Bus":
                                bus.refuel(liters);
                                break;
                        }
                        break;
                    case "DriveEmpty":
                        if (!bus.isEmpty()) {
                            bus.setEmpty(true);
                            bus.setFuelConsumption(bus.getFuelConsumption() - 1.4);
                        }
                        distance = Double.parseDouble(input[2]);
                        System.out.println(bus.drive(distance));
                        break;
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
