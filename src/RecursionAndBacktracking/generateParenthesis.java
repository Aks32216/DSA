import java.util.ArrayList;
import java.util.List;

class Solution {

    private void solve(int open,int close,int n,StringBuilder sb, List<String> res){
        if(close==n){
            res.add(sb.toString());
        }
        if(open<n){
            sb.append('(');
            solve(open+1,close,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            solve(open,close+1,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder sb=new StringBuilder();
        List<String> res=new ArrayList<>();
        solve(0,0,n,sb,res);
        return res;
    }
}