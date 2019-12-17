package com.skystmm.leetcode.array;

/**
 * 661. Image Smoother
 * @author: tian.shen
 * @date: 2018/12/13 15:06
 */
public class ImageSmoother {
    /**
     * AC time : 21ms
     * @param M
     * @return
     */
    public int[][] solution(int[][] M) {
        int [][] result = new int[M.length][];
        int row = M.length;
        int [][] step = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i = 0 ; i< row ; i++){
            int column = M[i].length;
            result[i] = new int[column];
            for(int j =0;j < column ; j++){
                int count = 1;
                int sum = M[i][j];
                for(int[] t : step){
                    int x = t[0] + i;
                    int y = t[1] + j;
                    if(x < 0 || x >= row || y < 0 || y >= column){

                        continue;
                    }
                    sum+=M[x][y];
                    count+=1;
                }
                result[i][j] = sum/count;

            }
        }
        return result;
    }
}
