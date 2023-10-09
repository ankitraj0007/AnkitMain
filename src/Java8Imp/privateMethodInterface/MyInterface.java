package Java8Imp.privateMethodInterface;

public interface MyInterface {

    // private method for encapsulation as well as remove duplicate code
    // can be called internally by the interface
    private void myPrivateMethod1(String str){
        System.out.println("in myPrivateMethod1 : " + str);
    }

    // static private method
    private static void myStaticPrivateMethod1(String str){
        System.out.println("in myStaticPrivateMethod1 : " + str);
    }

    // default private method not allowed
//    private default void myDefaultPrivateMethod1(String str){
//        System.out.println("in myStaticPrivateMethod1 : " + str);
//    }


    private void myPrivateMethod2(String str){
        System.out.println("in myPrivateMethod2 : " + str);

        myPrivateMethod1(str); //

        myStaticPrivateMethod1(str); //
    }

    default void myDefault1(){
        System.out.println("my default1");

        myPrivateMethod1("ankit"); //

        myStaticPrivateMethod1("ankit"); //
    }

    static void myStaticMethod(){
        myStaticPrivateMethod1("ankit"); //
    }

    void myAbstractMethod();


}
