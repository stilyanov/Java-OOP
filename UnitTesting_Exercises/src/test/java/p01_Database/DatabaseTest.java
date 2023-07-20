package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] NUMBERS = {3, 6, 9, 5, 10, 26};

    @Before
    public void setDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }
    @Test
    public void testConstructorElements(){
        Assert.assertArrayEquals(NUMBERS, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorIndex() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testAddElementToNextFreeCell() throws OperationNotSupportedException {
        database.add(30);
        Integer[] afterAddedNewElement = database.getElements();
        Assert.assertArrayEquals(database.getElements(), afterAddedNewElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddElementNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddElementUnderOneSize() throws OperationNotSupportedException {
        Integer[] numbersUnderOne = new Integer[0];
        new Database(numbersUnderOne);
    }

    @Test
    public void testRemoveElementAtTheLastIndex() throws OperationNotSupportedException {
        Integer[] numbersBefore = {3, 6, 9, 5, 10, 26};
        Database database = new Database(numbersBefore);
        database.remove();
        Integer[] numbersAfter = {3, 6, 9, 5, 10};
        Assert.assertArrayEquals(database.getElements(), numbersAfter);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyDatabase() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[1];
        Database database = new Database(numbers);
        database.remove();
        database.remove();
        database.remove();
    }

    @Test
    public void testIndex() throws OperationNotSupportedException {
        Integer[] numbers = {3, 6, 9, 5, 10, 26};
        Database database = new Database(numbers);
        int index = database.getIndex();
        Assert.assertEquals(index, database.getElementsCount() - 1);
    }
}
