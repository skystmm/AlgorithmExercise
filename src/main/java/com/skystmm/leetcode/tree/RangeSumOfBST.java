package com.skystmm.leetcode.tree;

import com.skystmm.common.TreeNode;

/**
 * 938. Range Sum of BST
 * @author: skystmm
 * @date: 2019/8/8
 */
public class RangeSumOfBST {
    /**
     * use traversal
     * AC :0 ms
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {

        return traversal(root,L,R);
    }

    private int traversal(TreeNode cur,int L,int R){
        if(cur == null){
            return  0 ;
        }
        if(cur.val >= L && cur.val <= R){
            return  cur.val +traversal(cur.left,L,R) + traversal(cur.right,L,R);
        }
        if(cur.val < L){
            return   traversal(cur.right,L,R);
        }
        if(cur.val > R){
            return  traversal(cur.left,L,R);
        }
        return 0;
    }
}
