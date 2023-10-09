package cart.item;

public class Item implements IItem {

    private String name;
    private double price;
    private int discount;
    private double quantity;

    public Item(String name, double price, int discount, double quantity) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
