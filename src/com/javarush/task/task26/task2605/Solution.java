package com.javarush.task.task26.task2605;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
Трудолюбие - душа всякого дела и залог благосостояния
*/

public class Solution {
    private static volatile ScheduledExecutorService interruptScheduledExecutor;
    private static Thread taskThread;
    private static RethrowableTask task;

    public static void main(String[] args) throws Exception {
        runTaskBySchedule(new Runnable() {
                              @Override
                              public void run() {
                                  System.out.println("A");
                                  throw new RuntimeException("it's test");
                              }
                          }, 1_000, TimeUnit.MILLISECONDS
        ); // 1. вызываем метод с анонимным классом, у которого переопределен метод run

        interruptScheduledExecutor.shutdown();
    }

    public static void runTaskBySchedule(final Runnable runnable, long timeout, TimeUnit unit) throws Exception {
        task = new RethrowableTask(runnable); // 2. Создаём новый экземпляр RethrowableTask, аргумент - переопределенный runnable
        taskThread = new Thread(task); //4. создаём объект типа Thread для  запуска нити
        taskThread.start();

        interruptScheduledExecutor = Executors.newScheduledThreadPool(1);
        interruptScheduledExecutor.schedule(new Runnable() {
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);
        Thread.sleep(unit.toMillis(timeout));
        try {
            task.rethrow();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    public static class RethrowableTask implements Runnable {
        private volatile Throwable throwable;
        private Runnable runnable;

        public RethrowableTask(Runnable runnable) {
            this.runnable = runnable; //3. Инициализируем поле runnable
        }

        public void run() {
            try {
                runnable.run(); //5. Пытаемся выполнить метод System.out.println("A"); из main, бросаем исключение
            } catch (Throwable throwable) {
                this.throwable = throwable; // помещаем в поле throwable new RuntimeException("it's test") исключение
            }
        }

        public void rethrow() throws Exception {
            if (throwable != null) {
                System.out.println("B");
                throw new Exception(throwable);
            }
        }
    }
}






























