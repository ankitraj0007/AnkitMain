package Java8Imp.methodRefrence;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefrenceExample {

    public static void main(String[] args) {
        mr();
    }

    public static void mr() {
        //<T,R>
        Function<String, String> function = s -> s.toUpperCase();//lambda
        Function<String, String> function2 = String::toUpperCase;//method referencing
        System.out.println(function.apply("ankit"));
        System.out.println(function2.apply("ankit"));

        //<T,T,R>
        BiFunction<String, String, String> biFunction = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> biFunction2 = String::concat;
        System.out.println(biFunction.apply("ankit ", "raj"));
        System.out.println(biFunction2.apply("ankit ", "raj"));

        //<T> void
        Consumer<List<Integer>> consumer = list -> Collections.sort(list);
        ;
        Consumer<List<Integer>> consumer2 = Collections::sort;
        consumer2.accept(Arrays.asList(3, 1, 6, 2, 9));

        Supplier<Integer> supplier = Person::howMany;
        supplier.get();//0
        BiFunction<Person, Person, Integer> biFunction3 = Person::howMany;
        biFunction3.apply(new Person(), new Person());//2
    }

}

class Person {
    public static Integer howMany(Person... persons) {
        return persons.length;
    }
}
