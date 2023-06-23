package WorkingWithAbstraction.Exercise.P05_JediGalaxy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = InputParser.parseIntegerArray(scanner.nextLine());

        int rows = dimensions[0];
        int cols = dimensions[1];

        Galaxy galaxy = new Galaxy(new Field(new int[rows][cols]));

        Evil evil = new Evil(galaxy);
        Jedi jedi = new Jedi(galaxy);
        Engine engine = new Engine(scanner, evil, jedi);
        engine.run();

        System.out.println(jedi.getPoints());
    }
}
