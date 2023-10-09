package designpattern.creational.singelton;

public class LazySingletonSynchronizedClass {

    private static LazySingletonSynchronizedClass INSTANCE;

    private LazySingletonSynchronizedClass() {

    }

    public static LazySingletonSynchronizedClass getInstance() {
        synchronized (LazySingletonClass.class) {
            if (INSTANCE == null) {
                INSTANCE = new LazySingletonSynchronizedClass();
            }
        }
        return INSTANCE;
    }

    //some methods
    public void connect() {
        System.out.println("connect from LazySingletonSynchronizedClass");
    }

    public void disconnect() {
        System.out.println("disconnect from LazySingletonSynchronizedClass");
    }
}
