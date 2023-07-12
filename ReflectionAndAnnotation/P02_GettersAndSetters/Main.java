package ReflectionAndAnnotation.P02_GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz  = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get") && m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(getters).forEach(m -> {
            System.out.printf("%s will return class %s%n", m.getName(), m.getReturnType().getName());
        });

        Method[] setters = Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set") && m.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(setters).forEach(m -> {
            System.out.printf("%s and will set field of class %s%n", m.getName(), m.getParameterTypes()[0].getName());
        });
    }
}
