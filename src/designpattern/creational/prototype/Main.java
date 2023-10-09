package designpattern.creational.prototype;

public class Main {

    public static void main(String[] args) {
        Shape square = new Square(2,5);
        Shape squareClone = square.clone();

        System.out.println(square);
        System.out.println(squareClone);

        if(square.equals(squareClone))
            System.out.println(true);
        else
            System.out.println(false);


    }
}
