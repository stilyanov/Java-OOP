package ReflectionAndAnnotation.P05_CodingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {
    public static void printMethodsByAuthor(Class<?> clazz) {

        Map<String, List<String>> methodsByAuthor = new HashMap<>();

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);

            if (annotation != null) {
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName() + "()");
            }

            methodsByAuthor.forEach((author, m) -> System.out.printf("%s: %s\n", author, String.join(", ", m)));
        }
    }
}
