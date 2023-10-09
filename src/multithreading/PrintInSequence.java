package multithreading;

public class PrintInSequence {
    int counter = 1;
    int N = 10;
    public static void main(String[] args) {
        PrintInSequence printInSequence = new PrintInSequence();

        Thread t1 = new Thread(() -> {
            printInSequence.odd();
        });

        Thread t2 = new Thread(() -> {
            printInSequence.even();
        });

        t1.start();
        t2.start();
    }

    public void even() {
        synchronized (this){
            while (counter < N) {
                if (counter % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(counter);
                counter++;
                notify();
            }
        }
    }

    public void odd() {
        synchronized (this){
            while (counter < N) {
                if(counter%2 == 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(counter);
                counter++;
                notify();
            }
        }
    }

}
