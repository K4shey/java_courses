package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    private Thread myThread;

    @Override
    public void run() {
        while (!myThread.isInterrupted()) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                myThread.interrupt();
            }
        }
    }

    @Override
    public void start(String threadName) {
        myThread = new Thread(this, threadName);
        myThread.start();
    }

    @Override
    public void stop() {
        myThread.interrupt();
    }
}






























