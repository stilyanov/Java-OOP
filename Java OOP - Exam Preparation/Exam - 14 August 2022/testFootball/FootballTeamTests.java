package football;

import org.junit.Assert;
import org.junit.Test;

public class FootballTeamTests {

    @Test(expected = NullPointerException.class)
    public void testSetNameNull() {
        FootballTeam footballTeam = new FootballTeam(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameEmptySpace() {
        FootballTeam footballTeam = new FootballTeam("    ", 10);
    }

    @Test
    public void testGetNameProperly() {
        FootballTeam footballTeam = new FootballTeam("CSKA", 12);
        Assert.assertEquals(footballTeam.getName(), "CSKA");
    }

    @Test
    public void testSetNameProperly() {
        FootballTeam footballTeam = new FootballTeam("CSKA", 12);
        Assert.assertEquals(footballTeam.getName(), "CSKA");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerOnFullTeam() {
        FootballTeam footballTeam = new FootballTeam("CSKA", 1);
        Footballer footballer = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVacantPositionsNegative() {
        FootballTeam footballTeam = new FootballTeam("CSKA", -5);
    }

    @Test
    public void testVacantPositions() {
        FootballTeam footballTeam = new FootballTeam("CSKA", 5);
        Assert.assertEquals(footballTeam.getVacantPositions(), 5);
    }

    @Test
    public void testGetCount() {
        FootballTeam footballTeam = new FootballTeam("CSKA", 4);
        Footballer footballer = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);
        Assert.assertEquals(footballTeam.getCount(), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerNullName(){
        FootballTeam footballTeam = new FootballTeam("CSKA", 4);
        Footballer footballer = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);

        footballTeam.removeFootballer("Vladi");
    }

    @Test
    public void testRemoveFootballerName(){
        FootballTeam footballTeam = new FootballTeam("CSKA", 4);
        Footballer footballer = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);
        footballTeam.removeFootballer("Messi");
        Assert.assertEquals(footballTeam.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleWithInvalidName() {
        FootballTeam footballTeam = new FootballTeam("CSKA", 4);
        Footballer footballer = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);
        footballTeam.footballerForSale("Vladi");
    }

    @Test
    public void testFootballerForSaleWithValidName() {
        FootballTeam footballTeam = new FootballTeam("CSKA", 4);
        Footballer footballer = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);
        footballTeam.footballerForSale("Messi");

        Assert.assertFalse(footballer.isActive());
    }

    @Test
    public void testGetStatistics() {
        FootballTeam footballTeam = new FootballTeam("CSKA", 4);
        Footballer footballer = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);

        footballTeam.getStatistics();
    }
}
