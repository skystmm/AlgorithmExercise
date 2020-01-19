package com.skystmm.lintcode.array;

/**
 * @author: skystmm
 * @date: 2020/1/17 14:22
 */
public class CowherdWeaver {
    /**
     * use traversal && backtrack
     * @param maze: the maze
     * @return: Can they reunion?
     */
    public boolean findHer(String[] maze) {
        // Write your code here
        char[][] puzzle = new char[maze.length][];
        int row = 0;
        int col = 0;
        for(int i = 0;i < maze.length ; i++){
            char[] cur = maze[i].toCharArray();
            puzzle[i] = cur;
            for(int j =0;j<cur.length;j++){
               if(puzzle[i][j] == 'S'){
                   row = i;
                   col = j;
               }
            }

        }
        return find(puzzle,row,col);
    }

    private boolean find(char[][] puzzle,int row,int col) {
        int rLen = puzzle.length;
        int cLen = puzzle[0].length;
        if(puzzle[row][col] == 'T'){
            return true;
        }else if(puzzle[row][col] == '*'){
            return  false;
        }else if(puzzle[row][col] == '.'){
            boolean res = false;
            if(col +1 <cLen){
                res = res |find(puzzle, row, col+1);
            }
            if(col -1 > -1){
                res = res |find(puzzle, row, col-1);
            }
            if(row + 1 < rLen){
                res = res |find(puzzle, row +1, col);
            }
            if(row - 1 > -1){
                res = res |find(puzzle, row -1, col);
            }
            return res;
        }
        return  false;
    }

    public static void main(String[] args) {
        System.out.println(new CowherdWeaver().findHer(new String[]{"....*",".....",".....","*S**.","T**.*"}));
    }
}
