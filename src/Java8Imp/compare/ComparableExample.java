package Java8Imp.compare;

import common.pojo.Product;

import java.util.*;

public class ComparableExample {

    public static void main(String[] args) {
        Product product1 = new Product(19,"Laptop");
        Product product2 = new Product(7,"Mac");
        Product product3 = new Product(34,"CPU");

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        Collections.sort(products); // will be sorted on the basis of product id using compareTo method

        System.out.println(products);

        //treeset is automatically sorted using compareTo
        Set<Product> productTreeSet = new TreeSet<>();
        productTreeSet.add(product1);
        productTreeSet.add(product2);
        productTreeSet.add(product3);
        System.out.println(productTreeSet);
    }


}
