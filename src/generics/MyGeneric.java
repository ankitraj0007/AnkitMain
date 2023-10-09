package generics;

public class MyGeneric<T>{

    private T t;

    public MyGeneric(T t) {
        this.t = t;
    }

    public void print(){
        System.out.println(t);
    }
}
