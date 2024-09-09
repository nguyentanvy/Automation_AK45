package thread;

public class MyRunnable implements Runnable{
    private Counter counter;
    public MyRunnable(Counter counter){
        this.counter = counter;
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            counter.increment();
        }
    }
}
