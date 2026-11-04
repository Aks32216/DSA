package RecursionAndBacktracking;

import java.util.Stack;

// SOLUTION - 1 - USING STACK
class Solution {
    public String decodeString(String s) {
        Stack<String> stringStack= new Stack<>();
        Stack<Integer> countStack=new Stack<>();
        StringBuilder curString=new StringBuilder();
        int curNum=0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                curNum=curNum*10 + (ch-'0');
            } else if(ch=='['){
                countStack.push(curNum);
                stringStack.push(curString.toString());
                curNum=0;
                curString=new StringBuilder();
            } else if(ch==']'){
                int repeatingNum=countStack.pop();
                StringBuilder decoded=new StringBuilder(stringStack.pop());
                for(int i=1;i<=repeatingNum;++i){
                    decoded.append(curString);
                }
                curString=decoded;

            } else {
                curString.append(ch);
            }
        }
        return curString.toString();
    }
}
