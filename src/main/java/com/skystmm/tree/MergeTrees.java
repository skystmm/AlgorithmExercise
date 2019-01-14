package com.skystmm.tree;

import com.skystmm.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 617. Merge Two Binary Trees
 * Created by sky on 2019/1/14
 */
public class MergeTrees {
    /**
     * AC use bsd time :16ms space:O(n)
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode solution(TreeNode t1, TreeNode t2) {
        if(t2 == null){
            return t1;
        }
        if(t1 == null){
            return  t2;
        }
        TreeNode root = new TreeNode(t1.val+t2.val);
        Peer peer = new Peer(t1,t2);
        List<TreeNode> quene = new LinkedList<>();
        quene.add(root);
        List<Peer> peers = new LinkedList();
        peers.add(peer);
        while(peers.size()>0){
            Peer cur = peers.get(0);
            TreeNode curNode = quene.get(0);
            if(cur.t1.left == null){
                curNode.left = cur.t2.left;
            }else if(cur.t2.left == null){
                curNode.left = cur.t1.left;
            }else{
                TreeNode left = new TreeNode(cur.t1.left.val + cur.t2.left.val);
                curNode.left = left;
                quene.add(left);
                peers.add(new Peer(cur.t1.left,cur.t2.left));
            }

            if(cur.t1.right == null){
                curNode.right = cur.t2.right;
            }else if(cur.t2.right == null){
                curNode.right = cur.t1.right;
            }else{
                TreeNode right = new TreeNode(cur.t1.right.val + cur.t2.right.val);
                curNode.right = right;
                quene.add(right);
                peers.add(new Peer(cur.t1.right,cur.t2.right));
            }
            peers.remove(0);
            quene.remove(0);
        }
        return root;
    }

    class Peer{
        TreeNode t1;
        TreeNode t2;

        Peer(TreeNode t1,TreeNode t2){
            this.t1=t1;
            this.t2=t2;
        }
    }

    /**
     * use recursion
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode bestSolution(TreeNode t1, TreeNode t2) {
        if(t1 == null & t2 == null) return null;
        if(t1 == null) return t2;
        if(t2 == null) return t1;

        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = bestSolution(t1.left, t2.left);
        root.right = bestSolution(t1.right, t2.right);

        return root;
    }
}
