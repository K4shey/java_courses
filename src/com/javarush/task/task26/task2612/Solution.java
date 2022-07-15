package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Весь мир играет комедию
*/

public class Solution {
    //    protected Lock lock = new ReentrantLock();
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        // Implement the logic here. Use the lock field
        boolean lockSetted = false;
        try {
            if (lock.tryLock()) {
                actionIfLockIsFree();
                lockSetted = true;
            } else {
                actionIfLockIsBusy();
            }
        } catch (Exception e) {
            lock.unlock();
        } finally {
            if (lockSetted) {
                lock.unlock();
            }
        }
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}






























