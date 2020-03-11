package com.skystmm.lintcode.array;

/**
 * 63. Search in Rotated Sorted Array II
 * @author: skystmm
 * @date: 2020/2/3
 */
public class SearchInRotatedSortedArrayII {

    /**
     * AC time O(logN) space O(1)
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean
     */
    public boolean search(int[] A, int target) {
        // write your code here

        int start = 0;
        int end = A.length-1;

        while(start<= end) {
            int mid = (start + end) >> 1;
            if (target == A[mid]) {
                return true;
            }
            if(A[mid] == A[start] && A[mid] == A[end]){
                start++;
                end--;
                continue;
            }
            if(A[mid] >  A[end]){
                if(target > A[end]){
                    start = mid +1;
                }else{
                    if(target > A[mid]){
                        end = mid -1;
                    }else {
                        start = mid +1;
                    }

                }
            }else{
                if(target < A[mid]){
                    end = mid -1;
                }else{
                    if(target > A[mid]){
                        start = mid + 1;
                    }else {
                        end = mid - 1;
                    }
                }
            }
        }
        return  false;
    }


    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArrayII().search(new int[]{0,1,-9,-9,-9,-9,-7,-6,-5,-4,-3,-2,-1},
        -9));
    }
}
