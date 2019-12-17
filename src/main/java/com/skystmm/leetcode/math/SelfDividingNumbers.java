package com.skystmm.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: skystmm
 * @date: 2019/10/23 16:00
 */
public class SelfDividingNumbers {

    /**
     * AC time : O(n*m) space :O(1)
     * @param left
     * @param right
     * @return
     */
    public List<Integer> solution(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i = left;i<=right ;i++){
            if(i>0 && i < 10){
                result.add(i);
                continue;
            }
            boolean flag = true;
            int tmp = i ;
            while( tmp  > 0 ){
                int j = tmp % 10;
                tmp /= 10;
                if( j == 0){
                    flag = false;
                    break;
                }else{
                    flag = (i % j ==0);
                    if(!flag)break;
                }
            }
            if(flag){
                result.add(i);
            }
        }
        return result;
    }


}
