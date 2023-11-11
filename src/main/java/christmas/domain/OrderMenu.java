package christmas.domain;

public class OrderMenu {
    private final String menu;
    private final int quantity;

    public OrderMenu(String menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public String getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
