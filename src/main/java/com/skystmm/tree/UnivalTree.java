package com.skystmm.tree;

import com.skystmm.common.TreeNode;

/**
 * 965. Univalued Binary Tree
 * Created by sky on 2019/1/7
 */
public class UnivalTree {
    /**
     * AC O(n) time 5ms space: O(1)
     * @param root
     * @return
     */
    public boolean solution(TreeNode root) {
        int base = root.val;
        return traversal(root,base);
    }

    public boolean traversal(TreeNode node ,int base){
        if(node == null){
            return  true;
        }
        if(base != node.val){
            return false;
        }
        return traversal(node.left,base) && traversal(node.right,base);
    }
}
