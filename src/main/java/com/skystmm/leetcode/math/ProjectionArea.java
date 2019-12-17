package com.skystmm.leetcode.math;

/**
 * 883. Projection Area of 3D Shapes
 *
 * @author: skystmm
 * @date: 2019/10/28 15:35
 */
public class ProjectionArea {

    /**
     * AC time:O(n*n),space:
     * @param grid
     * @return
     */
    public int solution(int[][] grid) {
        int result = grid.length * grid.length;
        int[] rowMax = new int[grid.length];
        int[] columnMax =new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0;j< grid[i].length; j++){
                if(grid[i][j] == 0){
                    result --;
                }
                if(grid[i][j] > rowMax[i]){
                    rowMax[i] = grid[i][j];
                }
                if(grid[i][j] > columnMax[j]){
                    columnMax[j] = grid[i][j];
                }
            }
        }
        for(int x :rowMax){
            result +=x;
        }
        for(int x:columnMax){
            result +=x;
        }
        return  result;
    }


}
