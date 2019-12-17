package com.skystmm.leetcode.tree;

import com.skystmm.common.NTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N-ary Tree Preorder Traversal
 * Created by sky on 2019/1/16
 */
public class NaryTreePreorderTraversal {
    /**
     * AC  recursion time:5 ms
     * @param root
     * @return
     */
    public List<Integer> solution(NTreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(result,root);
        return  result;
    }

    private void traversal(List<Integer> result, NTreeNode root) {
        if(root != null) {
            result.add(root.val);
            for (NTreeNode cur : root.children) {
                traversal(result, cur);
            }
        }
    }
}
