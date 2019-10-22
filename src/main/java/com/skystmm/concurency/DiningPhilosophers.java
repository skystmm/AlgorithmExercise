package com.skystmm.concurency;

/**
 * 1226. The Dining Philosophers
 * AC ：10 ms
 * @author: skystmm
 * @date: 2019/10/22 14:51
 */
public class DiningPhilosophers {
    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        synchronized(this){
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
    }
}
}
