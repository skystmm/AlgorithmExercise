package com.skystmm.common;

import java.util.List;

/**
 * Created by sky on 2019/1/16
 */
public class NTreeNode {

    public int val;
    public List<NTreeNode> children;

    public NTreeNode() {
    }

    public NTreeNode(int _val, List<NTreeNode> _children) {
        val = _val;
        children = _children;

    }
}
