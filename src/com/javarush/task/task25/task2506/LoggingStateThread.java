package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    Thread myThread;
    State state;

    public LoggingStateThread(Thread myThread) {
        this.myThread = myThread;

    }

    @Override
    public void run() {
        State state = null;
        while (true) {
            if (state != myThread.getState()) {
                System.out.println(myThread.getState());
                state = myThread.getState();
                if (state == State.TERMINATED) {
                    break;
                }
            }
        }
    }
}
