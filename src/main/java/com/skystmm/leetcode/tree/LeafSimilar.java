package com.skystmm.leetcode.tree;


import com.skystmm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 * Created by sky on 2019/1/19
 */
public class LeafSimilar {
    /**
     * AC O(n) time:3 ms space: O(m) [leaf count m]
     * @param root1
     * @param root2
     * @return
     */
    public boolean solution(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        findLeaf(root1,leaf1);
        findLeaf(root2,leaf2);
        return compareLeaf(leaf1,leaf2);
    }

    private boolean compareLeaf(List<Integer> leaf1, List<Integer> leaf2) {
        if(leaf1.size() != leaf2.size()){
            return  false;
        }
        for(int i =0 ; i<leaf1.size(); i++){
            if(!leaf1.get(i).equals(leaf2.get(i))){
                return  false;
            }
        }
        return  true;
    }

    private void findLeaf(TreeNode node,List<Integer> leafSet){
        if(node != null){
            if(node.left == null && node.right == null){
                leafSet.add(node.val);
            }
            findLeaf(node.left,leafSet);
            findLeaf(node.right,leafSet);
        }
    }
}
