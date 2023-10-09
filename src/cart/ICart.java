package cart;

import cart.item.Item;

public interface ICart {

    void add(Item item);

    double calculatePrice();

    double calculateDiscount();

    double TotalPrice();

}
