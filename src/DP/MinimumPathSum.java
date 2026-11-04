package DP;

import java.util.Arrays;

// APPROACH 1 -> TOP DOWN DP with MEMOIZATION

class Solution {

    private int solve(int x,int y,int[][] grid,int[][] dp){
        if(x==0 && y==0){
            return grid[x][y];
        }
        if(x<0 || y<0){
            return (int)1e8;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        return dp[x][y]=grid[x][y] + Math.min(solve(x-1,y,grid,dp),solve(x,y-1,grid,dp));
    }

    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(n-1,m-1,grid,dp);
    }
}


// APPROACH 2 -> BOTTOM UP DP with TABULATION

class Solution {

    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(i==0 && j==0){
                    dp[i][j]=grid[i][j];
                } else {
                    int maxVal=(int)1e8;
                    int up=i-1>=0 ? dp[i-1][j] : maxVal;
                    int left=j-1>=0 ? dp[i][j-1] : maxVal;
                    dp[i][j]=grid[i][j]+Math.min(up,left);
                }
            }
        }
        return dp[n-1][m-1];
    }
}
