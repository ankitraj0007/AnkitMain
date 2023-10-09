package multithreading;

// data race
public class VolatileExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start withoutVolatileM");
        withoutVolatileM();
        System.out.println("start volatileM");
        volatileM();
        System.out.println("start withSync");
        withSync();

    }

    public static void withoutVolatileM() throws InterruptedException{
        WithoutVolatile aVolatile = new WithoutVolatile();
        Thread t1 = new Thread(() -> {
            for(int i =0; i<Integer.MAX_VALUE; i++){
                aVolatile.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i =0; i<Integer.MAX_VALUE; i++){
                aVolatile.check();
            }
        });

        t1.start();
        t2.start();
    }

    public static void volatileM() throws InterruptedException{
        Volatile aVolatile = new Volatile();
        Thread t1 = new Thread(() -> {
            for(int i =0; i<Integer.MAX_VALUE; i++){
                aVolatile.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i =0; i<Integer.MAX_VALUE; i++){
                aVolatile.check();
            }
        });

        t1.start();
        t2.start();
    }

    public static void withSync() throws InterruptedException{
        Sync sync = new Sync();

        Thread t1 = new Thread(() -> {
            for(int i =0; i<Integer.MAX_VALUE; i++){
                sync.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i =0; i<Integer.MAX_VALUE; i++){
                sync.check();
            }
        });

        t1.start();
        t2.start();
    }


    public static class WithoutVolatile {
        private int x=0;
        private int y=0;

        public void increment(){
            x++;
            y++;
        }

        public void check() {
            if(y>x){
                System.out.println("y > x WithoutVolatile");
            }
        }

    }

    public static class Volatile {
        private volatile int x=0;
        private volatile int y=0;

        public void increment(){
            x++;
            y++;
        }

        public void check() {
            if(y>x){
                System.out.println("y > x Volatile");
            }
        }
    }

    public static class Sync {
        private int x=0;
        private int y=0;

        public synchronized void increment(){
            x++;
            y++;
        }

        public synchronized void check() {
            if(y>x){
                System.out.println("y > x Sync");
            }
        }
    }
}
