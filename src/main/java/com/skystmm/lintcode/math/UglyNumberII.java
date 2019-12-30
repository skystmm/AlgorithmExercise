package com.skystmm.lintcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author: skystmm
 * @date: 2019/12/30 13:56
 */
public class UglyNumberII {

    private static final List<Integer> uglyList = new ArrayList<>();

    /**
     * Time Limit Exceeded time O(n),space:O(n)
     * @param n
     * @return
     */
    public int solution(int n) {
        if(uglyList.isEmpty()){
            uglyList.add(1);
        }
        if(uglyList.size() > n){
            return uglyList.get(n-1);
        }
        int last = uglyList.get(uglyList.size()-1) + 1;
        while(uglyList.size() < n){
            boolean flag =checkUgly(last);
            if(flag){
                uglyList.add(last);
            }
            last +=1;
        }
        return uglyList.get(n-1);
    }

    private boolean checkUgly(int i) {
        while(i > 1){
           if(i % 2 == 0){
               i /=2;
           }else if(i%3 == 0){
               i /=3;
           }else if(i%5==0){
               i /=5;
           }else{
               return false;
           }
        }
        return true;
    }


    /**
     * AC time:O(n),space:O(n)
     * @param n
     * @return
     */
    public int buildUglyNumber(int n){
        int [] res = new int[n];
        res[0]=1;
        int a=0,b=0,c=0;
        for(int i =1;i<n;i++){
            res[i] =Math.min(res[a]*2,  Math.min(res[b]*3,res[c]*5 ));
            if(res[i] == res[a]*2){
                a++;
            }
            if(res[i] == res[b]*3){
                b++;
            }
            if(res[i] == res[c]*5){
                c++;
            }
        }
        return res[n-1];
    }

}
