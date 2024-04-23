package threads;

import java.util.concurrent.*;

public class ThreadExecutor1 implements Runnable,Callable<String>{
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread Name(Runnable): " + Thread.currentThread().getName());
    }

    public String call() throws InterruptedException{
        Thread.sleep(1000);
        return "Thread Name(Callable): " + Thread.currentThread().getName();
    }


}