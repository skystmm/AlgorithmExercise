package com.skystmm.lintcode.sort;

/**
 * @author: skystmm
 * @date: 2020/1/19 10:14
 */
public class KthSmallest {

    /**
     * AC time:O(logk) space O(k)
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        if(k > nums.length){
            return  -1;
        }
        int[] heap = new int[k];
        for(int i=0;i<k;i++){
            heap[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] < heap[0]){
                heapSort(heap, nums[i]);
            }
        }
        return heap[0];
    }


    private void heapSort(int[] heap,int value){
        heap[0] = value;
        int index = 0;
        while(index < heap.length){
            int index2 = index * 2 + 1;
            if(index2 < heap.length){
                if(index2 + 1 < heap.length && heap[index2] < heap[index2 +1]){
                    index2 ++;
                }
                if(heap[index] < heap[index2]){
                    int tmp = heap[index];
                    heap[index] = heap[index2];
                    heap[index2] = tmp;
                    index = index2;
                }else {
                    break;
                }
            }else {
                break;
            }
        }
    }
}
