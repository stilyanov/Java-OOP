package ReflectionAndAnnotation.Exercise.barracksWars;

import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotation.Exercise.barracksWars.core.Engine;
import ReflectionAndAnnotation.Exercise.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotation.Exercise.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
