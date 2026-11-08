package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    void solve(int idx,List<Integer> temp,List<List<Integer>> res,int[] nums){
        res.add(new ArrayList<>(temp));
        for(int i=idx;i<nums.length;++i){
            if(i!=idx && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            solve(i+1,temp,res,nums);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(0,temp,res,nums);
        return res;
    }
}
