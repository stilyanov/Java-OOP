package WorkingWithAbstraction.P04_HotelReservation;

public enum DiscountType {
    NONE("None", 0),
    SECOND_VISIT("SecondVisit", 0.1),
    VIP("VIP", 0.2);
    private String name;
    private double percent;

    DiscountType(String name, double percent) {
        this.name = name;
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public double getPercent() {
        return percent;
    }
}
