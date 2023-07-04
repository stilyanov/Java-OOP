package InterfacesAndAbstraction.Exercise.P04_FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] personData = scanner.nextLine().split("\\s+");

            String name;
            int age;
            Buyer buyer;
            if (personData.length == 4) {
                name = personData[0];
                age = Integer.parseInt(personData[1]);
                String id = personData[2];
                String birthDate = personData[3];
                buyer = new Citizen(name, age, id, birthDate);
                buyers.put(name, buyer);
            } else {
                name = personData[0];
                age = Integer.parseInt(personData[1]);
                String group = personData[2];
                buyer = new Rebel(name, age, group);
                buyers.put(name, buyer);
            }
        }
        String nameToSearch = scanner.nextLine();
        while (!nameToSearch.equals("End")) {
            if (buyers.containsKey(nameToSearch)) {
                buyers.get(nameToSearch).buyFood();
            }

            nameToSearch = scanner.nextLine();
        }
        System.out.println(buyers.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
