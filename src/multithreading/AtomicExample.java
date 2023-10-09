package multithreading;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicExample {

    public static void main(String[] args) throws InterruptedException {
        atomicRef();
        atomicInt();
    }

    public static void atomicRef(){
        String oldStr = "old str";
        String newStr = "new str";
        String latestStr = "latest str";

        AtomicReference<String> atomicReference = new AtomicReference<>(oldStr);

        if(atomicReference.compareAndSet(oldStr, newStr)){ // compare oldStr to be the existing value -> update to new
            System.out.println(atomicReference.get());
        }

//        atomicReference.set("modern str");
        if(atomicReference.compareAndSet(oldStr, latestStr)){ // this will not update as atomicReference is no longer oldStr
            System.out.println(atomicReference.get());
        }
    }

    public static void atomicInt() throws InterruptedException {
        SynchronizeExample.atomic();
    }




}


