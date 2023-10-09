package cart;

import cart.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Cart implements ICart{

    List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public double calculatePrice() {
        return items.stream().map(
                item -> item.getPrice() * item.getQuantity()
        ).reduce(0.0, Double::sum);
    }

    @Override
    public double calculateDiscount() {
        return items.stream().map(item ->
            item.getPrice() * item.getQuantity() * item.getDiscount()/100
        ).reduce(0.0, Double::sum);
    }

    @Override
    public double TotalPrice() {
        return calculatePrice() - calculateDiscount();
    }


}
