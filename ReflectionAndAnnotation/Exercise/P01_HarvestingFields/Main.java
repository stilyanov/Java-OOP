package ReflectionAndAnnotation.Exercise.P01_HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] fields = clazz.getDeclaredFields();

        String command = scanner.nextLine();
        while (!command.equals("HARVEST")) {

            for (Field field : fields) {
                if (Modifier.toString(field.getModifiers()).equals(command)) {
                    System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
                            field.getType().getSimpleName(), field.getName());
                } else if (command.equals("all")) {
                    System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
                            field.getType().getSimpleName(), field.getName());
                }
            }


            command = scanner.nextLine();
        }
    }
}
