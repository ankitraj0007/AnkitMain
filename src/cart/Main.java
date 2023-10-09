package cart;

import cart.item.electronics.LGTV;
import cart.item.electronics.SamsungTV;
import cart.item.fruit.Apple;
import cart.item.fruit.Orange;
import cart.item.veg.Broccoli;
import cart.item.veg.Onion;

public class Main {



    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.add(new SamsungTV(200.0, 10, 32, 1));
        cart.add(new LGTV(150.0, 5, 40, 1));

        cart.add(new Apple(5.0, 0, 1));
        cart.add(new Orange(5.0, 1, 1));

        cart.add(new Broccoli(2.0, 0, 0.5));
        cart.add(new Onion(1.0, 2, 0.2));

        System.out.println(cart.calculatePrice());
        System.out.println(cart.calculateDiscount());
        System.out.println(cart.TotalPrice());
    }

//    //sort
//    //merge
//
//    public void sort(int[] arr, int start, int end){
//
//        //mid
//
//        //left sort
//
//        //right sort
//
//        //merge
//
//    }
//
//    public void bubbleSort(int[] arr){
//
//        for(int i =0 ; i< arr.length; i++){
//
//            for(int j = i+1; j< arr.length; j++){
//                //swap
//            }
//        }
//    }
}
