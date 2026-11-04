package DP;

import java.util.Arrays;

// APPROACH 1 -> TOP DOWN DP WITH MEMOIZATION

class Solution {

    int solve(int x,int y,int[][] obstacleGrid,int[][] dp){
        if(x==0 && y==0){
            return 1;
        }
        if(x<0 || y<0){
            return 0;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        if(obstacleGrid[x][y]==1){
            return 0;
        }
        return dp[x][y]=solve(x-1,y,obstacleGrid,dp) + solve(x,y-1,obstacleGrid,dp);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1 || obstacleGrid[n-1][m-1]==1){
            return 0;
        }

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n-1,m-1,obstacleGrid,dp);
    }
}

// APPROACH 2 -> BOTTOM UP DP WITH TABULATION

class Solution {

    int solve(int x,int y,int[][] obstacleGrid,int[][] dp){
        if(x==0 && y==0){
            return 1;
        }
        if(x<0 || y<0){
            return 0;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        if(obstacleGrid[x][y]==1){
            return 0;
        }
        return dp[x][y]=solve(x-1,y,obstacleGrid,dp) + solve(x,y-1,obstacleGrid,dp);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1 || obstacleGrid[n-1][m-1]==1){
            return 0;
        }

        int[][] dp = new int[n][m];

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(obstacleGrid[i][j]==1){
                    System.out.println(obstacleGrid[i][j]);
                    dp[i][j]=0;
                } else if(i==0 && j==0){
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