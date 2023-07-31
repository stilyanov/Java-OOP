package petStore;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetStoreTests {

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalWithNullParameter() {
        PetStore petStore = new PetStore();
        petStore.addAnimal(null);
    }

    @Test
    public void testAddAnimalCorrectly() {
        PetStore petStore = new PetStore();
        Animal animal = new Animal("dog", 10, 150.0);
        petStore.addAnimal(animal);
        Assert.assertEquals(petStore.getCount(), 1);
        Assert.assertEquals(animal.getSpecie(), "dog");
    }

    @Test
    public void testGetAnimals() {
        Animal animal = new Animal("dog", 10, 100.21);
        List<Animal> expected = new ArrayList<>();
        expected.add(animal);

        PetStore petStore = new PetStore();
        petStore.addAnimal(animal);

        List<Animal> actual = petStore.getAnimals();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void testGetCount() {
        PetStore petStore = new PetStore();
        Animal animal = new Animal("dog", 10, 150);
        Animal animal2 = new Animal("cat", 5, 200);
        petStore.addAnimal(animal);
        petStore.addAnimal(animal2);
        Assert.assertEquals(petStore.getCount(), 2);
    }

    @Test
    public void testFindAllAnimalsWithMaxKilograms() {
        PetStore petStore = new PetStore();
        Animal animal = new Animal("dog", 10, 150);
        Animal animal2 = new Animal("cat", 5, 200);
        petStore.addAnimal(animal);
        petStore.addAnimal(animal2);

        List<Animal> expectedAnimals = new ArrayList<>(Arrays.asList(animal));
        List<Animal> allAnimalsWithMaxKilograms = petStore.findAllAnimalsWithMaxKilograms(5);

        Assert.assertEquals(expectedAnimals, allAnimalsWithMaxKilograms);
    }

    @Test
    public void testGetTheMostExpensiveAnimal() {
        PetStore petStore = new PetStore();
        Animal animal = new Animal("dog", 10, 150);
        Animal animal2 = new Animal("cat", 5, 200);
        petStore.addAnimal(animal);
        petStore.addAnimal(animal2);

        Animal theMostExpensiveAnimal = petStore.getTheMostExpensiveAnimal();
        Assert.assertEquals(theMostExpensiveAnimal, animal2);
    }

    @Test
    public void testFindAllAnimalBySpecie() {
        PetStore petStore = new PetStore();
        Animal animal = new Animal("dog", 10, 150);
        Animal animal2 = new Animal("cat", 5, 200);
        Animal animal3 = new Animal("dog", 15, 130.3);
        petStore.addAnimal(animal);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        List<Animal> expected = new ArrayList<>(Arrays.asList(animal, animal3));
        List<Animal> actual = petStore.findAllAnimalBySpecie("dog");

        Assert.assertEquals(expected, actual);
    }
}

