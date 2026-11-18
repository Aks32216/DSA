package TwoPointers;

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;++i){
            nums[i]=(nums[i]*nums[i]);
        }
        Arrays.sort(nums);
        return nums;
    }
}


class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int left=0;
        int right=n-1;
        int idx=n-1;
        while(left<=right){
            if(Math.abs(nums[left])>=Math.abs(nums[right])){
                res[idx]=(nums[left] * nums[left]);
                left++;
                idx--;
            } else {
                res[idx]=(nums[right] * nums[right]);
                right--;
                idx--;
            }
        }
        return res;
    }
}
