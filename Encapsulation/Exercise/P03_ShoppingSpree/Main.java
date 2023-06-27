package Encapsulation.Exercise.P03_ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] peopleData = scanner.nextLine().split(";");

        LinkedHashMap<String, Person> peopleMap = new LinkedHashMap<>();

        for (String people : peopleData) {
            String[] personData = people.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);
            try {
                Person person = new Person(name, money);
                peopleMap.put(name, person);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                return;
            }
        }

        String[] productsData = scanner.nextLine().split(";");

        LinkedHashMap<String, Product> productsMap = new LinkedHashMap<>();

        for (String p : productsData) {
            String[] productData = p.split("=");
            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);
            try {
                Product product = new Product(name, cost);
                productsMap.put(name, product);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                return;
            }
        }

        System.out.println();
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String personName = input.split("\\s+")[0];
            String productName = input.split("\\s+")[1];

            Person person = peopleMap.get(personName);
            Product product = productsMap.get(productName);

            try {
                person.buyProduct(product);
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
            input = scanner.nextLine();
        }

        peopleMap.values().forEach(System.out::println);
    }
}
