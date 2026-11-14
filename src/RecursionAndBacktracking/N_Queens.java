package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private void addToResult(char[][] board,List<List<String>> res){
        List<String> temp=new ArrayList<>();
        for(int i=0;i<board.length;++i){
            temp.add(new String(board[i]));
        }
        res.add(temp);
    }

    private boolean isValid(int row,int col,char[][] board){
        // col check
        for(int i=0;i<board.length;++i){
            if(i==row){
                continue;
            }
            if(board[i][col]=='Q'){
                return false;
            }
        }

        // primary diagonal check

        int i=row-1;
        int j=col-1;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }
        // non primary diagonal check
        i=row-1;
        j=col+1;
        while(i>=0 && j<board.length){
            if(board[i][j]=='Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }


    private void solve(int row,int n,char[][] board,List<List<String>> res){
        if(row==n){
            addToResult(board,res);
            return;
        }


        for(int j=0;j<n;++j){
            if(isValid(row,j,board)){
                board[row][j]='Q';
                solve(row+1,n,board,res);
                board[row][j]='.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;++i){
            Arrays.fill(board[i],'.');
        }
        solve(0,n,board,res);
        return res;
    }
}
