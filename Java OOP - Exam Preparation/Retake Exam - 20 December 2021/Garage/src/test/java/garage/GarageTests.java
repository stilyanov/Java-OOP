package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GarageTests {
    private Garage garage;

    @Before
    public void setGarage() {
        garage = new Garage();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCarsThrowException() {
        garage.getCars().add(new Car("bmw", 20, 10));
    }

    @Test
    public void testGetCount() {
        Car car = new Car("Audi", 240, 5300);
        garage.addCar(car);
        Assert.assertEquals(garage.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarNull() {
        Car car = null;
        garage.addCar(car);
    }

    @Test
    public void testAddCar() {
        Car car = new Car("Audi", 240, 5300);
        Car car2 = new Car("bmw", 20, 10);
        garage.addCar(car);
        garage.addCar(car2);
        Assert.assertEquals(garage.getCount(), 2);
    }

    @Test
    public void testGetTheMostExpensiveCar() {
        Car car = new Car("Audi", 240, 5300);
        Car car2 = new Car("BMW", 20, 10);
        Car car3 = new Car("GOLF", 220, 4100);
        garage.addCar(car);
        garage.addCar(car2);
        garage.addCar(car3);
        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();
        Assert.assertEquals(theMostExpensiveCar, garage.getCars().get(0));
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        Car car = new Car("Audi", 240, 5300);
        Car car2 = new Car("BMW", 20, 10);
        Car car3 = new Car("GOLF", 220, 4100);
        garage.addCar(car);
        garage.addCar(car2);
        garage.addCar(car3);
        List<Car> allCarsWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(230);
        List<Car> expected = new ArrayList<>(List.of(car));
        Assert.assertEquals(allCarsWithMaxSpeedAbove, expected);
    }

    @Test
    public void testFindAllCarsByBrand() {
        Car car = new Car("Audi", 240, 5300);
        Car car2 = new Car("BMW", 20, 10);
        Car car3 = new Car("BMW", 30, 1300);
        Car car4 = new Car("GOLF", 220, 4100);
        garage.addCar(car);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.addCar(car4);
        List<Car> bmw = garage.findAllCarsByBrand("BMW");
        List<Car> expected = new ArrayList<>(Arrays.asList(car2, car3));
        Assert.assertEquals(bmw, expected);
    }
}