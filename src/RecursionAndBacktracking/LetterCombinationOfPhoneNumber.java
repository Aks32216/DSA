package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private Map<Integer, String> phoneMapping = new HashMap<>(Map.of(
            2, "abc",
            3, "def",
            4, "ghi",
            5, "jkl",
            6, "mno",
            7, "pqrs",
            8, "tuv",
            9, "wxyz"
    ));

    private void solve(int idx,String digits,StringBuilder temp,List<String> res){
        if(idx==digits.length()){
            res.add(new String(temp.toString()));
            return;
        }
        int cur=digits.charAt(idx)-'0';
        for(int i=0;i<phoneMapping.get(cur).length();++i){
            temp.append(phoneMapping.get(cur).charAt(i));
            solve(idx+1,digits,temp,res);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        StringBuilder temp=new StringBuilder();
        List<String> res=new ArrayList<>();
        solve(0,digits,temp,res);
        return res;
    }
}
