package DP;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<numRows;++i){
            List<Integer> cur=new ArrayList<>(i+1);
            for(int j=0;j<=i;++j){
                if(j==0 || j==i){
                    cur.add(1);
                } else {
                    cur.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
                }
            }
            res.add(cur);
        }
        return res;
    }
}
