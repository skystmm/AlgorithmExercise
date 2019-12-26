package com.skystmm.leetcode.quene;

import java.util.ArrayDeque;

/**
 * 933. Number of Recent Calls
 * AC time: O(N),space O()
 * @author: skystmm
 * @date: 2019/12/26 14:06
 */
public class RecentCounter {

    ArrayDeque<Integer> list = new ArrayDeque<>();
    public RecentCounter() {

    }

    public int ping(int t) {
        list.addLast(t);
        for(Integer i : list){
            if(t-3000 > i){
                list.pollFirst();
            }
        }
        return list.size();
    }

}
