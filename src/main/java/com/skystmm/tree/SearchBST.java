package com.skystmm.tree;

import com.skystmm.common.TreeNode;

/**
 * 700. Search in a Binary Search Tree
 * @author: skystmm
 * @date: 2019/1/8 22:46
 */
public class SearchBST {
    /**
     * AC O(logn) time :3ms space O(1)
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        while(node != null){
            if(node.val == val){
                return node;
            }
            if(val > node.val){
                node = node.right;
            }else {
                node = node.left;
            }

        }
        return null;
    }
}
