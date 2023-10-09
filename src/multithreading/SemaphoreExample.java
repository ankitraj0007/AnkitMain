package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class SemaphoreExample implements Runnable{

    private Semaphore semaphore = new Semaphore(3); //permits max 3 threads at a time
    private Semaphore semaphore1 = new Semaphore(3,true); // along with fairness

    public static void main(String[] args) {
        SemaphoreExample semaphoreExample = new SemaphoreExample();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 100; i++){
            executorService.execute(new Thread(() -> semaphoreExample.run()));
        }
//        IntStream.of(100).forEach(i -> executorService.execute(new Thread(() -> semaphoreExample.run())));
        executorService.shutdown();
    }


    @Override
    public void run() {
        try {
            semaphore.acquire(); // can be acquired by 3 threads max
            System.out.println("using semaphore");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

