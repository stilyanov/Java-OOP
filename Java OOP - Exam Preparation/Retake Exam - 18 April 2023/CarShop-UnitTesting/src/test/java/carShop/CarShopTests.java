package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarShopTests {
    private Car car;
    private CarShop carShop;

    @Before
    public void setUp() {
        car = new Car("audi", 131, 5000);
        carShop = new CarShop();
    }

    @Test
    public void testConstructorAddCar() {
        carShop.add(car);
        Assert.assertEquals("audi", car.getModel());
    }

    @Test
    public void testGetCars() {
        List<Car> expected = new ArrayList<>();
        expected.add(car);
        carShop.add(car);
        List<Car> actualCars = carShop.getCars();


        Assert.assertEquals(expected, actualCars);
    }

    @Test
    public void testCarGetCount() {
        carShop.add(car);
        carShop.add(new Car("Landrover", 116, 3700));
        carShop.add(new Car("reno", 50, 1000));
        int count = carShop.getCount();
        Assert.assertEquals(count, 3);
    }

    @Test
    public void testFindAllCarsWithMaxHorsePower() {
        Car car4 = new Car("audi", 131, 5000);
        Car car2 = new Car("Landrover", 116, 3700);
        Car car3 = new Car("reno", 50, 1000);
        carShop.add(car4);
        carShop.add(car2);
        carShop.add(car3);

        List<Car> expectedCars = new ArrayList<>(Arrays.asList(car4, car2, car3));
        List<Car> actualCars = carShop.findAllCarsWithMaxHorsePower(40);

        Assert.assertEquals(expectedCars, actualCars);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullCar() {
        carShop.add(null);
        Assert.assertNull(car.getModel());
    }

    @Test
    public void testRemoveCar() {
        carShop.add(car);

        Assert.assertTrue(carShop.remove(car));
    }

    @Test
    public void testGetTheMostLuxuryCar() {
        Car car4 = car = new Car("audi", 131, 5000);
        Car car2 = new Car("Landrover", 116, 3700);
        Car car3 = new Car("reno", 50, 1000);
        carShop.add(car4);
        carShop.add(car2);
        carShop.add(car3);

        Car actualCars = carShop.getTheMostLuxuryCar();

        Assert.assertEquals(car, actualCars);
    }

    @Test
    public void testFindAllCarByModel() {
        Car car4 = new Car("audi", 131, 5000);
        Car car2 = new Car("audi", 116, 3700);
        Car car3 = new Car("reno", 50, 1000);
        carShop.add(car4);
        carShop.add(car2);
        carShop.add(car3);

        List<Car> expectedCars = new ArrayList<>(Arrays.asList(car4, car2));
        List<Car> actualCars = carShop.findAllCarByModel("audi");

        Assert.assertEquals(expectedCars, actualCars);
    }
}

