package com.skystmm.tree;

import com.skystmm.common.NTreeNode;


import java.util.ArrayList;

import java.util.List;

/**
 * 429. N-ary Tree Level Order Traversal
 * Created by sky on 2019/1/20
 */
public class NaryTreeLevelOrderTraversal {
    /**
     * AC recursion time : 6ms
     * @param root
     * @return
     */
    public List<List<Integer>> solution(NTreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<NTreeNode> curLevel = new ArrayList<>();
        curLevel.add(root);
        levelTraversal(curLevel,result);
        return  result;
    }

    private void levelTraversal(List<NTreeNode> curLevel, List<List<Integer>> result) {
        if(curLevel != null && curLevel.size() > 0){
            List<Integer> curValues = new ArrayList<>();
            List<NTreeNode> nextLevel = new ArrayList<>();
            for(NTreeNode node : curLevel){
                if(node != null){
                    curValues.add(node.val);
                    nextLevel.addAll(node.children);
                }
            }
            result.add(curValues);
            levelTraversal(nextLevel,result);
        }

    }

    /**
     * best solve
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(NTreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    public void dfs(NTreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (level == res.size()) res.add(new ArrayList<Integer>());
        res.get(level).add(root.val);
        for (NTreeNode n: root.children) {
            dfs(n, res, level + 1);
        }
    }
}
