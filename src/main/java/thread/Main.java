package thread;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(new MyRunnable(counter));
        Thread t2 = new Thread(new MyRunnable(counter));
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Count:" + counter.getCount());
    }
}