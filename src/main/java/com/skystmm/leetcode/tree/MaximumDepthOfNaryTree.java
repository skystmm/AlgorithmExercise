package com.skystmm.leetcode.tree;

import com.skystmm.common.NTreeNode;

/**
 * 559. Maximum Depth of N-ary Tree
 * Created by sky on 2019/1/16
 */
public class MaximumDepthOfNaryTree {
    /**
     * AC  recursion time : 4 ms
     * @param root
     * @return
     */
    public int solution(NTreeNode root) {
        return traversal(root,0);
    }

    private int traversal(NTreeNode root,int curDep) {
        if(root != null) {
            curDep += 1;
            int maxDeep = curDep;
            for (NTreeNode cur : root.children) {
                int tmp = traversal(cur,curDep);
                if(tmp > maxDeep){
                    maxDeep = tmp;
                }
            }
            return maxDeep;
        }
        return  curDep;
    }
}
