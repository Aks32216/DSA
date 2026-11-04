package RecursionAndBacktracking;

import java.util.HashMap;
import java.util.Map;

// APPROACH - 1 BRUTE FORCE
class Solution {

    boolean isPossible(Map<Character, Boolean> mp) {
        for (Map.Entry<Character, Boolean> entry : mp.entrySet()) {
            char key = entry.getKey();
            boolean value = entry.getValue();

            char complement;
            if(key>='a' && key<='z'){
                complement=(char)(key-32);
            } else {
                complement=(char)(key+32);
            }

            if(!mp.containsKey(complement)){
                return false;
            }
        }

        return true;
    }

    public String longestNiceSubstring(String s) {
        int minIdx=Integer.MAX_VALUE;
        int maxLength=Integer.MIN_VALUE;
        for(int i=0;i<s.length();++i){
            Map<Character,Boolean> mp=new HashMap<>();
            for(int j=i;j<s.length();++j){
                mp.put(s.charAt(j),true);
                if(isPossible(mp)){
                    if((j-i+1)>maxLength){
                        minIdx=i;
                        maxLength=j-i+1;
                    }
                }
            }
        }
        return minIdx==Integer.MAX_VALUE ? "" : s.substring(minIdx,minIdx+maxLength);
    }
}


// APPROACH - 2 Divide and Conquor

class Solution {

    char findComplement(char key){
        if(key>='a' && key<='z'){
            return (char)(key-32);
        } else {
            return (char)(key+32);
        }

    }

    public String longestNiceSubstring(String s) {
        Map<Character,Boolean> mp=new HashMap<>();
        for(char c:s.toCharArray()){
            mp.put(c,true);
        }
        for(int i=0;i<s.length();++i){
            char cur=s.charAt(i);
            char complement=findComplement(cur);
            if(!mp.containsKey(complement)){
                String left=longestNiceSubstring(s.substring(0,i));
                String right=longestNiceSubstring(s.substring(i+1));
                if (left.length() >= right.length()){
                    return left;
                } else {
                    return right;
                }
            }
        }
        return s;
    }
}