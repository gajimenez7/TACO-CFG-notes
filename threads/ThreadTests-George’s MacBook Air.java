package threads;

import java.util.*;
import java.util.concurrent.*;

public class ThreadTests{
    public static void main(String[] args) {
        // test queue of test objects
        Queue<Objects> theQueue = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            Object obj = new Object();
            theQueue.offer(obj);
        }

        // test threads initialize
        TestThread1 testThread1a = new TestThread1(10);
        TestThread1 testThread1b = new TestThread1(20);
        
        // make test threads into threads
        Thread myThread1 = new Thread(testThread1a);
        Thread myThread2 = new Thread(testThread1b);

        // executor service
        ExecutorService service = Executors.newFixedThreadPool(10);


        // runnable thread
        ThreadExecutor1 runThread = new ThreadExecutor1();


        // callable thread
        Callable<String> callThread = new ThreadExecutor1();
        
        // callable thread list
        List<Callable<String>> threadList = new ArrayList<>();

        // future list -> for callable threads
        List<Future<String>> futureList = new ArrayList<>();


        // callable thread for receiving objects from Queue
        Callable<Object> objThread = new CallableThread();
        
        // # of times threads run
        for (int i = 0; i < 11; i++) {
            // run threads
            service.execute(runThread);

            // add # of jobs to thread list
            threadList.add(callThread);
        }

        // invokeAll() -> do want to log
        try {
            futureList = service.invokeAll(threadList, 10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {  //  catch used for timeout
            e.getCause();
            System.out.println("error 1");
        }

        // submit() -/-> do not want, cannot log
        // // for items in threadList, add to Future, Future results -> futureList
        // for (Callable<String> item: threadList) {
            
        //     // submit items from threadList to Future to process
        //     Future<String> future = service.submit(item);

        //     // add results to futureList
        //     futureList.add(future);
        // }

        System.out.println();

        // print results from futureList
        for(Future<String> f: futureList){
            try {
                System.out.println(f.get());
            } catch (Exception e) {
                e.getCause();
                System.out.println("error 2");
            }
        }

        // stop threads/ service execution -> any remaining threads
        service.shutdown();

        // stop currently running threads/ execution
        service.shutdownNow();

    }
}