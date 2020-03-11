package com.skystmm.leetcode.tree;

import com.skystmm.common.TreeNode;

import java.util.ArrayDeque;

/**
 * 111. Minimum Depth of Binary Tree
 *
 * @author: skystmm
 * @date: 2020/3/11 14:17
 */
public class MinimumDepthOfBinaryTree {


    /**
     * use BFS AC time: O(n),space:O(0)
     * @param root
     * @return
     */
    public int solution(TreeNode root) {
        int res = 0;
        if (root != null) {
            ArrayDeque<BFSNode> queue = new ArrayDeque<>();
            queue.addLast(new BFSNode(root, 1));
            while (!queue.isEmpty()) {
                BFSNode cur = queue.pollFirst();
                if (cur.node.left == null && cur.node.right == null) {
                    return cur.level;
                }
                if (cur.node.left != null) {
                    queue.addLast(new BFSNode(cur.node.left, cur.level + 1));
                }
                if (cur.node.right != null) {
                    queue.addLast(new BFSNode(cur.node.right, cur.level + 1));
                }
            }
        }
        return res;
    }

    class BFSNode {
        TreeNode node;
        int level;

        public BFSNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
