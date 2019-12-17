package com.skystmm.leetcode.concurency;




import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1117. Building H2O
 * AC : 14 ms use lock&condition
 * @author: skystmm
 * @date: 2019/8/4
 */
public class BuildH2O {

    private Integer count = 0;
    private ReentrantLock lock;
    private Condition hCondition;
    private Condition oCondition;

    public BuildH2O() {
        lock = new ReentrantLock();
        hCondition = lock.newCondition();
        oCondition = lock.newCondition();
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try {
            while (true) {
                if (count < 2) {
                    releaseHydrogen.run();
                    oCondition.signalAll();
                    count++;
                    break;
                }
                if (count == 2) {
                    hCondition.await();

                }
            }

        } finally {
            lock.unlock();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            while (true) {
                if (count == 2) {
                    releaseOxygen.run();
                    count = 0;
                    hCondition.signalAll();
                    break;
                }
                if (count != 2) {
                    oCondition.await();
                }

            }
        } finally {
            lock.unlock();
        }

        // releaseOxygen.run() outputs "O". Do not change or remove this line.

    }
}
