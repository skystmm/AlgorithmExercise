package com.skystmm.lintcode.tree;

import com.skystmm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 11.Search Range in Binary Search Tree
 * @author: skystmm
 * @date: 2020/1/2 15:24
 */
public class SearchRangeInBinarySearchTree {

    /**O(N)
     * AC time:O(logN),space:
     * @param root
     * @param k1
     * @param k2
     * @return
     */
    public List<Integer> solution(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        traversal(root, k1, k2, res);
        return res;
    }

    private void traversal(TreeNode node,int k1,int k2,List<Integer> res){
        if(node  != null){
            if(node.val > k1){
                traversal(node.left, k1,k2 , res);
            }
            if(node.val >= k1 && node.val <= k2){
                res.add(node.val);
            }
            if(node.val < k2){
                traversal(node.right, k1,k2 , res);
            }
        }
    }
}
