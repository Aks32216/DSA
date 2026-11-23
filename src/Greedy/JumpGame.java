package Greedy;

// DP
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            // Check if any reachable index j can jump to i
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }
}

// Greedy
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            // If current index is beyond our reach, we're stuck
            if (i > maxReach) return false;

            // Extend our reach from the current position
            maxReach = Math.max(maxReach, i + nums[i]);

            // Early exit if we can already reach the end
            if (maxReach >= nums.length - 1) return true;
        }

        return true;
    }
}

// Greedy
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        // Work backwards: can each index reach the current goal?
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}
