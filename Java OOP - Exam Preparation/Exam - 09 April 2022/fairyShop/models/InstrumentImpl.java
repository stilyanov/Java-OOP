package fairyShop.models;

import fairyShop.common.ExceptionMessages;

public class InstrumentImpl implements Instrument {

    private int power;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    private void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void use() {
        int reducedPower = this.getPower() - 10;
        if (reducedPower < 0) {
            reducedPower = 0;
        }
        this.setPower(reducedPower);
    }

    @Override
    public boolean isBroken() {
        return this.getPower() == 0;
    }
}
