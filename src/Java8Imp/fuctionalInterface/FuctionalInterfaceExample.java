package Java8Imp.fuctionalInterface;

import Java8Imp.defaultMethod.MyOldClass;
import Java8Imp.defaultMethod.MyOldInterface;
import Java8Imp.methodRefrence.MyMethodRefrence;

import java.util.Date;
import java.util.function.*;

public class FuctionalInterfaceExample {

    public static void main(String[] args) {
        //using method reference
        MyFunctionalInterface myFunctionalInterface1 = MyMethodRefrence::ref;
        myFunctionalInterface1.myAbstractMethod();

        //using lambda
        MyFunctionalInterface myFunctionalInterface2 = () -> {
            System.out.println("lambda");
        };
        myFunctionalInterface2.myAbstractMethod();

        //another example of lambda
        BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println(a + b);
        biConsumer.accept(10, 20);

        //default method demo
        MyOldClass myOldClass = new MyOldClass();
        myOldClass.myAbstractMethod1();
        myOldClass.myDefaultMethod1();
        myOldClass.myDefaultMethod2();
//		myOldClass.myStatic1(); //this can't be done
        MyOldInterface.myStatic1(); // static interface method can only be called by Interface and not available to implementing class

        //predicate -> functional interface with one abstract boolean method test. can have many default and static mthods
        Predicate<String> strPredicate1 = s -> s.length() >= 5; //<-this is implementation of test method
        System.out.println("str prediate test: " + strPredicate1.test("ankit"));
        Predicate<String> sp = s -> s.contains("Mr");
        System.out.println("str prediate test2: " + sp.test("Mr. Ankit"));
        //predicate merge
        Predicate<String> strPredicate2 = s -> s.length() % 2 == 0;
        System.out.println("predicate merge: " + strPredicate1.or(strPredicate2).test("appy")); // and can also be used
        System.out.println("predicate negate: " + strPredicate1.negate().test("aparna")); // opposite of test
        //BiPredicate -> accepts 2 arguments
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a + b >= 5;
        System.out.println("biPredicate: " + biPredicate.test(2, 1));


        //Function interface -> same as Predicate but can have different output than boolean
        Function<Integer, String> fun = i -> i > 5 ? "ankit" : "aparna";
        System.out.println("Function interface: " + fun.apply(7));
        //Function chaining
        Function<Integer, Integer> fun1 = i -> i * i;
        Function<Integer, Integer> fun2 = i -> i * 2;
        System.out.println("Function chaining andThen: " + fun1.andThen(fun2).apply(4)); //andThen first fun1 will be executed
        System.out.println("Function chaining compose: " + fun1.compose(fun2).apply(4)); //compose first fun2 will be executed
        //BiFunction
        BiFunction<Integer, Integer, Integer> biFunction = (i, j) -> i * j;
        System.out.println("BiFunction: " + biFunction.apply(2, 3));


        //Consumer -> similar to predicate but doesn't return anything
        Consumer<Integer> intConsumer1 = i -> System.out.println("intConsumer1: " + i * i);
        intConsumer1.accept(4);
        Consumer<Integer> intConsumer2 = i -> System.out.println("intConsumer2: " + i * 2);
        intConsumer1.andThen(intConsumer2).accept(5);// there is no consumer method


        //Supplier -> doesn't accept any parameter. returns one output with get method which is the only method in this interface
        Supplier<Date> supplier = () -> new Date();
        System.out.println("Supplier: " + supplier.get()); // no chaining possible or needed

        //UnaryOperator similar to Function but return same type
        UnaryOperator<String> unaryOperator = s -> "My name is " + s;
        System.out.println("UnaryOperator: " + unaryOperator.apply("Ankit"));
        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOperator.apply("this is ", "binaryOperator"));

    }
}
