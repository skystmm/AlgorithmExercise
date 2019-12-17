package com.skystmm.leetcode.tree;

import com.skystmm.common.NTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal
 * Created by sky on 2019/1/16
 */
public class NaryTreePostorderTraversal {
    /**
     * AC  recursion time:4 ms
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

            for (NTreeNode cur : root.children) {
                traversal(result, cur);
            }
            result.add(root.val);
        }
    }
}
