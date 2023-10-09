package Java8Imp.stream;

import java.util.stream.Stream;

public class ParallelStreamExample {

    public static void main(String[] args) {
        //sequential
        int sum = Stream.of(1,2,3,4)
                .mapToInt(n->n) //IntStream, primitive stream. to use sum method
//                .mapToInt(Integer::intValue)
//                .mapToInt(n->n.intValue())
                .sum();

        //parallel
        int sumParallel = Stream.of(1,2,3,4)
                .parallel()
                .mapToInt(n->n)
                .sum();
    }
}
