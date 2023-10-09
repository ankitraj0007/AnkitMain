package Java8Imp.privateMethodInterface;

public class MyClass implements MyInterface{

    @Override
    public void myDefault1() {
        MyInterface.super.myDefault1();
    }

    @Override
    public void myAbstractMethod() {
        System.out.println("myAbstractMethod");
    }
}
