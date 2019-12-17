package com.skystmm.leetcode.concurency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1115. Print FooBar Alternately
 * AC ：15 ms
 * @author: skystmm
 * @date: 2019/8/5
 */
class FooBar {
    private int n;

    private ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private boolean flag =true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try{
                while(!flag){
                    fooCondition.await();
                }
                printFoo.run();
                flag = false;
                barCondition.signalAll();
            }finally {
                lock.unlock();
            }

            // printFoo.run() outputs "foo". Do not change or remove this line.

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try{
                while(flag){
                    barCondition.await();
                }
                printBar.run();
                flag = true;
                fooCondition.signalAll();
            }finally {
                lock.unlock();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        }
    }
}
