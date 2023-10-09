package cart.item.electronics;

import cart.item.Item;

public class TV extends Item {
    private int size;
    private String refresh_rate;

    public TV(String name, double price, int discount, int size, double quantity, String refresh_rate) {
        super(name, price, discount, quantity);
        this.size = size;
        this.refresh_rate = refresh_rate;
    }
}
