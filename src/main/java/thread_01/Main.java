package thread_01;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static class MyRunnable implements Runnable{
            private String name;
            public MyRunnable(String name){
                this.name = name;
            }

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(name + " is running: " + i);
                }
                try {
                    Thread.sleep(5000);

                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
    }
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable("Thread 1"));
        Thread thread2 = new Thread(new MyRunnable("Thread 2"));
        thread1.start();
        thread2.start();
    }
}