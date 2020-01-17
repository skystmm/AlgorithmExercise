package com.skystmm.lintcode.tree;

import com.skystmm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 66. Binary Tree Preorder Traversal
 * @author: skystmm
 * @date: 2020/1/17 14:15
 */
public class BinaryTreePreorderTraversal {


    /**
     * AC time:O(n) space O(n)
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return  result;
    }


    public void traversal(TreeNode node,List<Integer> result){
        if(node != null){
            result.add(node.val);
            traversal(node.left,result );
            traversal(node.right,result );
        }
    }
}
