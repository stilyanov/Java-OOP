package WorkingWithAbstraction.P03_StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            if (command.equals("Exit")) {
                break;
            }
            studentSystem.ParseCommand(input);
        }
    }
}
