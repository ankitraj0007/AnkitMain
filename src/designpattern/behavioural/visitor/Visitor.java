package designpattern.behavioural.visitor;

public interface Visitor {

    public void visitCircle(Circle circle);
    public void visitRectangle(Rectangle rectangle);
    public void visitTriangle(Triangle triangle);
}
