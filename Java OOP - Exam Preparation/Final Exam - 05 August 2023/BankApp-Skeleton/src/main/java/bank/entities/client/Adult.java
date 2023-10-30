package bank.entities.client;

public class Adult extends BaseClient {

    private static final int DEFAULT_INTEREST = 4;
    public Adult(String name, String ID, double income) {
        super(name, ID, DEFAULT_INTEREST, income);
    }

    @Override
    public void increase() {
        super.setInterest(super.getInterest() + 2);
    }
}
