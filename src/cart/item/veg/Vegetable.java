package cart.item.veg;

import cart.item.Item;

public class Vegetable extends Item {

    private boolean is_bulb;
    private boolean is_flower;


    public Vegetable(String name, double price, int discount, double quantity, boolean is_bulb, boolean is_flower) {
        super(name, price, discount,quantity);
        this.is_bulb = is_bulb;
        this.is_flower = is_flower;
    }
}
