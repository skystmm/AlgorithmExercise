package com.skystmm.leetcode.array;

/**
 * 867. Transpose Matrix
 * Created by sky on 2018/11/23
 */
public class TransposeMatrix {
    /**
     * AC:2ms beats:100%
     * @param A
     * @return
     */
    public int[][] solution(int[][] A) {
        int  col = A.length;
        int row  = A[0].length;
        int[][] target = new int[row][col];
        for(int i =0;i < col;i++){
            for(int j =0;j< row ; j++){
                target[j][i] = A[i][j];
            }
        }
        return target;
    }
}
