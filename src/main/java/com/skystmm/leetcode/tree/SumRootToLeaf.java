package com.skystmm.leetcode.tree;

import com.skystmm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 * @author: skystmm
 * @date: 2019/12/25 15:01
 */
public class SumRootToLeaf {

    /**
     * AC time O(n),space O(n)
     * @param root
     * @return
     */
    public int solution(TreeNode root) {
        String suffix = "";
        List<Integer> lists = new ArrayList<>();
        traversal(root,suffix,lists);
        int res = 0;
        for(Integer i:lists){
            res+=i;
        }
        return res;
    }

    private void traversal(TreeNode node, String suffix, List<Integer> lists) {
        suffix += node.val;
        if(node.left == null && node.right == null){
            lists.add(Integer.valueOf(suffix, 2));
            return;
        }
        if(node.left != null){
            traversal(node.left, suffix, lists);
        }
        if(node.right != null){
            traversal(node.right,suffix ,lists );
        }
    }


}
