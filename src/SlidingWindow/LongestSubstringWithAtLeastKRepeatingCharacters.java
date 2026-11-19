package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubstring(String s, int k) {
        Map<Character,Integer> charFreq=new HashMap<>();
        for(int i=0;i<s.length();++i){
            charFreq.put(s.charAt(i),charFreq.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();++i){
            if(charFreq.get(s.charAt(i))<k){
                int left=longestSubstring(s.substring(0,i),k);
                int right=longestSubstring(s.substring(i+1,s.length()),k);
                return Math.max(right,left);
            }
        }
        return s.length();
    }
}
