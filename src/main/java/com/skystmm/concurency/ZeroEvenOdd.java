package com.skystmm.concurency;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 1116. Print Zero Even Odd
 * AC : 4ms
 * @author: skystmm
 * @date: 2019/8/4
 */
class ZeroEvenOdd {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition evenCondition = lock.newCondition();
    private Condition oddCondition = lock.newCondition();
    private Condition zeroCondition = lock.newCondition();

    private  Integer flag = 0;


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i<=n;i++){
            lock.lock();
            try {
                while (flag != 0) {
                    zeroCondition.await();
                }
                printNumber.accept(0);
                if (i % 2 == 0) {
                    evenCondition.signalAll();
                    flag = 2;
                } else {
                    oddCondition.signalAll();
                    flag = 1;
                }
            } finally {
                lock.unlock();
            }


        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i<=n;i+=2){
            lock.lock();
            try {
                while (flag != 2) {
                    evenCondition.await();
                }
                printNumber.accept(i);
                flag = 0;
                zeroCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i<=n;i+=2){
            lock.lock();
            try {
                while (flag != 1) {
                    oddCondition.await();
                }
                printNumber.accept(i);
                flag = 0;
                zeroCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }

    }


}
