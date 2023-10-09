package Java8Imp.fuctionalInterface;

@FunctionalInterface
public interface MyFunctionalInterface {
    //can have one abstarct method and many default and static methods

    //method to be implemented
    public void myAbstractMethod();


    default void myDefaultMethod1() {
        System.out.println("1");
    }

    default void myDefaultMethod2() {

    }

    public static void myStaticMethod1() {

    }

    public static void myStaticMethod2() {

    }
}
