package com.skystmm.tree;

import com.skystmm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 897. Increasing Order Search Tree
 * Created by sky on 2019/1/19
 */
public class IncreasingBST {
    /**
     * AC  O(n) time:52 ms space O(n)
     * @param root
     * @return
     */
    public TreeNode solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        buildIncreasingBST(root,result);
        return result.size()>0 ? buildResult(result):null;
    }

    private TreeNode buildResult(List<Integer> result) {
        TreeNode treeNode = new TreeNode(result.get(0));
        TreeNode cur = treeNode;
        for(int i =1;i<result.size();i++ ){
            TreeNode tmp = new TreeNode(result.get(i));
            cur.right = tmp;
            cur = tmp;
        }
        return  treeNode;
    }

    private void buildIncreasingBST(TreeNode node,List<Integer> result){
        if(node != null){
            buildIncreasingBST(node.left,result);
            result.add(node.val);
            buildIncreasingBST(node.right,result);
        }
    }

    TreeNode newRoot = null;
    TreeNode newRootTail = null;

    /**
     * best solution
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return newRoot;

        increasingBST(root.left);
        if(newRoot == null){
            newRoot = new TreeNode(root.val);
            newRootTail = newRoot;
        } else {
            newRootTail.right = new TreeNode(root.val);
            newRootTail = newRootTail.right;
        }
        increasingBST(root.right);

        return newRoot;
    }
}
