package designpattern.behavioural.visitor;

public class Circle implements Shape{
    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitCircle(this);
    }
}
