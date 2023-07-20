package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Person[] PEOPLE = {new Person(1, "Pesho"),
            new Person(2, "Gosho"),
            new Person(3, "Sasho")};


    @Before
    public void setDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorHasCreateCorrectObject() {
        Person[] databaseElements = database.getElements();

        Assert.assertArrayEquals(PEOPLE, databaseElements);
        Assert.assertEquals(database.getElementsCount(), PEOPLE.length);
        Assert.assertEquals(PEOPLE.length - 1, database.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorThrowExceptionWhenLessThanOneElement() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorThrowExceptionWhenNullParam() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        Person[] elementsBefore = database.getElements();

        database.add(new Person(4, "Vladi"));
        Person[] elementsAfter = database.getElements();
        Assert.assertEquals(elementsBefore.length + 1, elementsAfter.length);

        Person lastPerson = elementsAfter[elementsAfter.length - 1];
        Assert.assertEquals(lastPerson.getId(), 4);
        Assert.assertEquals(lastPerson.getUsername(), "Vladi");
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        Person[] elementsBefore = database.getElements();
        database.remove();
        Person[] elementsAfter = database.getElements();

        Assert.assertEquals(elementsBefore.length - 1, elementsAfter.length);

        Person lastPerson = elementsAfter[elementsAfter.length - 1];
        Assert.assertEquals(lastPerson.getUsername(), "Gosho");

        Assert.assertEquals(lastPerson.getId(), 2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowExceptionInvalidIndex() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }

        database.remove();
    }

    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        Person person = database.findByUsername("Sasho");
        Assert.assertEquals("Invalid id of the taken person!", person.getId(), 3);
        Assert.assertEquals("Invalid username of the taken person!", person.getUsername(), "Sasho");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameAddNull() throws OperationNotSupportedException {
        database.add(null);
        Assert.assertEquals(database.getIndex(), null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameMoreThanOnePerson() throws OperationNotSupportedException {
        database.add(new Person(4, "Pesho"));
        database.findByUsername("Pesho");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameNonExistingUsername() throws OperationNotSupportedException {
        database.findByUsername("Toni");
    }

    @Test
    public void testFindById() throws OperationNotSupportedException {
        Person person = database.findById(3);

        Assert.assertEquals(person.getId(), 3);
        Assert.assertEquals(person.getUsername(), "Sasho");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdMoreThanOneId() throws OperationNotSupportedException {
        database.add(new Person(3, "Petko"));
        database.findById(3);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdNonExistingId() throws OperationNotSupportedException {
        database.findById(5);
    }
}
