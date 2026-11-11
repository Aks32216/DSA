package RecursionAndBacktracking;

import java.util.*;

class Solution {

    private void solve(int[] nums,List<Integer> temp,Set<List<Integer>> res){
        if(nums.length==temp.size()){
            res.add(new ArrayList<>(temp));
        }
        for(int i=0;i<nums.length;++i){
            if(nums[i]==Integer.MAX_VALUE){
                continue;
            }
            int curVal=nums[i];
            nums[i]=Integer.MAX_VALUE;
            temp.add(curVal);
            solve(nums,temp,res);
            nums[i]=curVal;
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res=new HashSet<>();
        List<Integer> temp=new ArrayList<>();
        solve(nums,temp,res);
        return new ArrayList<>(res);
    }
}

// map

class Solution {

    private void solve(int[] nums,List<Integer> temp,List<List<Integer>> res,Map<Integer,Integer> mp){
        if(nums.length==temp.size()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(Integer key: mp.keySet()){
            if(mp.get(key)==0){
                continue;
            }
            mp.put(key,mp.get(key)-1);
            temp.add(key);
            solve(nums,temp,res,mp);
            mp.put(key,mp.get(key)+1);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(nums,temp,res,mp);
        return res;
    }
}