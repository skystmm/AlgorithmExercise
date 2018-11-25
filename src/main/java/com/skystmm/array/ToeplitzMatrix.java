package com.skystmm.array;

/**
 * 766. Toeplitz Matrix
 * Created by sky on 2018/11/25
 */
public class ToeplitzMatrix {
    /**
     * time :O(n*m) space O(1)
     * AC time :11 ms beats: 99.04 %
     * @param matrix
     * @return
     */
    public boolean solution(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        for(int i = 0 ;i< column; i++){
            int cur = matrix[0][i];
            int curIndex = 1;
            for(int j = i+1; j<column && curIndex <row; j++,curIndex++){
                if(cur != matrix[curIndex][j]){
                    return false;
                }
            }
        }
        for(int i = 1;i<row;i++){
            int cur = matrix[i][0];
            int curIndex = 1;
            for(int j = i+1; curIndex<column && j <row; j++,curIndex++){
                if(cur != matrix[j][curIndex]){
                    return false;
                }
            }
        }
        return true;
    }


}
