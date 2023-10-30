package bank.entities.client;

public class Student extends BaseClient {

    private static final int DEFAULT_INTEREST = 2;

    public Student(String name, String ID, double income) {
        super(name, ID, DEFAULT_INTEREST, income);
    }

    @Override
    public void increase() {
        super.setInterest(super.getInterest() + 1);
    }
}
