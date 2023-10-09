package multithreading;

import common.pojo.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        scheduler();
//        example();


    }

    public static void scheduler() throws ExecutionException, InterruptedException{
        //scheduler
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(() -> System.out.println("scheduled"), 200, TimeUnit.MILLISECONDS); //runnable
        scheduledExecutorService.shutdown();

        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();
        Future<String> future1 = scheduledExecutorService1.schedule(() -> "scheduled callable", 200, TimeUnit.MILLISECONDS); // callable
        System.out.println(future1.get());
        scheduledExecutorService1.shutdown();

        ScheduledExecutorService scheduledExecutorService2 = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService2.scheduleWithFixedDelay(() -> System.out.println("scheduleWithFixedDelay"), 200, 100, TimeUnit.MILLISECONDS); //runnable scheduleWithFixedDelay
//        scheduledExecutorService2.shutdown(); //if shutdown then nothing will happen. shutdown manually while testing

        ScheduledExecutorService scheduledExecutorService3 = Executors.newScheduledThreadPool(4);
        scheduledExecutorService3.scheduleAtFixedRate(() -> System.out.println("scheduleAtFixedRate : thread id : " + Thread.currentThread().getId()), 200, 100, TimeUnit.MILLISECONDS); //runnable scheduleAtFixedRate
//        scheduledExecutorService2.shutdown(); //if shutdown then nothing will happen. shutdown manually while testing
    }

    public static void example() throws ExecutionException, InterruptedException{
        //Runnable, execute
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("executorService");
            }
        });
        executorService.shutdown();

        //Runnable, submit, get a future object
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        Future future = executorService1.submit(() -> {
            //lambda way of implementing run method
            System.out.println("executorService1");
        });
        System.out.println(future.get());//null if task executed
        executorService1.shutdown();

        //callable
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        Future futureCallable = executorService2.submit(new Callable() {
            public String call() {
                return "callable";
            }
        });
        System.out.println(futureCallable.get());
        executorService2.shutdown();
    }

    public static void listOfObject(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("appy",31));
        personList.add(new Person("appy1",32));
        personList.add(new Person("appy2",33));
        personList.add(new Person("appy3",34));

        //thread pool, threads keeps on acquiring task as an when they finish the last task.
        //no need to create thread again and again
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(Person person: personList){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(person);
                }
            });
        }

        executorService.shutdown();

        try {

        }catch (Exception exception){

        }finally {
            executorService.shutdown();
        }
    }
}
