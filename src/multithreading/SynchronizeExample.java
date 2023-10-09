package multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizeExample {

    public static void main(String[] args) throws InterruptedException {
        SynchronizeExample synchronizeExample = new SynchronizeExample();

//        synchronizeExample.syncVsLock();
        atomic();
//        nonSync();
//        sync();
//        lock();

    }


    public void syncVsLock(){
        //synchronized
        synchronized (this){ // can be used at method level as well
            System.out.println("synchronized");
        }

        //lock
        Lock lock = new ReentrantLock();
        lock.lock(); // start
        System.out.println("lock");
        lock.unlock(); // end , put in finally block
    }

    public static void atomic() throws InterruptedException {
        AtomicInventory inventory = new AtomicInventory();
        IncrementThread incrementThread = new IncrementThread(inventory);
        DecrementThread decrementThread = new DecrementThread(inventory);

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        System.out.println("atomic: "+inventory.getItem() + " items left");
    }

    public static void nonSync() throws InterruptedException {
        Inventory inventory = new Inventory();
        IncrementThread incrementThread = new IncrementThread(inventory);
        DecrementThread decrementThread = new DecrementThread(inventory);

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        System.out.println("nonSync: "+inventory.getItem() + " items left");
    }

    public static void sync() throws InterruptedException {
        SyncInventory syncInventory = new SyncInventory();
        IncrementThread syncIncrementThread = new IncrementThread(syncInventory);
        DecrementThread syncDecrementThread = new DecrementThread(syncInventory);

        syncIncrementThread.start();
        syncDecrementThread.start();

        syncIncrementThread.join();
        syncDecrementThread.join();
        System.out.println("sync: "+syncInventory.getItem() + " items left");
    }

    public static void lock() throws InterruptedException {
        LockSyncInventory lockSyncInventory = new LockSyncInventory();
        IncrementThread lockSyncIncrementThread = new IncrementThread(lockSyncInventory);
        DecrementThread lockSyncDecrementThread = new DecrementThread(lockSyncInventory);

        lockSyncIncrementThread.start();
        lockSyncDecrementThread.start();

        lockSyncIncrementThread.join();
        lockSyncDecrementThread.join();

        System.out.println("lock: "+lockSyncInventory.getItem() + " items left");
    }

    public static class IncrementThread extends Thread{
        private IInventory inventory;

        public IncrementThread(IInventory inventory){
            this.inventory = inventory;
        }

        @Override
        public void run(){
            for (int i=0; i<10000; i++){
                inventory.increment();
            }
        }

    }

    public static class DecrementThread extends Thread{
        private IInventory inventory;

        public DecrementThread(IInventory inventory){
            this.inventory = inventory;
        }

        @Override
        public void run(){
            for (int i=0; i<10000; i++){
                inventory.decrement();
            }
        }
    }

    public interface IInventory{
        void decrement();
        void increment();
    }

    public static class Inventory implements IInventory {
        int item;

        public void decrement(){
            this.item--;
        }

        public void increment(){
            this.item++;
        }

        public int getItem() {
            return item;
        }

    }

    public static class SyncInventory implements IInventory {
        int item;

        //shared variable item will be synchronized
        public synchronized void decrement(){
            this.item--;
        }

        public synchronized void increment(){
            this.item++;
        }

        public int getItem() {
            return item;
        }

    }

    public static class LockSyncInventory implements IInventory {
        int item;

        Object lock = new Object();

        public void decrement(){
            synchronized (lock){
                this.item--;
            }
        }

        public void increment(){
            synchronized (lock){
                this.item++;
            }
        }

        public int getItem() {
            return item;
        }

    }

    public static class AtomicInventory implements IInventory{
        AtomicInteger item = new AtomicInteger(0);

        @Override
        public void decrement() {
            item.decrementAndGet();
        }

        @Override
        public void increment() {
            item.incrementAndGet();
        }

        public int getItem() {
            return item.get();
        }
    }



}
