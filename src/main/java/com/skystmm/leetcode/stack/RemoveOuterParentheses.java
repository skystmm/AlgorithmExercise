package com.skystmm.leetcode.stack;


/**
 * 1021. Remove Outermost Parentheses
 * @author: skystmm
 * @date: 2019/12/26 10:42
 */
public class RemoveOuterParentheses {
    /**
     * AC time:O(n),space:O(1)
     * @param S
     * @return
     */
    public String solution(String S) {
        StringBuilder res =new StringBuilder();
        int count = 0;
        int stratIndex = -1;
        for(int i =0;i<S.length();i++){
            if(S.charAt(i) == '('){
                count++;
                if(count ==2 && stratIndex <0){
                    stratIndex =i;
                }

            }else{
                count --;
                if(count == 0 && stratIndex >0){
                    res.append(S.substring(stratIndex,i));
                    stratIndex = -1;
                }
            }

        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveOuterParentheses().solution("((()(())))(())"));
    }
}

