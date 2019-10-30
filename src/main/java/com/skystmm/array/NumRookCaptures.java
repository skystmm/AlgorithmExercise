package com.skystmm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 999. Available Captures for Rook
 * @author: skystmm
 * @date: 2019/10/30 17:45
 */
public class NumRookCaptures {
    /**
     * AC time:O(N^2),space: O(1)
     * @param board
     * @return
     */
    public int solution(char[][] board) {

        Integer count = 0;
        List<Integer> localtion = findR(board);
        if(localtion.size() >= 2){
            int i = localtion.get(0);
            int j = localtion.get(1);
            int k = j -1;
            while(k>=0){
                if(board[i][k] == 'p'){
                    count++;
                    break;
                }
                if(board[i][k] == 'B'){
                    break;
                }
                k--;
            }
            k = j+1;
            while(k < board.length){
                if(board[i][k] == 'p'){
                    count++;
                    break;
                }
                if(board[i][k] == 'B'){
                    break;
                }
                k++;
            }
            k = i-1;
            while(k>=0){
                if(board[k][j] == 'p'){
                    count++;
                    break;
                }
                if(board[k][j]  == 'B'){
                    break;
                }
                k--;
            }
            k = i+1;
            while(k < board.length){
                if(board[k][j] == 'p'){
                    count++;
                    break;
                }
                if(board[k][j] == 'B'){
                    break;
                }
                k++;
            }
        }
        return count;
    }

    private List<Integer> findR(char[][] board) {
        List<Integer> locals = new ArrayList<>(2);
        int i = 0, j = 0;
        while(i < board.length){
            j=0;
            while(j < board.length){
                if(board[i][j] == 'R'){
                    locals.add(i);
                    locals.add(j);
                    return locals;
                }
                j++;
            }
            i++;

        }
        return locals;
    }


}
