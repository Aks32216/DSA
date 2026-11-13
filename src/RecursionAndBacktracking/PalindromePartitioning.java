package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private boolean isPalindrome(StringBuilder sb){
        int start=0,end=sb.length()-1;
        while(start<=end){
            if(sb.charAt(start)!=sb.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private void solve(int idx,String s,StringBuilder sb,List<String> temp,List<List<String>> res){
        if(idx==s.length()){
            if(sb.length()==0){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        sb.append(s.charAt(idx));
        solve(idx+1,s,sb,temp,res);
        if(isPalindrome(sb)){
            temp.add(sb.toString());
            solve(idx+1,s,new StringBuilder(),temp,res);
            temp.remove(temp.size()-1);
        }
        sb.deleteCharAt(sb.length()-1);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        solve(0,s,sb,temp,res);
        return res;
    }
}
