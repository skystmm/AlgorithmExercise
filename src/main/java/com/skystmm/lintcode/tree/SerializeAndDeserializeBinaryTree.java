package com.skystmm.lintcode.tree;

import com.skystmm.common.TreeNode;

import java.util.Stack;

/**
 * 7.Serialize and Deserialize Binary Tree
 * AC serialize time:O(n) space:O(n) （LRM traversal）
 *    deserialize tmie:O(n) space:O(n)
 * @author: skystmm
 * @date: 2019/12/30 19:02
 */
public class SerializeAndDeserializeBinaryTree {


    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        // write your code here
        return  traversal(root);
    }

    private String traversal(TreeNode node) {
        String left ="";
        String right="";
        if(node.left != null){
           left = traversal(node.left);
        }
        if(node.right != null){
            right = traversal(node.right);
        }
        StringBuilder res = new StringBuilder();
        res.append(node.val);
        if(left!= null && left.length()>0 && right!= null &&right.length() > 0 ){
            res.append("{").append(left).append(",").append(right).append("}");
        }else if(left!= null && left.length()>0 && (right== null || right.length() == 0 )){
            res.append("{").append(left).append(",").append("}");
        } else if((left == null || left.length()>0) && right!= null || right.length() > 0 ){
            res.append("{").append(",").append(right).append("}");
        }

        return res.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data.length() == 0){
            return  null;
        }
        boolean left = true;
        Stack<TreeNode> nodeStack = new Stack<>();
        StringBuilder tmpValue = new StringBuilder();
        TreeNode root = null;
        for(Character c : data.toCharArray()){
            if(c != '{' && c != '}' && c != ','){
                tmpValue.append(c);
            }else{
                if(c == '{'){
                    if(root == null){
                        root= new TreeNode(Integer.parseInt(tmpValue.toString()));
                        nodeStack.push(root);
                    }else{
                        if(tmpValue.length() > 0) {
                            TreeNode cur = new TreeNode(Integer.parseInt(tmpValue.toString()));
                            if(left){
                                nodeStack.peek().left = cur;
                            }else{
                                nodeStack.peek().right = cur;
                            }

                            nodeStack.push(cur);
                            left = true;
                        }
                    }
                    tmpValue = new StringBuilder();
                }
                if(c == ','){
                    if(tmpValue.length() > 0){
                        TreeNode cur = new TreeNode(Integer.parseInt(tmpValue.toString()));
                        nodeStack.peek().left = cur;
                        tmpValue = new StringBuilder();
                    }
                    left = false;
                }
                if(c == '}'){
                    if(tmpValue.length() > 0){
                        TreeNode cur = new TreeNode(Integer.parseInt(tmpValue.toString()));
                        nodeStack.peek().right = cur;
                        tmpValue = new StringBuilder();
                    }
                    left = true;
                    nodeStack.pop();
                }
            }

        }

        return  root;
    }

}
