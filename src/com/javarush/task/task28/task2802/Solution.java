package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/*
Пишем свою ThreadFactory
*/

public class Solution {



    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());

            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {

        private static final AtomicInteger a = new AtomicInteger();
        private final int poolNumber;
        private  AtomicInteger threadNumber = new AtomicInteger(1);

        public AmigoThreadFactory() {
            poolNumber = a.incrementAndGet();
        }

        public Thread newThread(Runnable r) {
            Thread factoryThread = new Thread(r, String.format("thread-%d",threadNumber.getAndIncrement()));
            factoryThread.setDaemon(false);
            factoryThread.setPriority(Thread.NORM_PRIORITY);
            String groupName = factoryThread.getThreadGroup().getName();

            String threadName = factoryThread.getName();
            factoryThread.setName(String.format("%s-pool-%s-%s", groupName, poolNumber,threadName ));

            return factoryThread;
        }

    }
}






























