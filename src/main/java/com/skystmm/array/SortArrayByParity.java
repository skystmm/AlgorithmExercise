package com.skystmm.array;

/**
 * 905. Sort Array By Parity
 * Created by sky on 2018/11/22
 */
public class SortArrayByParity {
    /**
     * AC: 9ms beats:99.95%
     * @param A
     * @return
     */
    public int[] solution(int[] A) {
        if(A.length < 2){
            return  A;
        }
        int i = 0 ;
        int j = A.length -1;
        boolean odd = false;
        boolean even = false;
        while(i<j){
            if(A[i] % 2 == 0){
                i++;
            }else{
                even = true;
            }
            if(A[j] %2 != 0){
                j--;
            }else{
                odd = true;
            }
            if(odd && even){
                int tmp =A[i];
                A[i] = A[j];
                A[j] =tmp;
                odd = false;
                even = false;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        SortArrayByParity s = new SortArrayByParity();
        s.solution(new int[]{3,1,2,4});
    }
}
