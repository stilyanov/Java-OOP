package InterfacesAndAbstraction.P05_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiableList = new ArrayList<>();

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] data = line.split("\\s+");

            if (data.length == 3) {
                // citizen
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];
                Identifiable citizen = new Citizen(name, age, id);
                identifiableList.add(citizen);
            } else if (data.length == 2) {
                // robot
                String model = data[0];
                String id = data[1];
                Identifiable robot = new Robot(model, id);
                identifiableList.add(robot);
            }
        }
        String fakeID = scanner.nextLine();
        identifiableList.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeID))
                .forEach(System.out::println);
    }
}
