package threads;

import java.util.*;
import java.util.concurrent.*;

public class ThreadTests{
    public static void main(String[] args) {
        // random values
        Random rand = new Random();
        // test queue of test objects
        Queue<TestObj> theQueue = new LinkedList<TestObj>();

        for (int i = 0; i < 5; i++) {
            int x = rand.nextInt(9);
            TestObj obj = new TestObj(i, x, "a" + x, "f" + x);
            theQueue.offer(obj);
        }

        // end test queue and objects

        //-------------SINGLE THREAD TEST----------------

        // test threads initialize
        TestThread1 testThread1a = new TestThread1(10);
        TestThread1 testThread1b = new TestThread1(20);
        
        // make test threads into threads
        Thread myThread1 = new Thread(testThread1a);
        Thread myThread2 = new Thread(testThread1b);

        //-------------EXECUTOR SERVICE----------------

        // executor service
        ExecutorService service = Executors.newFixedThreadPool(10);

        //-------------RUNNABLE THREAD TEST----------------

        // runnable thread
        ThreadExecutor1 runThread = new ThreadExecutor1();

        //-------------CALLABLE THREAD TEST----------------

        // callable thread
        Callable<String> callThread = new ThreadExecutor1();
        
        // callable thread list
        List<Callable<String>> threadList = new ArrayList<>();

        // future list -> for callable threads
        List<Future<String>> futureList = new ArrayList<>();

        //-------------OBJECT QUEUE THREAD TEST----------------

        // callable thread for receiving objects from Queue
        Callable<String> objThread = new CallableThread(theQueue.poll());

        // list for object thread
        List<Callable<String>> objThrdList = new ArrayList<>();

        // future list for object thread
        List<Future<String>> fObjList = new ArrayList<>();

        //-------------INITIALIZE THREADS/ SERVICES----------------
        
        //-----FIRST TESTS-------
        // # of times threads run
        // for (int i = 0; i < 11; i++) {
        //     // run threads
        //     service.execute(runThread);

        //     // add # of jobs to thread list
        //     threadList.add(callThread);
        // }

        // // invokeAll() -> do want to log
        // try {
        //     futureList = service.invokeAll(threadList, 10000, TimeUnit.MILLISECONDS);
        // } catch (InterruptedException e) {  //  catch used for timeout
        //     e.getCause();
        //     System.out.println("error 1");
        // }

        // submit() -/-> do not want, cannot log
        // // for items in threadList, add to Future, Future results -> futureList
        // for (Callable<String> item: threadList) {
            
        //     // submit items from threadList to Future to process
        //     Future<String> future = service.submit(item);

        //     // add results to futureList
        //     futureList.add(future);
        // }

        // System.out.println();

        // // print results from futureList
        // for(Future<String> f: futureList){
        //     try {
        //         System.out.println(f.get());
        //     } catch (Exception e) {
        //         e.getCause();
        //         System.out.println("error 2");
        //     }
        // }

        //----------OBJECT QUEUE THREAD SERVICE-----------------
        
        // add threads to thread list
        for (int i = 0; i < 10; i++) {
            objThrdList.add(objThread);
        }

        // invoke all
        try {
            fObjList = service.invokeAll(objThrdList, 1000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            System.out.println("service error");
        }

        // print items from future list
        for(Future<String> f: fObjList){
            try {
                System.out.println(f.get());
            } catch (Exception e) {
                System.out.println("print error");
            }
        }

        // stop threads/ service execution -> any remaining threads
        service.shutdown();

        // stop currently running threads/ execution
        service.shutdownNow();

    }
}