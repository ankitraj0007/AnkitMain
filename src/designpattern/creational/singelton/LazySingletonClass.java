package designpattern.creational.singelton;

public class LazySingletonClass {

    private static LazySingletonClass INSTANCE;

    private LazySingletonClass(){

    }

    public static LazySingletonClass getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LazySingletonClass();
        }
        return INSTANCE;
    }

    //some methods
    public void connect(){
        System.out.println("connect from LazySingletonClass");
    }

    public void disconnect(){
        System.out.println("disconnect from LazySingletonClass");
    }
}
