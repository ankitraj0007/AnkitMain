package common.pojo.order;

import java.util.Arrays;
import java.util.List;

public class OrderMock {
    public static List<Order> generateMockOrders() {
        Item item1 = new Item("Item A", 1);
        Item item2 = new Item("Item B", 2);
        Item item3 = new Item("Item C", 3);
        Item item4 = new Item("Item D", 1);
        Item item5 = new Item("Item E", 4);
        Item item6 = new Item("Item F", 1);
        Item item7 = new Item("Item G", 2);

        Order order1 = new Order("1", Arrays.asList(item1));
        Order order2 = new Order("2", Arrays.asList(item2, item3));
        Order order3 = new Order("3", Arrays.asList(item4));
        Order order4 = new Order("4", Arrays.asList(item5, item6, item7));
        Order order5 = new Order("5", Arrays.asList(item1, item2));

        return Arrays.asList(order1, order2, order3, order4, order5);
    }

    public static void main(String[] args) {
        List<Order> mockOrders = generateMockOrders();
        for (Order order : mockOrders) {
            System.out.println("Order ID: " + order.id);
            for (Item item : order.items) {
                System.out.println("  Item Name: " + item.name + ", Quantity: " + item.quantity);
            }
        }
    }
}
