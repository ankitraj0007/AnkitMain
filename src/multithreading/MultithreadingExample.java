package multithreading;

public class MultithreadingExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        System.out.println(Thread.currentThread().getName());
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getPriority());
                throw new RuntimeException("intentional");     // for setUncaughtExceptionHandler
            }
        });

        thread1.setName("ankit thread");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("critical exception in thread: "+t.getName()+ ", the error is:"+e.getMessage());
            }
        });
        thread1.start();


        Thread thread2 = new MyThread();
        thread2.start();

        Thread thread3 = new Thread(new MyRunnable());
        thread3.start();

        Thread thread4 = new Thread(new LongRunning());
        thread4.start();
        thread4.interrupt();

        Thread thread5 = new SleepingThread();
        thread5.start();
        thread5.interrupt();

        Thread thread6 = new Thread(new SleepingThread());
        thread6.setDaemon(true); //daemon thread will not prevent application from termination
        thread6.start();

    }

    public static class MyThread extends Thread{

        @Override
        public void run(){
            System.out.println("in MyThread : "+ this.getName());
        }
    }

    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("in MyRunnable");
        }
    }

    public static class LongRunning implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i<1000000000 ;i ++){
                System.out.println("curr integer: "+i);
                //if interrupt
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("interrupted");
                    break;
                }
            }
        }
    }

    public static class SleepingThread extends Thread{

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    System.out.println("SleepingThread interrupted");
                    return; // must return
                }
            }
        }
    }

}
