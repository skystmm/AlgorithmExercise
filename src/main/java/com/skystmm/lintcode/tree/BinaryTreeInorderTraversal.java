package com.skystmm.lintcode.tree;

import com.skystmm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 67. Binary Tree Inorder Traversal
 * @author: skystmm
 * @date: 2020/1/17 14:19
 */
public class BinaryTreeInorderTraversal {


    /**
     * use traversal time O(n) space O(n)
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return  result;
    }




    public void traversal(TreeNode node, List<Integer> result){
        if(node != null){
            traversal(node.left,result );
            result.add(node.val);
            traversal(node.right,result );
        }
    }
}
