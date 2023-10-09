package designpattern.behavioural.visitor;

public class Rectangle implements Shape{
    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitRectangle(this);
    }
}
