package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        this.houses.add(house);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        this.toys.buyToy(toy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        House house = this.houses.stream()
                .filter(h -> h.getName().equals(houseName))
                .findFirst()
                .orElse(null);

        Toy toy = this.toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }
        this.houses.forEach(h -> h.buyToy(toy));

        this.toys.removeToy(toy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        House house = this.houses.stream()
                .filter(h -> h.getName().equals(houseName))
                .findFirst()
                .orElse(null);

        Cat cat;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }
        if (house.getClass().getSimpleName().equals("ShortHouse") && catType.equals("ShorthairCat")) {
            house.addCat(cat);
        } else if (house.getClass().getSimpleName().equals("LongHouse") && catType.equals("LonghairCat")) {
            house.addCat(cat);
        } else {
            return ConstantMessages.UNSUITABLE_HOUSE;
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = this.houses.stream()
                .filter(h -> houseName.equals(h.getName()))
                .findFirst()
                .get();
        house.feeding();

        return String.format(ConstantMessages.FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = this.houses.stream()
                .filter(h -> h.getName().equals(houseName))
                .findFirst()
                .get();

        double catsTotal = house.getCats()
                .stream()
                .mapToDouble(Cat::getPrice)
                .sum();

        double toysTotal = house.getToys()
                .stream()
                .mapToDouble(Toy::getPrice)
                .sum();

        return String.format(ConstantMessages.VALUE_HOUSE, houseName, catsTotal + toysTotal);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        this.houses.forEach(house -> sb.append(house.getStatistics()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
