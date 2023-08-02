package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class SportsCar extends BaseCar {

    private static final double DEFAULT_CUBIC_CENTIMETERS = 3000;

    public SportsCar(String model, int horsePower) {
        super(model, setHorsePower(horsePower), DEFAULT_CUBIC_CENTIMETERS);
    }

    private static int setHorsePower(int horsePower) {
        if (horsePower < 250 || horsePower > 450) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }
        return horsePower;
    }
}
