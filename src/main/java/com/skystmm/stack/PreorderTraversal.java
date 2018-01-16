package com.skystmm.stack;


import com.skystmm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 * Created by Administrator on 2018/1/16.
 */

public class PreorderTraversal {
    /**
     * use recursion
     * AC time:1 ms beats:19.07 %
     * @param root
     * @return
     */
    public List<Integer> solution(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if(root != null){
                handler(result,root);
            }
            return result;
        }

    private void handler(List<Integer> result, TreeNode root) {
        result.add(root.val);
        if(root.left != null){
            handler(result,root.left);
        }
        if(root.right != null){
            handler(result,root.right);
        }
    }


}
