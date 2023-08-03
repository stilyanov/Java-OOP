package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private HelperRepository helperRepository;

    private PresentRepository presentRepository;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        if (type.equals("Happy")) {
            helper = new Happy(helperName);
        } else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }
        this.helperRepository.add(helper);

        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        if (helperRepository.findByName(helperName) == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        Instrument instrument = new InstrumentImpl(power);
        helperRepository.findByName(helperName).addInstrument(instrument);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        this.presentRepository.add(present);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> helpers = this.helperRepository.getModels().stream()
                .filter(h -> h.getEnergy() > 50)
                .collect(Collectors.toList());
        if (helpers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        int brokenInstruments = 0;
        Shop shop = new ShopImpl();
        Present present = presentRepository.findByName(presentName);
        for (Helper helper : helpers) {
            shop.craft(present, helper);
            brokenInstruments += (int) helper.getInstruments().stream()
                    .filter(Instrument::isBroken).count();
            if (present.isDone()) {
                break;
            }
        }
        if (present.isDone()) {
            return String.format(ConstantMessages.PRESENT_DONE, presentName, "done") +
                    String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
        }
        return String.format(ConstantMessages.PRESENT_DONE, presentName, "not done") +
                String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
    }

    @Override
    public String report() {
        int size = (int) presentRepository.getModels().stream().filter(Present::isDone).count();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d presents are done!", size)).append(System.lineSeparator());
        sb.append("Helpers info:").append(System.lineSeparator());
        for (Helper helper : this.helperRepository.getModels()) {
            sb.append(String.format("Name: %s", helper.getName())).append(System.lineSeparator());
            sb.append(String.format("Energy: %d", helper.getEnergy())).append(System.lineSeparator());
            sb.append(String.format("Instruments: %d not broken left",
                            helper.getInstruments().stream().filter(e -> !e.isBroken()).collect(Collectors.toList()).size()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
