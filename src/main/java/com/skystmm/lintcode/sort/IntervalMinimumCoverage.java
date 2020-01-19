package com.skystmm.lintcode.sort;

import com.skystmm.common.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1668.Interval Minimum Coverage
 * @author: skystmm
 * @date: 2020/1/19 15:51
 */
public class IntervalMinimumCoverage {
    /**
     * @param a: the array a
     * @return: return the minimal points number
     */
    public int getAns(List<Interval> a) {
        // write your code here
        if(a.size() == 0){
            return 0;
        }
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start - o2.start != 0) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        };
        Collections.sort(a, comparator);
        Interval cur =null;
        int res = 1;
        for(Interval i : a){
            if(cur == null){
                cur = i;
            }else{
                if(cur.start > i.end || i.start > cur.end){
                    res++;
                    cur = i;
                }else{
                    cur.start = Math.min(cur.start, i.start );
                    cur.end = Math.min(cur.end,i.end );
                }
            }
        }
        return res;
    }


}
