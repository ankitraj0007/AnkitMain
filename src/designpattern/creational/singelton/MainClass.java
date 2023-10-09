package designpattern.creational.singelton;

public class MainClass {
    public static void main(String[] args) {
        //eager
        EagerSingletonClass singletonObject = EagerSingletonClass.getInstance();
        System.out.println(singletonObject);

        EagerSingletonClass singletonObject2 = EagerSingletonClass.getInstance();
        System.out.println(singletonObject2);

        singletonObject2.connect();

        //lazy
        LazySingletonClass lazySingletonClass = LazySingletonClass.getInstance();
        System.out.println(lazySingletonClass);

        LazySingletonClass lazySingletonClass2 = LazySingletonClass.getInstance();
        System.out.println(lazySingletonClass2);

        lazySingletonClass.connect();

        //synchronized
        //slow
        LazySingletonSynchronizedClass lazySingletonSynchronizedClass = LazySingletonSynchronizedClass.getInstance();
        lazySingletonSynchronizedClass.connect();

        //enum
        // using enum is thread safe as well. no need of synchronization
        SingletonUsingEnum singletonUsingEnum = SingletonUsingEnum.INSTANCE;
        singletonUsingEnum.connect();
    }

}
