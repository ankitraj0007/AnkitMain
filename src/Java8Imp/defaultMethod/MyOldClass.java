package Java8Imp.defaultMethod;

public class MyOldClass implements MyOldInterface {

    @Override
    public void myAbstractMethod1() {
        System.out.println("abstractMethod1");
    }

    @Override
    public void myAbstractMethod2() {
        System.out.println("abstractMethod2");
    }

    //added later
    public void myDefaultMethod1() {
        System.out.println("MyOldClass: myDefaultMethod1");
    }

}
