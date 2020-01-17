package com.skystmm.lintcode.tree;

import com.skystmm.common.TreeNode;

/**
 * @author: skystmm
 * @date: 2020/1/17 14:10
 */
public class InvertBinaryTree {
    /**
     * use traversal time(N) space O(1)
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        traversal(root);
    }

    public void traversal(TreeNode node){
        if(node != null){
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right =tmp;
            traversal(node.left);
            traversal(node.right);
        }
    }
}
