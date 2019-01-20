package pl.gondek.dietapplication.JacekIBarbara.thread;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(" Thread Running " + Thread.currentThread().getName() );
    }
}
