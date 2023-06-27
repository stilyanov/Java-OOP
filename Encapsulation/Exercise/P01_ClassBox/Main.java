package Encapsulation.Exercise.P01_ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        Box box = new Box(length, width, height);
        double volume = box.calculateVolume();
        double surfaceArea = box.calculateSurfaceArea();
        double lateralSurfaceArea = box.calculateLateralSurfaceArea();

        System.out.printf("Surface Area - %.2f%n", surfaceArea);
        System.out.printf("Lateral Surface Area - %.2f%n", lateralSurfaceArea);
        System.out.printf("Volume - %.2f%n", volume);
    }
}
