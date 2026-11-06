package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// DP with RECURSION

class Solution {

    private int solve(int x,int y,int n,List<List<Integer>> triangle,int[][] dp){
        if(x==n-1){
            return triangle.get(x).get(y);
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        int move1=triangle.get(x).get(y) + solve(x+1,y,n,triangle,dp);
        int move2=triangle.get(x).get(y) + solve(x+1,y+1,n,triangle,dp);
        return dp[x][y]=Math.min(move1,move2);

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,n,triangle,dp);
    }
}

// DP with momoization table

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // Initialize with the bottom row
        for (int col = 0; col < n; col++) {
            dp[col] = triangle.get(n - 1).get(col);
        }

        // Process from second-to-last row up to the top
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }
}
