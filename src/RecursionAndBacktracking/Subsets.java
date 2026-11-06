package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;


// BACKTRACKING

class Solution {

    void solve(int idx,int[] nums, List<Integer> temp,List<List<Integer>> res){
        if(idx==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(idx+1,nums,temp,res);
        temp.remove(temp.size()-1);
        solve(idx+1,nums,temp,res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(0,nums,temp,res);
        return res;
    }
}

// BIT MASKING

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        int totalSubsets=(1<<n);
        List<List<Integer>> res=new ArrayList<>();
        for(int mask=0;mask<=totalSubsets;++i){
            List<Integer> cur=new ArrayList<>();
            for(int i=0;i<nums.length;++i){
                if((mask & (1<<i))!=0){
                    cur.add(nums[i]);
                }
            }
            res.add(cur);
        }
        return res;
    }
}
