package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

class Solution {

    void solve(int curNum,int curCount,int curSum,int k,int n,List<Integer> temp,List<List<Integer>> res){
        if(curCount==k){
            if(curSum==n){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if(curCount>k || curSum>n){
            return;
        }
        solve(curNum+1,curCount,curSum,k,n,temp,res);
        temp.add(curNum);
        solve(curNum+1,curCount+1,curSum+curNum,k,n,temp,res);
        temp.remove(temp.size()-1);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(1,0,0,k,n,temp,res);
        return res;
    }
}
