package Java8Imp.generic;

import common.pojo.Cat;
import common.pojo.vehicle.*;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {

    public static void main(String[] args) {
//        List<Object> objects = new ArrayList<String>(); //not allowed Object <-> String or anything
        List<String> strings = new ArrayList<>(); //type infer from left
        List<String> stringList = new ArrayList<String>();

//        List<Integer> integers = new ArrayList<Number>(); // not allowed


        //**wildcard**
        List<?> integers = new ArrayList<Number>(); //unbounded wildcard, readonly,
//        integers.add(1); //can't add

        List<? extends Number> list = new ArrayList<Integer>(); //upper bounded wildcard, list type can be any child of Number, readonly
//        list.add(1); //can't add

        List<? super Number> list1 = new ArrayList<Object>(); //lower bound wildcard, list type can be any Parent of Number, can add
        list1.add(1);

        //unbounded wildcard
        List<String> stringList1 = new ArrayList<String>();
        stringList1.add("anky");
//        print(stringList1); error
        printUnbound(stringList1);

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("rea","white"));
        printUnbound(cats);

        //upper bounded wildcard
        List<? extends Vehicle> vehicles1 = new ArrayList<TwoWheeler>();
        List<? extends Vehicle> vehicles2 = new ArrayList<FourWheeler>();
        List<? extends Vehicle> vehicles3 = new ArrayList<Car>();
        List<? extends Vehicle> vehicles4 = new ArrayList<Bike>();

        //lower bound wildcard
        List<? super Car> vehicles6 = new ArrayList<FourWheeler>();
        List<? super Car> vehicles7 = new ArrayList<Vehicle>();
        List<? super Car> vehicles8 = new ArrayList<Object>();

        List<? super FourWheeler> vehicles9 = new ArrayList<Vehicle>();
        List<? super FourWheeler> vehicles10 = new ArrayList<Object>();
        printLowerBound(vehicles9);
        printLowerBound(vehicles10);
    }

    public static void print(List<Object> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void printUnbound(List<?> list){
        for (Object o : list){
            System.out.println(o);
        }
//        list.add("appy"); // can't add , compile error
    }

    public static void printUpperBound(List<? extends Vehicle> vehicles){
        for(Vehicle vehicle: vehicles){
            System.out.println(vehicle);
        }
//        vehicles.add(new Bike()); // can't add , compile error
    }

    public static void printLowerBound(List<? super FourWheeler> objects){
        objects.add(new Car()); // can add, is-a relation holds true here
//        objects.add(new TwoWheeler()); can't add
        for (Object o: objects){
            System.out.println(0);
        }
    }
}
