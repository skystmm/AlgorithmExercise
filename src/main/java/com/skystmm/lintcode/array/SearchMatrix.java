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


    public static void main(String[] args) {
        System.out.println(new SearchMatrix().searchMatrix(new int[][]
                {{1,8,11,15,18,19,24,31,36,40,42,47,51,52,57,58,61,65,67},{84,108,130,145,166,177,202,217,233,253,265,284,300,313,324,348,367,391,401},{422,442,453,476,496,516,532,544,567,588,611,625,641,653,673,695,705,727,748},{764,778,795,805,823,841,857,876,890,907,932,954,974,992,1005,1019,1034,1053,1078},{1100,1117,1129,1144,1160,1178,1203,1220,1233,1244,1256,1268,1290,1310,1322,1339,1351,1367,1391},{1413,1429,1444,1456,1467,1484,1509,1521,1539,1549,1561,1586,1602,1621,1639,1664,1681,1706,1722}},1224));
    }
}
