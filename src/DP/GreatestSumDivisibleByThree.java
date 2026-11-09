package DP;

class Solution {
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][3];
        dp[0][0]=0;
        dp[0][1]=0;
        dp[0][2]=0;
        for(int i=1;i<=n;++i){
            for(int j=0;j<=2;++j){
                dp[i][j]=dp[i-1][j];
            }
            for(int j=0;j<=2;++j){
                int curVal=nums[i-1];
                int val=curVal+dp[i-1][j];
                int mod=val%3;
                dp[i][mod]=Math.max(dp[i][mod],val);
            }
        }
        return dp[n][0];
    }
}
