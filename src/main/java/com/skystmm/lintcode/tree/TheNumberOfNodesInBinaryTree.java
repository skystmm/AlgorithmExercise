package com.skystmm.lintcode.tree;

import com.skystmm.common.TreeNode;

/**
 * 1759. The Number Of Nodes In Binary Tree
 * @author: skystmm
 * @date: 2020/1/17 14:49
 */
public class TheNumberOfNodesInBinaryTree {

    /**
     * use traversal time:O(n) space: O(1)
     * @param root
     * @return
     */
    public int getAns(TreeNode root) {
        // Write your code here
        int res = traversal(root);
        return res;
    }


    private int traversal(TreeNode node){
        if(node != null){
            int res = 1;
            res += traversal(node.left);
            res += traversal(node.right);
            return  res;
        }
        return  0;

    }
}
