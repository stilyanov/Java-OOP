package vehicleShop.models.tool;

import vehicleShop.common.ExceptionMessages;

public class ToolImpl implements Tool {
    private int power;

    public ToolImpl(int power) {
        this.setPower(power);
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void decreasesPower() {
        int currentPower = getPower();
        int reducedPower = currentPower - 5;
        if (reducedPower < 0) {
            reducedPower = 0;
        }
        this.setPower(reducedPower);
    }

    @Override
    public boolean isUnfit() {
        return this.getPower() > 0;
    }

    public void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }
}
