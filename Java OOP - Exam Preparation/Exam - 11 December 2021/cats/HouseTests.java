package cats;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class HouseTests {
    private House house;
    private Cat cat;

    @Before
    public void setUp() {
        house = new House("Home", 5);
        cat = new Cat("Pesho");
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNullThrowsException() {
        new House(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameEmptySpaceThrowsException() {
        new House("    ", 10);
    }

    @Test
    public void testSetNameCorrectly() {
        assertEquals(house.getName(), "Home");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityZeroThrowsException() {
        new House("Home", -5);
    }

    @Test
    public void testSetCapacityCorrectly() {
        assertEquals(house.getCapacity(), 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatWithNoMoreCapacity() {
        Cat cat2 = new Cat("gosho");
        Cat cat3 = new Cat("gosho");
        Cat cat4 = new Cat("gosho");
        Cat cat5 = new Cat("gosho");
        Cat cat6 = new Cat("gosho");
        house.addCat(cat);
        house.addCat(cat2);
        house.addCat(cat3);
        house.addCat(cat4);
        house.addCat(cat5);
        house.addCat(cat6);
    }

    @Test
    public void testAddCatCorrectly() {
        house.addCat(cat);

        assertEquals(cat.getName(), "Pesho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatNonExisting() {
        house.removeCat(null);
    }

    @Test
    public void testRemoveCatCorrectly() {
        house.addCat(cat);
        house.removeCat("Pesho");
        assertEquals(house.getCount(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleWithNullNameThrowsException() {
        house.catForSale(null);
    }

    @Test
    public void testCatForSaleCorrectly() {
        house.addCat(cat);
        house.catForSale("Pesho");
    }

    @Test
    public void testGetStatistics() {
        house.addCat(cat);
        assertEquals(house.statistics(), "The cat Pesho is in the house Home!");
    }

    @Test
    public void testCatIsHungry() {
        house.addCat(cat);
        assertTrue(cat.isHungry());
    }
}
