package threads;

import java.util.*;
import java.util.concurrent.*;

public class TestThread2 implements Runnable{
    int max;

    TestThread2(int max){
        this.max = max;
    }

    public void ExecuteThreads(int tSize, int max){
        ExecutorService tService = Executors.newFixedThreadPool(tSize);
    }
    

    public void run(){
        try {
            int x = 0;
            for (int i = 0; i < max; i++) {
                x += 1;
                System.out.println("x value: " + x);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }
}