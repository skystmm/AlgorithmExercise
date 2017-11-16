package com.skystmm.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 500. Keyboard Row
 * Created by Administrator on 2017/11/16.
 */

public class KeyboardRow {
    private static HashSet<String> one = getRow(1);
    private static HashSet<String> two = getRow(2);
    private static HashSet<String> three = getRow(3);
    private static HashSet<String> four = getRow(4);

    /**
     * AC time : 3 ms，beats:79.59 %
     * @param words
     * @return
     */
    public static String[] findWords(String[] words) {
        List<String> result = new ArrayList<String>();
        for(String word : words){
            String cmp = word.toLowerCase();
            int row =0;
            boolean tag = true;
            for(int i = 0 ;i<word.length();i++){
                String cur = String.valueOf(cmp.charAt(i));
                if(i == 0){
                    if(one.contains(cur)){
                        row = 1;
                    }else if(two.contains(cur)){
                        row = 2;
                    }else if(three.contains(cur)){
                        row = 3;
                    }else if(four.contains(cur)){
                        row = 4;
                    }
                }
                if(!sameRow(cur,row)){
                    tag = false;
                    break;
                }
            }
            if(tag){
                result.add(word);
            }

        }
        return result.toArray(new String[result.size()]);
    }

    private static boolean sameRow(String cur, int row) {
        switch (row){
            case 1:
                return one.contains(cur);
            case 2:
                return two.contains(cur);
            case 3:
                return three.contains(cur);
            case 4:
                return four.contains(cur);
        }
        return false;
    }

    private static HashSet<String> getRow(int i){
        HashSet<String> res = new HashSet<String>();
        switch (i){
            case 1:
            {
                res.add("`");res.add("1");res.add("2");res.add("3");res.add("4");res.add("5");res.add("6");res.add("7");res.add("8");res.add("9");
                res.add("0");res.add("-");res.add("+");
                res.add("~");res.add("!");res.add("@");res.add("#");res.add("$");res.add("%");res.add("^");res.add("&");res.add("(");res.add(")");
                res.add("_");res.add("+");res.add("*");
                break;
            }
            case 2:{
                res.add("q");res.add("w");res.add("e");res.add("r");res.add("t");res.add("y");res.add("u");res.add("i");res.add("o");res.add("p");
                res.add("{");res.add("}");
                res.add("[");res.add("]");res.add("\\");res.add("|");
                break;
            }
            case 3:{
                res.add("a");res.add("s");res.add("d");res.add("f");res.add("g");res.add("h");res.add("j");res.add("k");res.add("l");res.add(";");
                res.add("'");res.add(":");res.add("\"");
                break;
            }
            case 4:{
                res.add("z");res.add("x");res.add("c");res.add("v");res.add("b");res.add("n");res.add("m");res.add(",");res.add(".");res.add("/");
                res.add("<");res.add(">");res.add("?");
                break;
            }

        }
        return res;
    }

}
