package christmas.domain;

public class Discount {
    private final VisitDate visitDate;
    private final Order order;

    public Discount(final VisitDate visitDate, final Order order) {
        this.visitDate = visitDate;
        this.order = order;
    }

    private int calculateDay() {
        int date = getDate();
        if (date <= 25) {
            return 1000 + (date - 1) * 100;
        }
        return 0;
    }

    private int getDate() {
        return visitDate.getDate();
    }

    private String getDay() {
        return visitDate.getDay();
    }
}
