package InterfacesAndAbstraction.Exercise.P03_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        String line;
        while (!(line = scanner.nextLine()).equals("End")) {
            String[] data = line.split("\\s+");
            String name;
            String birthDate;
            switch (data[0]) {
                case "Citizen":
                    name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String id = data[3];
                    birthDate = data[4];
                    Citizen citizen = new Citizen(name, age, id, birthDate);
                    birthables.add(citizen);
                    break;
                case "Pet":
                    name = data[1];
                    birthDate = data[2];
                    Pet pet = new Pet(name, birthDate);
                    birthables.add(pet);
                    break;
            }
        }
        String birthDayToSearch = scanner.nextLine();

        birthables.stream()
                .filter(b -> b.getBirthDate().contains(birthDayToSearch))
                .forEach(b -> System.out.println(b.getBirthDate()));
    }
}
