package com.skystmm.leetcode.string;

import com.skystmm.common.TreeNode;

/**
 * 606. Construct String from Binary Tree
 * Created by Administrator on 2018/1/14.
 */

public class Tree2Str {
    /**
     * use recursion
     * AC time:30 ms beats:64.07 %
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        if (t.left == null && t.right == null)
            return t.val + "";
        if (t.right == null)
            return t.val + "(" + tree2str(t.left) + ")";
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }
}