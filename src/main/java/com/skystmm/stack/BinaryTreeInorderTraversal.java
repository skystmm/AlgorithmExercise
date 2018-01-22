package com.skystmm.stack;

import com.skystmm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 * Created by Administrator on 2018/1/22.
 */

public class BinaryTreeInorderTraversal {
    /**
     * use recursive
     * AC times:1 ms ,beats:22.44%
     * @param root
     * @return
     */
    public List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorderTraversal(res,root);
        return res;
    }

    public void inorderTraversal(List<Integer> lists ,TreeNode now){
        if(now != null){
            inorderTraversal(lists,now.left);
            lists.add(now.val);
            inorderTraversal(lists,now.right);
        }
    }
}
