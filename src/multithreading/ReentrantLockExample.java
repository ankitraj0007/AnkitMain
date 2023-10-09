package multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockExample {

    public static void main(String[] args) throws InterruptedException {

//        fair(); //revisit this, implementation might not be correct
//        unfair(); //revisit this, implementation might not be correct
//        readWriteReentrantLock();
//        reentrantLock();
//        multipleWorker();

    }

    public static void fair() throws InterruptedException {
        ReentrantLock fairLock = new ReentrantLock(true); // fair, will honor the order using queue hence slower

        Thread t1 = new MyFairThread("Job1", fairLock);
        Thread t2 = new MyFairThread("Job2", fairLock);
        Thread t3 = new MyFairThread("Job3", fairLock);
        Thread t4 = new MyFairThread("Job4", fairLock);
        t1.start();
        Thread.sleep(50);
        t2.start();
        Thread.sleep(50);
        t3.start();
        Thread.sleep(50);
        t4.start();
    }

    public static void unfair() throws InterruptedException {
        ReentrantLock unfairLock = new ReentrantLock(false); // unfair, default

        Thread t1 = new MyFairThread("Job1", unfairLock);
        Thread t2 = new MyFairThread("Job2", unfairLock);
        Thread t3 = new MyFairThread("Job3", unfairLock);
        Thread t4 = new MyFairThread("Job4", unfairLock);
        t1.start();
        Thread.sleep(5);
        t2.start();
        Thread.sleep(5);
        t3.start();
        Thread.sleep(5);
        t4.start();
    }

    public static void multipleWorker(){
        ReentrantLock rel = new ReentrantLock();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Runnable w1 = new worker(rel, "Job1");
        Runnable w2 = new worker(rel, "Job2");
        Runnable w3 = new worker(rel, "Job3");
        Runnable w4 = new worker(rel, "Job4");
        pool.execute(w1);
        pool.execute(w2);
        pool.execute(w3);
        pool.execute(w4);
        pool.shutdown();
    }

    //read can be acquired by many while write can be acquired by only one thread
    public static void readWriteReentrantLock() {

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        Lock readLock = reentrantReadWriteLock.readLock();
        Lock writeLock = reentrantReadWriteLock.writeLock();

        //read
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                //multiple reader threads can acquire readLock
                readLock.lock();
                try {
                    System.out.println("reading shared resource");
                } catch (Exception exception) {

                } finally {
                    readLock.unlock();
                }
            });
        }
        executorService.shutdown();

        //write
        for (int i = 0; i < 5; i++) {
            Thread writer = new Thread(() -> {
                //can only be accessed/locked by one writing thread
                //also there shouldn't be any reader at the time
                writeLock.lock();
                try {
                    System.out.println("writing to shared resource");
                } catch (Exception exception) {

                } finally {
                    writeLock.unlock();
                }
            });
            writer.start();
        }

    }

    //to lock unlock manually without using synchronize
    public static void reentrantLock() {
        ReentrantLock reentrantLock = new ReentrantLock();

        reentrantLock.lock();
        try {
            System.out.println("lock acquired");
        } catch (Exception exception) {

        } finally {
            reentrantLock.unlock();
        }

        //try-lock
        if (reentrantLock.tryLock()) {
            try {
                Thread.sleep(1000);
                System.out.println("try-lock acquired");
            } catch (Exception exception) {

            } finally {
                reentrantLock.unlock();
            }
        } else {
            System.out.println("try-lock is not acquired");
        }
    }
}


class worker implements Runnable
{
    String name;
    ReentrantLock re;
    public worker(ReentrantLock rl, String n)
    {
        re = rl;
        name = n;
    }
    public void run()
    {
        boolean done = false;
        while (!done)
        {
            //Getting Outer Lock
            boolean ans = re.tryLock();

            // Returns True if lock is free
            if(ans)
            {
                try
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("task name - "+ name
                            + " outer lock acquired at "
                            + ft.format(d)
                            + " Doing outer work");
                    Thread.sleep(500);

                    // Getting Inner Lock
                    re.lock();
                    try
                    {
                        d = new Date();
                        ft = new SimpleDateFormat("hh:mm:ss");
                        System.out.println("task name - "+ name
                                + " inner lock acquired at "
                                + ft.format(d)
                                + " Doing inner work");
                        System.out.println("Lock Hold Count - "+ re.getHoldCount());
                        Thread.sleep(500);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    finally
                    {
                        //Inner lock release
                        System.out.println("task name - " + name +
                                " releasing inner lock");

                        re.unlock();
                    }
                    System.out.println("Lock Hold Count - " + re.getHoldCount());
                    System.out.println("task name - " + name + " work done");

                    done = true;
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    //Outer lock release
                    System.out.println("task name - " + name +
                            " releasing outer lock");

                    re.unlock();
                    System.out.println("Lock Hold Count - " +
                            re.getHoldCount());
                }
            }
            else
            {
                System.out.println("task name - " + name +
                        " waiting for lock");
                try
                {
                    Thread.sleep(300);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyFairThread extends Thread{
    private ReentrantLock re;

    public MyFairThread(String name, ReentrantLock re) {
        super(name);
        this.re = re;
    }

    @Override
    public void run(){
        System.out.println(re.getQueueLength());
        re.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            re.unlock();
        }
    }
}
