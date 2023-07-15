package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class P01_NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split("\\s+");
        int startIndex = Integer.parseInt(range[0]);
        int endIndex = Integer.parseInt(range[1]);

        System.out.printf("Range: [%d...%d]%n", startIndex, endIndex);

        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= startIndex && number <= endIndex) {
                    System.out.println("Valid number: " + number);
                    break;
                } else {
                    System.out.println("Invalid number: " + number);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + input);
            }
        }
    }
}
