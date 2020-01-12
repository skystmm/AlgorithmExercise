package com.skystmm.lintcode.array;

import com.skystmm.common.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * 30. Insert Interval
 * @author: skystmm
 * @date: 2020/1/11
 */
public class InsertInterval {
    /**
     * AC time:O(n) space:O(n)
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> solution(List<Interval> intervals, Interval newInterval) {
        // write your code here
        List<Interval> res = new ArrayList<>();
        boolean flag = false;
        for(Interval interval : intervals){
            if(interval.start > newInterval.end){
                if (!flag){
                    res.add(newInterval);
                    flag = true;
                }
                res.add(interval);
            }
            if(interval.end < newInterval.start  ){
                res.add(interval);
            }
            if(interval.start < newInterval.start && interval.end >= newInterval.start){
                newInterval.start = interval.start;
            }
            if(interval.start <= newInterval.end && interval.end > newInterval.end){
                newInterval.end = interval.end;
                res.add(newInterval);
                flag = true;
            }
        }
        if(!flag){
            res.add(newInterval);
        }
        return  res;
    }
}
