package generics;

import common.pojo.Employee;

public class Main {

    public static void main(String[] args) {
        MyGeneric<String> stringMyGeneric = new MyGeneric<>("Ankit");
        stringMyGeneric.print();

        MyGeneric<Employee> employeeMyGeneric = new MyGeneric<>(new Employee("ankit","raj",1000,"dept1"));
        employeeMyGeneric.print();

        MyGenericInteger myGenericInteger = new MyGenericInteger(2);
        myGenericInteger.print();

        myGenericMethod("raj",1000);

        MyGeneric myGeneric = myGenericReturn(2.2);
        myGeneric.print();
    }

    public static <T,U> void myGenericMethod(T t, U u){
        System.out.println("print from myGenericMethod: " + t + " , " +u);
    }

    public static <T> MyGeneric<T> myGenericReturn(T t){
        return new MyGeneric<>(t);
    }
}
