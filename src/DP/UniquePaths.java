package DP;

import java.util.Arrays;


// APPROACH 1 -> TOP DOWN DP

class Solution {

    int solve(int n,int m,int[][] dp){
        if(n==0 && m==0){
            return 1;
        }
        if(n<0 || m<0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        return dp[n][m]=solve(n-1,m,dp) + solve(n,m-1,dp);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(m-1,n-1,dp);
    }
}

// APPROACH 2 -> TABULATION + BOTTOM UP

class Solution{
    public int uniquePaths(int n,int m){
        int[][] dp=new int[m][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(i==0 && j==0){
                    dp[i][j]=1;
                } else {
                    int up=i-1>=0 ? dp[i-1][j] : 0;
                    int left=j-1>=0 ? dp[i][j-1] : 0;
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[n-1][m-1];
    }
}