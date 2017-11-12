package com.skystmm.array;

/**
 * Created by Administrator on 2017/11/12.
 */

public class CanPlaceFlowers {
    /**
     * AC time:12ms beats:56.02%
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean solution(int[] flowerbed, int n) {
        if(n == 0){
            return true;
        }
        int length = flowerbed.length;

        if(length < n * 2 - 1){
            return false;
        }
        if(length == 2){
            if(flowerbed[0] ==1 ||flowerbed[1] == 1){
                return false;
            }else{
                return true;
            }
        }

        int i =0 ;
        while(i<length){
            if(flowerbed[i] == 1) {
                i += 2;
            }else{
                if(i < length -1){
                    if(flowerbed[i+1] ==  0){
                        n -= 1;
                        if( n == 0){
                            return true;
                        }
                        i += 2;
                    }else{
                        i += 3;
                    }
                }else if(i == length -1){
                    n -= 1;
                    if( n == 0){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }
        return n == 0 ? true: false;
    }

    /**
     * leetcode 最优解代码（思路一致）
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean solutionBest(int[] flowerbed, int n) {
        for (int i = 0; n > 0 && i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n == 0;
    }
    public static void main(String[] args) {
        CanPlaceFlowers.solution(new int[]{0,0,1,0,0}, 1);
    }
}
