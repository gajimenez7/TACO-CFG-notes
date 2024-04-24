package threads;

import java.util.concurrent.*;

public class CallableThread implements Callable<String>{
    TestObj objThread;

    public CallableThread(TestObj obj) {
        this.objThread = obj;
    }

    /*
     * for the thread, i want to be able to take in an object 
     * from the queue (queue.poll() -> thread -> process object (print attributes))
     * this is to test if there is an instance where a thread grabs the same instance
     * of an object from the queue, which would be bad
     */
    public String call() throws Exception{
        return "TestObj " + objThread.getNum() + " Attributes: " + objThread.getInt() + ", " + objThread.getStr1() + ", " + objThread.getStr2();
    }
}