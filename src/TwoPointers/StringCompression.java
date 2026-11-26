package TwoPointers;

class Solution {
    public int compress(char[] chars) {
        StringBuilder res=new StringBuilder();
        char ch=chars[0];
        int curCount=1;
        for(int i=1;i<chars.length;++i){
            if(chars[i]==ch){
                curCount++;
            } else {
                res.append(ch);
                if(curCount!=1){
                    res.append(curCount);
                }
                ch=chars[i];
                curCount=1;
            }
        }
        res.append(ch);
        if(curCount!=1){
            res.append(curCount);
        }
        for(int i=0;i<res.length();++i){
            chars[i]=res.charAt(i);
        }
        return res.length();
    }
}

class Solution {
    public int compress(char[] chars) {
        int writeIndex=0;
        char ch=chars[0];
        int i=0;
        while(i<chars.length){
            ch=chars[i];
            int curCount=0;
            while(i<chars.length && chars[i]==ch){
                i++;
                curCount++;
            }
            chars[writeIndex++]=ch;
            if(curCount!=1){
                for(char c:String.valueOf(curCount).toCharArray()){
                    chars[writeIndex++]=c;
                }
            }

        }
        return writeIndex;
    }
}
