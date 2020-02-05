package com.skystmm.lintcode.array;

/**
 * 42.Search in Rotated Sorted Array
 * @author: skystmm
 * @date: 2020/2/5
 */
public class SearchInRotatedSortedArray {
    /**
     * AC time :O(logN) space O(1)
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        int start = 0;
        int end = A.length-1;

        while(start< end){
            int mid = (start + end) >> 1;
            if(target== A[mid]){
                return  mid;
            }
            if (A[start] <= A[mid]) {
                if (A[start] <= target && target < A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;

    }
}
