package TwoPointers;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder tempS=new StringBuilder();
        StringBuilder tempT=new StringBuilder();

        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='#'){
                if(!tempS.isEmpty()){
                    tempS.deleteCharAt(tempS.length()-1);
                }
            } else {
                tempS.append(s.charAt(i));
            }
        }
        for(int i=0;i<t.length();++i){
            if(t.charAt(i)=='#'){
                if(!tempT.isEmpty()){
                    tempT.deleteCharAt(tempT.length()-1);
                }
            } else {
                tempT.append(t.charAt(i));
            }
        }
        return tempS.compareTo(tempT)==0;
    }
}

// two pointer approach

class Solution{
    public boolean backspaceCompare(String s,String t){
        int i=s.length()-1;
        int j=t.length()-1;
        int skipS=0;
        int skipT=0;
        while(i>=0 || j>=0){
            while(i>=0){
                if(s.charAt(i)=='#'){
                    skipS++;
                    i--;
                } else if(skipS>0){
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while(j>=0){
                if(t.charAt(j)=='#'){
                    skipT++;
                    j--;
                } else if(skipT>0){
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if(i>=0 && j>=0){
                if(s.charAt(i)!=t.charAt(j)){
                    return false;
                }
            } else if(i>=0 || j>=0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}


