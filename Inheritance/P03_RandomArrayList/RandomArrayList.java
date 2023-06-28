package Inheritance.P03_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    public Object getRandomElement() {
        Random random = new Random();
        return super.remove(random.nextInt(size()));
    }
}
