package com.skystmm.concurency;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1114. Print in Order
 * AC :9 ms
 * @author: skystmm
 * @date: 2019/8/4
 */
public class PrintinOrder {

    private AtomicInteger count = new AtomicInteger(0);
    public PrintinOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
       while(true){
           if(count.get() % 3 == 0  ){
               printFirst.run();
               count.incrementAndGet();
               break;
           }
       }

        // printFirst.run() outputs "first". Do not change or remove this line.

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(true){
            if(count.get() % 3 == 1  ){
                printSecond.run();
                count.incrementAndGet();
                break;
            }
        }
        // printSecond.run() outputs "second". Do not change or remove this line.

    }

    public void third(Runnable printThird) throws InterruptedException {
        while(true){
            if(count.get() % 3 == 2  ){
                printThird.run();
                count.incrementAndGet();
                break;
            }
        }
        // printThird.run() outputs "third". Do not change or remove this line.

    }


}
