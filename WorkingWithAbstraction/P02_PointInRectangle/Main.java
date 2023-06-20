package WorkingWithAbstraction.P02_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = getArray(scanner);

        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        int bottomRightX = coordinates[2];
        int bottomRightY = coordinates[3];

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point bottomRight = new Point(bottomRightX, bottomRightY);

        Rectangle rectangle = new Rectangle(bottomLeft, bottomRight);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            int[] coordinatesOfPoints = getArray(scanner);
            int x = coordinatesOfPoints[0];
            int y = coordinatesOfPoints[1];

            Point search = new Point(x, y);
            boolean itContains = rectangle.contains(search);

            System.out.println(itContains);
        }
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
