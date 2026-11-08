package RecursionAndBacktracking;

import java.util.*;

class Solution {

    void solve(int idx,int curSum,int target,int[] candidates,List<Integer> temp,List<List<Integer>> res){
        if(curSum==target){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(curSum>target || idx==candidates.length){
            return;
        }
        for(int i=idx;i<candidates.length;++i){
            if(i!=idx && candidates[i]==candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            solve(i+1,curSum+candidates[i], target, candidates,temp,res);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(0,0,target,candidates,temp,res);
        return res;
    }
}
