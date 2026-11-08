package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public void solve(int idx,int curSum,int target,int[] candidates,List<Integer> temp,List<List<Integer>> res){
        if(idx==candidates.length){
            if(target==curSum){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if(curSum>target){
            return;
        }
        solve(idx+1,curSum,target,candidates,temp,res);
        temp.add(candidates[idx]);
        solve(idx,curSum+candidates[idx],target,candidates,temp,res);
        temp.remove(temp.size()-1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(0,0,target,candidates,temp,res);
        return res;
    }
}
