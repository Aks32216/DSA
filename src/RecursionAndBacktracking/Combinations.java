package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

class Solution {

    void solve(int curNum,int curCount,int n,int k,List<Integer> temp,List<List<Integer>> res){
        if(curCount>k || curNum>n){
            return;
        }
        if(curCount==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        solve(curNum+1,curCount,n,k,temp,res);
        temp.add(curNum);
        solve(curNum+1,curCount+1,n,k,temp,res);
        temp.remove(temp.size()-1);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(1,0,n,k,temp,res);
        return res;
    }
}
