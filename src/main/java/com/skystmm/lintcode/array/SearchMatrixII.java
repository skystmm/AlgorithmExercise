package com.skystmm.lintcode.array;

/**
 * 38. Search a 2D Matrix II
 * @author: skystmm
 * @date: 2020/1/15 15:10
 */
public class SearchMatrixII {


    /**
     * Solution 1 exhaustion O(M*N)
     * AC time:O(M*N) space O(1)
     * @param matrix
     * @param target
     * @return
     */
    public int solution(int[][] matrix, int target) {
        // write your code here
        int res = 0;
        int curLength = matrix[0].length;
        for(int i =0;i<matrix.length;i++){

            for(int j =0;j<curLength;j++){
                if(matrix[i][j] >= target){
                    if(matrix[i][j] == target){
                        res++;
                    }
                    curLength = j;
                    break;
                }
            }
        }
        return  res;
    }
}
