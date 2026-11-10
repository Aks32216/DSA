package DP;


import java.util.Arrays;

// brute force
class Solution {
    public int climbStairs(int n, int[] costs) {
        if(n==0){
            return 0;
        }
        int c1=Integer.MAX_VALUE;
        int c2=Integer.MAX_VALUE;
        int c3=Integer.MAX_VALUE;
        if(n-1>=0){
            c1=costs[n-1] + 1 + climbStairs(n-1,costs);
        }
        if(n-2>=0){
            c2=costs[n-1] + 4 + climbStairs(n-2,costs);
        }
        if(n-3>=0){
            c3=costs[n-1] + 9 + climbStairs(n-3,costs);
        }
        return Math.min(c1,Math.min(c2,c3));
    }
}

// top down dp

class Solution {

    private int solve(int n,int[] costs,int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int c1=Integer.MAX_VALUE;
        int c2=Integer.MAX_VALUE;
        int c3=Integer.MAX_VALUE;
        if(n-1>=0){
            c1=costs[n-1] + 1 + solve(n-1,costs,dp);
        }
        if(n-2>=0){
            c2=costs[n-1] + 4 + solve(n-2,costs,dp);
        }
        if(n-3>=0){
            c3=costs[n-1] + 9 + solve(n-3,costs,dp);
        }
        return dp[n]=Math.min(c1,Math.min(c2,c3));
    }

    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,costs,dp);
    }
}
