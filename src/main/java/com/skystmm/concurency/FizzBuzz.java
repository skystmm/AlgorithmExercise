package com.skystmm.concurency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * 1195. Fizz Buzz Multithreaded
 * without lock use volatile AC 4ms
 * @author: skystmm
 * @date: 2019/10/22 10:29
 */
public class FizzBuzz {

    private int n;

    private AtomicInteger cur = new AtomicInteger(1);

    private volatile boolean numFlag = true;

    private volatile boolean fizzFlag = false;

    private volatile boolean buzzFlag = false;

    private volatile boolean fizzbuzzFlag = false;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(cur.get() <= n){
            if(fizzFlag){
                if(cur.get() <= n) {
                    printFizz.run();
                    cur.incrementAndGet();
                    fizzFlag = false;
                    numFlag = true;
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(cur.get() <= n){
            if(buzzFlag){
                if(cur.get() <= n) {
                    printBuzz.run();
                    cur.incrementAndGet();
                    buzzFlag = false;
                    numFlag = true;
                }
            }
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(cur.get() <= n){
            if(fizzbuzzFlag){
                if(cur.get() <= n) {
                    printFizzBuzz.run();
                    cur.incrementAndGet();
                    fizzbuzzFlag = false;
                    numFlag = true;
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(cur.get() <= n){
            if(numFlag){
                Integer tmp = cur.get();
                if(tmp % 3 == 0 && tmp% 5 == 0){
                    fizzbuzzFlag = true;
                    numFlag = false;
                }
                else if(tmp % 3 == 0 && tmp% 5 != 0){
                    fizzFlag = true;
                    numFlag = false;
                }
                else if(tmp % 3 != 0 && tmp% 5 == 0){
                    buzzFlag = true;
                    numFlag = false;
                } else {
                    if(cur.get() <= n){
                        printNumber.accept(cur.get());
                        cur.incrementAndGet();
                    }
                }
            }
        }
    }

}
