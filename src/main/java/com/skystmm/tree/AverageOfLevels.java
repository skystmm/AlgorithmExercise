package com.skystmm.tree;

import com.skystmm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 637. Average of Levels in Binary Tree
 * @author: skystmm
 * @date: 2019/1/22 22:31
 */
public class AverageOfLevels {
    /**
     * AC recursion time:4ms
     * @param root
     * @return
     */
    public List<Double> solution(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        avgOfLevel(nodes,result);
        return  result;
    }

    private void avgOfLevel(List<TreeNode> nodes, List<Double> result) {
        List<TreeNode> nextLevel = new ArrayList<>() ;
        double curValue = 0.0;
        for(TreeNode node : nodes){
            curValue +=node.val;
            if(node.left != null) nextLevel.add(node.left);
            if(node.right != null)nextLevel.add(node.right);
        }
        result.add(curValue/nodes.size());
        if(nextLevel.size() > 0){
            avgOfLevel(nextLevel,result);
        }
    }


}
