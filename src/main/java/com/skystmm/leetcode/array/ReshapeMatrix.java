package com.skystmm.leetcode.array;


/**
 * 566. Reshape the Matrix
 * Created by Administrator on 2017/10/31.
 */
public class ReshapeMatrix {
    /**
     * time O(m*n) space: O(n*m)
     *  AC  time :4ms,beats:95.09%
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] solution(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        if( r*c != row*column){
            return  nums;
        }
        int[][] res = new int[r][c];
        int rIndex= 0;
        int cIndex = 0;
        for(int i =0 ; i<row;i++){
            for(int j = 0;j< column; j++){
                res[rIndex][cIndex] = nums[i][j];
                cIndex++;
                if(cIndex == c){
                    cIndex = 0;
                    rIndex++;
                }
            }
        }
        return res;
    }

}
