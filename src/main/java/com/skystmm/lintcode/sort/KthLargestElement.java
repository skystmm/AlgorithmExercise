package com.skystmm.lintcode.sort;



/**
 * 5. Kth Largest Element
 * @author: skystmm
 * @date: 2019/12/30 15:35
 */
public class KthLargestElement {
    /**
     * heap solution AC time :O(nlog(k)) space:O(n)
     * @param n
     * @param nums
     * @return
     */
    public int solution(int n, int[] nums) {
        // write your code here
        if(n > nums.length){
            return  -1;
        }
        int[] heap = new int[n];
        for(int i=0;i<n;i++){
            heap[i] = Integer.MIN_VALUE;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] > heap[0]){
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
               if(index2 + 1 < heap.length && heap[index2] > heap[index2 +1]){
                   index2 ++;
               }
               if(heap[index] > heap[index2]){
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

//    public int solution2(int n, int[] nums){
//        if(n > nums.length){
//            return  -1;
//        }
//        quickSort(nums, 0, nums.length-1, nums.length-n);
//        return nums[nums.length-n];
//    }
//
//    private void quickSort(int[] nums,int start,int end,int n){
//        if(start == end) return;
//        int left = start;
//        int right = end;
//        int tmp = nums[start + end / 2];
//        while(left<right){
//            while(nums[right] > tmp && right > left){
//                right--;
//            }
//            while(nums[left] < tmp && right > left){
//                left++;
//            }
//            if(left < right){
//                int t = nums[left];
//                nums[left] = nums[right];
//                nums[right] = t;
//                left++;
//                right--;
//            }
//        }
//        if(right<n){
//            quickSort(nums, right, end,n);
//        }
//        if(left>n){
//            quickSort(nums, start, left, n);
//        }
//    }


}
