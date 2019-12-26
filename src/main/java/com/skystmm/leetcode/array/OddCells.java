package com.skystmm.leetcode.array;

/**
 * 1252. Cells with Odd Values in a Matrix
 * @author: skystmm
 * @date: 2019/12/26 11:48
 */
public class OddCells {
    /**
     * solution 1 : 暴力 time :  O(n*m) space O(n*m)
     * @param n
     * @param m
     * @param indices
     * @return
     */
    public int solution(int n, int m, int[][] indices) {
        int res = 0;
        int[][] matrix = new int[n][m];
        for(int i = 0; i < indices.length;i++){
            int row = indices[i][0];
            int column = indices[i][1];
            for(int j =0;j<m;j++){
                matrix[row][j]++;
            }
            for(int k=0;k<n;k++){
                matrix[k][column]++;
            }
        }
        for(int i = 0 ;i<n;i++){
            for(int j =0;j<m;j++){
                res += (matrix[i][j] %2);
            }
        }
        return  res;
    }
}
