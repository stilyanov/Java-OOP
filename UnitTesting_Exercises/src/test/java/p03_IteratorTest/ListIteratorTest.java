package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private ListIterator listIterator;

    private static final String[] CARS = {"Audi", "VW", "Golf", "Reno"};

    @Before
    public void setListIterator() throws OperationNotSupportedException {
        listIterator = new ListIterator(CARS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorNull() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testMove() {
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());

        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());

        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());

        Assert.assertFalse(listIterator.hasNext());
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyList() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintCorrectly() {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(listIterator.print(), CARS[index]);
            index++;
            listIterator.move();
        }
    }
}