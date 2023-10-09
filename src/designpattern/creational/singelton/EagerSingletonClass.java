package designpattern.creational.singelton;

public class EagerSingletonClass {


    private static EagerSingletonClass singletonInstance = new EagerSingletonClass();

    private EagerSingletonClass() {

    }

    //Get the only object available
    public static EagerSingletonClass getInstance() {
        return singletonInstance;
    }

    //some methods
    public void connect(){
        System.out.println("connect from EagerSingletonClass");
    }

    public void disconnect(){
        System.out.println("disconnect from EagerSingletonClass");
    }

}
