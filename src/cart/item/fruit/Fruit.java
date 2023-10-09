package cart.item.fruit;

import cart.item.Item;

public class Fruit extends Item {

    private boolean is_sweet;
    private boolean is_citric;

    public Fruit(String name, double price, int discount, double quantity, boolean is_sweet, boolean is_citric) {
        super(name, price, discount, quantity);
        this.is_sweet = is_sweet;
        this.is_citric = is_citric;
    }
}
