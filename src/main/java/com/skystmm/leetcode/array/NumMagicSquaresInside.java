package com.skystmm.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 840. Magic Squares In Grid
 *
 * @author: skystmm
 * @date: 2019/2/1 15:33
 */
public class NumMagicSquaresInside {
    /**
     * AC  O(N^2)time : 5 ms, space O(1)
     * @param grid
     * @return
     */
    public int solution(int[][] grid) {
        int count = 0;
        int row = grid.length;
        if (row < 3) {
            return count;
        }
        int column = grid[0].length;
        if (column < 3) {
            return 0;
        }
        for (int i = 0; i <= row - 3; i++) {
            for (int j = 0; j <= column - 3; j++) {
                if(isMagic(grid,i,j)){
                    count ++;
                }
            }
        }
        return count;

    }

    private boolean isMagic(int[][] grid, int i, int j) {
        Set<Integer> tmp = new HashSet<>();
        for(int t = i;t<i+3;t++){
            for(int k=j;k<j+3;k++){
                if(grid[t][k]> 9 || grid[t][k] <1 || !tmp.add(grid[t][k])){
                    return  false;
                }
            }
        }
        int row1 = grid[i][j] + grid[i][j+1] + grid[i][j+2];
        int row2 = grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2];
        if(row1 != row2){
            return  false;
        }
        int row3 = grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
        if(row2 != row3){
            return  false;
        }
        int column1 = grid[i][j]+ grid[i+1][j] + grid[i+2][j] ;
        int column2 = grid[i][j+1]+ grid[i+1][j+1] + grid[i+2][j+1] ;
        if(column1 != column2){
            return  false;
        }
        int column3 = grid[i][j+2]+ grid[i+1][j+2] + grid[i+2][j+2] ;
        if(column3 != column2){
            return  false;
        }
        int cross1 = grid[i][j] + grid[i+1][j+1]+ grid[i+2][j+2];
        int cross2 = grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j];
        if(cross1 != cross2){
            return  false;
        }
        return true;
    }
}
