package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class MuscleCar extends BaseCar {

    private static final double DEFAULT_CUBIC_CENTIMETERS = 5000;

    public MuscleCar(String model, int horsePower) {
        super(model, setHorsePower(horsePower), DEFAULT_CUBIC_CENTIMETERS);
    }

    private static int setHorsePower(int horsePower) {
        if (horsePower < 400 || horsePower > 600) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }
        return horsePower;
    }
}
