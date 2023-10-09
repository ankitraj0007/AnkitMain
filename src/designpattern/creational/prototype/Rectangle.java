package designpattern.creational.prototype;

public class Rectangle extends Shape{

    public Rectangle(int width, int height) {
        super(width, height);
    }

    @Override
    public void draw() {
        System.out.println("draw Rectangle");
    }

    @Override
    public Shape clone() {
        return new Rectangle(width, height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
