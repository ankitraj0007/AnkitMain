package designpattern.creational.singelton;

public enum SingletonUsingEnum {
    INSTANCE;

    //some methods
    public void connect(){
        System.out.println("connect from SingletonUsingEnum");
    }

    public void disconnect(){
        System.out.println("disconnect from SingletonUsingEnum");
    }
}
