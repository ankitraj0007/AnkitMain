package cart.item.fruit;

public class Orange extends Fruit {
    public Orange(double price, int discount, double quantity) {
        super("Orange", price, discount, quantity, false, true);
    }
}
