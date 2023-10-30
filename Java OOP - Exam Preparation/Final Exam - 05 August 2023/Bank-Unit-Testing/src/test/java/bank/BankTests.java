package bank;

import org.junit.Assert;
import org.junit.Test;


public class BankTests {

    @Test(expected = NullPointerException.class)
    public void testSetNameNull() {
        Bank bank = new Bank(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameSpaces() {
        Bank bank = new Bank("   ", 1);
    }

    @Test
    public void testCreateBank() {
        Bank bank = new Bank("DSK", 1);
        Assert.assertEquals(bank.getName(), "DSK");
        Assert.assertEquals(1, bank.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityNegative() {
        Bank bank = new Bank("DSK", -2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddClientWithNoMoreCapacity() {
        Bank bank = new Bank("DSK", 1);

        Client client = new Client("Pesho");
        bank.addClient(client);
        Assert.assertEquals(1, bank.getCount());

        Client client2 = new Client("Dido");
        bank.addClient(client2);
    }

    @Test
    public void testAddClientCorrectly() {
        Bank bank = new Bank("DSK", 2);
        Client client = new Client("Pesho");
        Assert.assertEquals(0, bank.getCount());

        bank.addClient(client);
        Assert.assertEquals(bank.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveClientNonExisting() {
        Bank bank = new Bank("DSK", 2);
        bank.removeClient("Petko");
    }

    @Test
    public void testRemoveClientCorrectly() {
        Bank bank = new Bank("DSK", 5);
        Client client = new Client("Pesho");
        Client client2 = new Client("Gosho");
        bank.addClient(client);
        bank.addClient(client2);
        Assert.assertEquals(2, bank.getCount());

        bank.removeClient("Pesho");
        Assert.assertEquals(1,bank.getCount());

        bank.removeClient("Gosho");
        Assert.assertEquals(0, bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoanWithdrawalIfClientIsNull() {
        Bank bank = new Bank("DSK", 5);
        bank.loanWithdrawal("Sasho");
    }

    @Test
    public void testLoanWithdrawalCorrectly() {
        Bank bank = new Bank("DSK", 5);
        Client client = new Client("Pesho");
        bank.addClient(client);

        Client pesho = bank.loanWithdrawal("Pesho");
        Assert.assertFalse(pesho.isApprovedForLoan());
    }

    @Test
    public void testStatistics() {
        Bank bank = new Bank("DSK", 5);
        Client client = new Client("Pesho");
        bank.addClient(client);

        Assert.assertEquals(bank.statistics(), "The client Pesho is at the DSK bank!");

    }
}