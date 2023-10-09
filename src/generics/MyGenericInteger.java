package generics;

public class MyGenericInteger implements MyGenericInterface<Integer>{

    private Integer a;

    public MyGenericInteger(Integer a) {
        this.a = a;
    }

    @Override
    public void print() {
        System.out.println(a);
    }
}
