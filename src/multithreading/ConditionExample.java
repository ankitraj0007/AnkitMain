package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {
    private Lock lock = new ReentrantLock();
    private Condition conditionMet = lock.newCondition();

    private Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        //using condition
        ConditionExample conditionExample = new ConditionExample();

        Thread t1 = new Thread(() -> conditionExample.method1());
        Thread t2 = new Thread(() -> conditionExample.method2());

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        //using wait and notify
        Thread t3 = new Thread(() -> conditionExample.method3WithWait());
        Thread t4 = new Thread(() -> conditionExample.method4WithNotify());

        t3.start();
        t4.start();
    }

    public void method1() {
        try {
            lock.lock();
            try {
                conditionMet.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("do something after condition met");
        }finally {
            lock.unlock();
        }
    }

    public void method2(){
        try {
            lock.lock();
            System.out.println("do something to meet condition");
            conditionMet.signal();
        }finally {
            lock.unlock();
        }
    }

    public void method3WithWait(){
        synchronized (monitor){
            try {
                monitor.wait();
                System.out.println("execute after notify/wait");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void method4WithNotify(){
        synchronized (monitor){
            System.out.println("execute before notify");
            monitor.notify();
        }
    }
}

class ProducerConsumer{
    private Lock lock = new ReentrantLock();
    Condition add = lock.newCondition();
    Condition remove = lock.newCondition();
    String data;

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread producerThread = new Thread(() -> producerConsumer.producer());
        Thread consumerThread = new Thread(() -> producerConsumer.consumer());

        consumerThread.start();
        producerThread.start();
    }

    public void producer(){
        lock.lock();
        try {
            data = "data";
            System.out.println("produced "+data);
            add.signal();
        }finally {
            lock.unlock();
        }
    }

    public void consumer(){
        lock.lock();
        try {
            add.await();
            System.out.println("consumed "+data);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
