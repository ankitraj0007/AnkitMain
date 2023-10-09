package Java8Imp.defaultMethod;

public interface MyOldInterface {

    //two methods added originally
    void myAbstractMethod1();

    void myAbstractMethod2();

    //added later. can only add default method now or implementing class have compilation error
    default void myDefaultMethod1() {
        System.out.println("MyOldInterface: myDefaultMethod1");
    }

    default void myDefaultMethod2() {
        System.out.println("MyOldInterface: myDefaultMethod2");
    }

    //we can add static method in interface and call it directly using interface
    static void myStatic1() {
        System.out.println("MyOldInterface: myStatic1");
    }

}
