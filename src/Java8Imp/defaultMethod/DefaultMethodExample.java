package Java8Imp.defaultMethod;

public class DefaultMethodExample {

    public static void main(String[] args) {

        //default method demo
        MyOldClass myOldClass = new MyOldClass();
        myOldClass.myAbstractMethod1();
        myOldClass.myDefaultMethod1();
        myOldClass.myDefaultMethod2();
//		myOldClass.myStatic1(); //this can't be done
        MyOldInterface.myStatic1(); // static interface method can only be called by Interface and not available to implementing class


    }


}
