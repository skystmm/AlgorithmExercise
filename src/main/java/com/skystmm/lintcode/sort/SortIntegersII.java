package com.skystmm.lintcode.sort;

/**
 * 464.Sort Integers II
 * @author: skystmm
 * @date: 2020/1/19 13:43
 */
public class SortIntegersII {

    /**
     *  AC time:O(NlogN) space O(1)
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        quickSort(A,0,A.length-1);
    }

    private void quickSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(arr[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(arr[i]<pivot)) {
                i++;
            }
            if ((arr[i]==arr[j])&&(i<j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i-1>start) quickSort(arr,start,i-1);
        if (j+1<end) quickSort(arr,j+1,end);
    }
}
