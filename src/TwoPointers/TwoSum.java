package TwoPointers;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;++i){
            for(int j=i+1;j<nums.length;++j){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;++i){
            if(mp.containsKey(target-nums[i])){
                return new int[]{i,mp.get(target-nums[i])};
            }
            mp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
