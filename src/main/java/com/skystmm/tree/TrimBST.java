package com.skystmm.tree;

import com.skystmm.common.TreeNode;

/**
 * 669. Trim a Binary Search Tree
 * Created by sky on 2019/1/20
 */
public class TrimBST {
    /**
     * AC recursion time:5 ms
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode solution(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return solution(root.left, L, R);
        if (root.val < L) return solution(root.right, L, R);

        root.left = solution(root.left, L, R);
        root.right = solution(root.right, L, R);
        return root;
    }
}
