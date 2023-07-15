package ReflectionAndAnnotation.Exercise.P02_BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = constructor.newInstance();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String commandName = command.split("_")[0];
            int value = Integer.parseInt(command.split("_")[1]);

            Method method = clazz.getDeclaredMethod(commandName, int.class);
            method.setAccessible(true);

            method.invoke(blackBoxInt, value);

            Field innerValue = clazz.getDeclaredField("innerValue");
            innerValue.setAccessible(true);

            System.out.println(innerValue.get(blackBoxInt));


            command = scanner.nextLine();
        }
    }
}
