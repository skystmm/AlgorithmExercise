package com.skystmm.array;


import java.util.Arrays;

/**
 * 169. Majority Element
 * @author: tian.shen
 * @date: 2018/12/3 11:46
 */
public class MajorityElement {
    /**
     * AC time 6 ms
     * @param nums
     * @return
     */
    public int solution(int[] nums) {
        Arrays.sort(nums);
        int element = nums[0];
        int maxCount = 0;
        int curCount = 1;
        int curElement= nums[0];
        for(int i = 1;i<nums.length;i++){
            if(curElement != nums[i]){
                if(curCount > maxCount){
                    maxCount = curCount;
                    element = curElement;
                }
                curElement = nums[i];
                curCount = 1;
            }else{
                curCount +=1;
                if(curCount > maxCount){
                    maxCount = curCount;
                    element = curElement;
                }
            }
        }
        return element;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().solution(new int[]{3,2,3}));
    }
}
