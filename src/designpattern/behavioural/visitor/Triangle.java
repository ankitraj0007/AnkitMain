package designpattern.behavioural.visitor;

public class Triangle implements Shape{
    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitTriangle(this);
    }
}
