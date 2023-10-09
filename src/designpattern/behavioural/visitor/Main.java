package designpattern.behavioural.visitor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle());
        shapes.add(new Triangle());
        shapes.add(new Rectangle());

        Visitor save = new SaveCSVFile(); // visitor

        for (Shape shape : shapes)
            shape.acceptVisitor(save); // accept visitor
    }


}
