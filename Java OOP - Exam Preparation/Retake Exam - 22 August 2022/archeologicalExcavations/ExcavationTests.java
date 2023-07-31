package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Retention;

public class ExcavationTests {

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistWithMaxCapacity() {
        Excavation excavation = new Excavation("Rila", 1);
        Archaeologist archaeologist = new Archaeologist("Petar", 50);
        Archaeologist archaeologist2 = new Archaeologist("Mitko", 20);
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist2);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNull() {
        new Excavation(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameEmpty() {
        new Excavation("    ", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityNegative() {
        new Excavation("Rila", -5);
    }

    @Test
    public void testGetCount() {
        Excavation excavation = new Excavation("Rila", 5);
        Archaeologist archaeologist = new Archaeologist("Petar", 50);
        Archaeologist archaeologist2 = new Archaeologist("Mitko", 20);
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist2);
        int count = excavation.getCount();
        Assert.assertEquals(count, 2);
    }

    @Test
    public void testGetName() {
        Excavation excavation = new Excavation("Rila", 5);
        Assert.assertEquals(excavation.getName(), "Rila");
    }

    @Test
    public void testRemoveArchaeologist() {
        Excavation excavation = new Excavation("Rila", 5);
        Archaeologist archaeologist = new Archaeologist("Petar", 50);
        Archaeologist archaeologist2 = new Archaeologist("Mitko", 20);
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist2);
        boolean petar = excavation.removeArchaeologist("Petar");
        Assert.assertTrue(petar);
        Assert.assertEquals(excavation.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExistUnknownArchaeologist() {
        Excavation excavation = new Excavation("Rila", 5);
        Archaeologist archaeologist = new Archaeologist("Petar", 50);
        Archaeologist archaeologist2 = new Archaeologist("Petar", 20);
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist2);
    }
}
