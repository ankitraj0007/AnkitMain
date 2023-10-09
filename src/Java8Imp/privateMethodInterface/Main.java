package Java8Imp.privateMethodInterface;

public class Main {

    public static void main(String[] args) {
        MyInterface.myStaticMethod();
//        MyInterface.myPrivateMethod1(); //can't

        MyInterface obj = new MyClass();
        obj.myDefault1();
//        obj.myPrivateMethod1(); //can't
    }
}
