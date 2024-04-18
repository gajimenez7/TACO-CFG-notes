package threads;

public class ThreadTests{
    public static void main(String[] args) {
        TestThread testThread1 = new TestThread(10);
        TestThread testThread2 = new TestThread(20);
        
        Thread myThread1 = new Thread(testThread1);
        Thread myThread2 = new Thread(testThread2);
        
        myThread1.start();
        myThread2.start();

    }
}