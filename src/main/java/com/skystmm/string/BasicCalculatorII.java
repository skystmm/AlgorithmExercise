package com.skystmm.string;



import java.util.*;

/**
 * 227. Basic Calculator II
 * @author: skystmm
 * @date: 2019/8/9
 */
public class BasicCalculatorII {

    private static Set<Character> operator = new HashSet<>();
    static{
        operator.add('+');
        operator.add('-');
        operator.add('*');
        operator.add('/');
    }
    /**
     * AC :26 ms
     * @param s
     * @return
     */
    public int solution(String s) {
        ArrayDeque<Integer> valQuene = new ArrayDeque<>() ;
        ArrayDeque<String> opQuene = new ArrayDeque<>();
        StringBuilder tmp = new StringBuilder();
        char[] cArray = s.trim().toCharArray();
        for(int i =0 ; i <cArray.length;i++){
            char c = cArray[i];
            if(c == ' '){
                continue;
            }
            if(operator.contains(c)){
                valQuene.addLast(Integer.parseInt(tmp.toString()));
                tmp = new StringBuilder();
                if(!opQuene.isEmpty()){
                    String lastOp = opQuene.getLast();
                    if(lastOp.equals("*")){
                        opQuene.pollLast();
                        int val2 = valQuene.pollLast();
                        int val1 = valQuene.pollLast();
                        valQuene.addLast(mult(val1,val2));
                    }
                    if(lastOp.equals("/") ){
                        opQuene.pollLast();
                        int val2 = valQuene.pollLast();
                        int val1 = valQuene.pollLast();
                        valQuene.addLast(dev(val1,val2));
                    }
                }
                opQuene.addLast(String.valueOf(c));
            }else{
                tmp.append(c);
            }
            if(i == cArray.length -1){
                valQuene.addLast(Integer.parseInt(tmp.toString()));
                if(!opQuene.isEmpty()){
                    String lastOp = opQuene.getLast();
                    if(lastOp.equals("*")){
                        opQuene.pollLast();
                        int val2 = valQuene.pollLast();
                        int val1 = valQuene.pollLast();
                        valQuene.addLast(mult(val1,val2));
                    }
                    if(lastOp.equals("/") ){
                        opQuene.pollLast();
                        int val2 = valQuene.pollLast();
                        int val1 = valQuene.pollLast();
                        valQuene.addLast(dev(val1,val2));
                    }
                }
            }
        }
        while(!opQuene.isEmpty()){
            String op = opQuene.pollFirst();
            int val1 = valQuene.pollFirst();
            int val2 = valQuene.pollFirst();
            switch(op){
                case "+":
                    valQuene.addFirst(add(val1,val2));
                    break;
                case "-":
                    valQuene.addFirst(minus(val1,val2));
                    break;
                case "*":
                    valQuene.addFirst(mult(val1,val2));
                    break;
                case "/":
                    valQuene.addFirst(dev(val1,val2));
                    break;
            }
        }
        return valQuene.pop();
    }

    private int  add(int val1 ,int val2){
        return val1 + val2;
    }

    private int  minus(int val1 ,int val2){
        return val1 - val2;
    }

    private int  mult(int val1 ,int val2){
        return val1 * val2;
    }

    private int  dev(int val1 ,int val2){
        return val1 / val2;
    }

}
