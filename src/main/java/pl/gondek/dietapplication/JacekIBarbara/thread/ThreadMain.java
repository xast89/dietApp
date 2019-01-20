package pl.gondek.dietapplication.JacekIBarbara.thread;

public class ThreadMain {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.setName("T1");

        Thread myRunnable = new Thread(new MyRunnable(), "T2");

        myRunnable.start();
        myThread.start();


    }
}
