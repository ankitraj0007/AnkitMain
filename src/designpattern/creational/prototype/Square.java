package designpattern.creational.prototype;

public class Square extends Shape{

    public Square(int width, int height) {
        super(width, height);
    }

    @Override
    public void draw() {
        System.out.println("draw Square");
    }

    @Override
    public Shape clone() {
        return new Square(width, height);
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
