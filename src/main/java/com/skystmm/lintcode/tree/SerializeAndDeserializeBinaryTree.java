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





    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(8);
        TreeNode a9 = new TreeNode(9);
        TreeNode a10 = new TreeNode(10);
        TreeNode a11 = new TreeNode(11);
        TreeNode a12 = new TreeNode(12);
        TreeNode a13 = new TreeNode(13);
        TreeNode a14 = new TreeNode(14);
        a1.left=a2;
        a1.right=a3;
        a2.left = a11;

        a3.left = a4;
        a3.right = a5;

        a4.left = a6;
        a4.right = a7;

        a5.right = a10;

        a7.left = a8;
        a7.right = a9;

        a8.left = a12;
        a8.right =a13;

        a13.right = a14;


        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        String s = serializeAndDeserializeBinaryTree.serialize(a1);
        System.out.println(s);
        System.out.println(serializeAndDeserializeBinaryTree.deserialize(s));

    }
}
