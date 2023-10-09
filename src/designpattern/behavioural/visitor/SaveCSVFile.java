package designpattern.behavioural.visitor;

public class SaveCSVFile implements Visitor{
    @Override
    public void visitCircle(Circle circle) {
        System.out.println("saving circle");
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.println("saving rectangle");
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        System.out.println("saving triangle");
    }
}
