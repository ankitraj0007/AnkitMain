package multithreading;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class IOBound {

    private static final int NUMBER_OF_TASKS = 10_000;

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        System.out.println("press enter");
//        s.nextLine();
        System.out.printf("running %d tasks\n", NUMBER_OF_TASKS);

        long start = System.currentTimeMillis();
        performTask();
        System.out.printf("time taken: %dms ",System.currentTimeMillis() - start);
    }

    private static void performTask() {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            executorService.execute(() -> ioTask()); //thread per task/request
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void ioTask() {
        System.out.println("executing task from : "+Thread.currentThread());
        try {
            Thread.sleep(1000); // stimulates io call
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
