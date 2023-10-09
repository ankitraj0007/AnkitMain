package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExample {
    public static final int N = 10;

    public static void main(String[] args) {
        Runnable runnable = () -> blockingTask();

        //create virtual thread, available in java 21 (from 19)
//        Thread virtualThread = Thread.ofVirtual().start(runnable);
//        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    }

    public static void blockingTask(){
        System.out.println("thread : "+Thread.currentThread()+" before blocking call");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("thread : "+Thread.currentThread()+" after blocking call");
    }
}
