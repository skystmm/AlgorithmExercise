package com.skystmm.lintcode.array;

/**
 * 28. Search a 2D Matrix
 * @author: skystmm
 * @date: 2020/1/6 22:11
 */
public class SearchMatrix {

    /**
     * AC time:O(log(N) + log(M)) space O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int r = matrix.length;
        if(r > 0){
            int c = matrix[0].length;
            int rStart = 0;
            int rEnd = r-1;
            int row = -1;
            while(rStart <= rEnd){
                int rMid = (rStart + rEnd) /2 ;
                if(matrix[rMid][0] == target || matrix[rMid][c-1] == target){
                    return  true;
                }
                if(matrix[rMid][0] < target && matrix[rMid][c-1] > target){
                    row = rMid;
                    break;
                }
                if(matrix[rMid][0] > target){
                    rEnd = rMid - 1;
                }
                if(matrix[rMid][c-1] < target){
                    rStart = rMid  +1;
                }
            }

            if(row > -1){
                int cStart = 0;
                int cEnd = c-1;
                while(cStart <= cEnd){
                    int cMid = (cStart + cEnd) /2 ;
                    if(matrix[row][cMid] == target){
                        return  true;
                    }
                    if(matrix[row][cMid] > target){
                        cEnd = cMid - 1;
                    }
                    if(matrix[row][cMid] < target){
                        cStart = cMid +1  ;
                    }
                }
            }
        }

        return false;
    }

}
