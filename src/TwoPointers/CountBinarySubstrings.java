package TwoPointers;

class Solution {
    public int countBinarySubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();++i){
            int zc=0;
            int oc=0;
            int eo=Integer.MAX_VALUE;
            int lo=Integer.MIN_VALUE;
            int ez=Integer.MAX_VALUE;
            int lz=Integer.MIN_VALUE;
            for(int j=i;j<s.length();++j){
                if(s.charAt(j)=='1'){
                    oc++;
                    eo=Math.min(eo,j);
                    lo=Math.max(lo,j);
                } else {
                    zc++;
                    ez=Math.min(ez,j);
                    lz=Math.max(lz,j);
                }
                if(((lz<eo ) || (lo<ez)) && (zc==oc)){
                    System.out.println(i+" "+j);
                    count++;
                }
            }
        }
        return count;
    }
}

class Solution {
    public int countBinarySubstrings(String s) {
        int res=0;
        int streak=1;
        int prevStreak=0;
        for(int i=1;i<s.length();++i){
            if(s.charAt(i)==s.charAt(i-1)){
                streak++;
            } else {
                prevStreak=streak;
                streak=1;
            }
            if(streak<=prevStreak){
                res++;
            }
        }
        return res;
    }
}