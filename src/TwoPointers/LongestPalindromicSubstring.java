package TwoPointers;


class Solution {

    private int longestPalindromeFromI(String s,int i,int j){
        int maxLen=0;
        while(i>=0 && j<=s.length()-1){
            if(s.charAt(i)==s.charAt(j)){
                maxLen=j-i+1;
                i--;
                j++;
            } else {
                break;
            }
        }
        return maxLen;
    }

    public String longestPalindrome(String s) {
        int maxLen=0;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();++i){
            int l1=longestPalindromeFromI(s,i,i);
            int l2=longestPalindromeFromI(s,i,i+1);
            int curMaxLen=Math.max(l1,l2);
            if(curMaxLen>maxLen){
                maxLen=curMaxLen;
                int start=i-(curMaxLen-1)/2;
                int end=start+maxLen;
                res=new StringBuilder(s.substring(start,end));
            }
        }
        return res.toString();
    }
}
