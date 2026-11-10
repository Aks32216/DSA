package DP;

// Recursion

import java.util.Arrays;

class Solution {

    private long solve(int x,int y,int n,int m,int[][] points){
        if(x==0){
            return points[x][y];
        }
        long curMaxPoint=0;
        for(int i=0;i<m;++i){
            long p=solve(x-1,i,n,m,points) - Math.abs(y-i)+points[x][y];
            curMaxPoint=Math.max(curMaxPoint,p);
        }
        return curMaxPoint;
    }

    public long maxPoints(int[][] points) {
        long maxPoint=0;
        int n=points.length;
        int m=points[0].length;
        for(int i=0;i<m;++i){
            long curPoints=solve(n-1,i,n,m,points);
            maxPoint=Math.max(maxPoint,curPoints);
        }
        return maxPoint;
    }
}

// Top Down DP

class Solution {

    private long solve(int x,int y,int n,int m,int[][] points, long[][] dp){
        if(x==0){
            return points[x][y];
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        long curMaxPoint=0;
        for(int i=0;i<m;++j){
            long p=solve(x-1,i,n,m,points,dp) - Math.abs(y-i)+points[x][y];
            curMaxPoint=Math.max(curMaxPoint,p);
        }
        return dp[x][y]=curMaxPoint;
    }

    public long maxPoints(int[][] points) {
        long maxPoint=0;
        int n=points.length;
        int m=points[0].length;
        long[][] dp=new long[n][m];
        for(long[] row:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<m;++i){
            long curPoints=solve(n-1,i,n,m,points,dp);
            maxPoint=Math.max(maxPoint,curPoints);
        }
        return maxPoint;
    }
}

// Bottom up

class Solution {
    public long maxPoints(int[][] points) {
        int n=points.length;
        int m=points[0].length;
        long[] dp=new long[m];
        for(int i=0;i<m;++i){
            dp[i]=points[0][i];
        }
        for(int i=1;i<n;++i){
            long[] cur=new long[m];
            for(int j=0;j<m;++j){
                long maxPoint=0;
                for(int k=0;k<m;++k){
                    long curPoint=points[i][j] + dp[k] - Math.abs(j-k);
                    maxPoint=Math.max(maxPoint,curPoint);
                }

                cur[j]=maxPoint;
            }
            dp=cur;
        }
        long res=0;
        for(int i=0;i<m;++i){
            res=Math.max(res,dp[i]);
        }
        return res;

    }
}