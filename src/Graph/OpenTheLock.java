package Graph;

import java.util.*;

class Solution {

    public List<String> getAllNegihbors(String s){
        List<String> res = new ArrayList<>();

        for (int i = 0; i < s.length(); ++i) {
            StringBuilder up = new StringBuilder(s);
            StringBuilder down = new StringBuilder(s);

            up.setCharAt(i, (s.charAt(i) == '9')
                    ? '0' : (char)(s.charAt(i) + 1));

            down.setCharAt(i, (s.charAt(i) == '0')
                    ? '9' : (char)(s.charAt(i) - 1));

            res.add(up.toString());
            res.add(down.toString());
        }

        return res;
    }

    public int openLock(String[] deadends, String target) {
        Set<String> mp=new HashSet<>();
        Set<String> visited=new HashSet<>();
        for(String cur: deadends){
            mp.add(cur);
        }
        if(mp.contains("0000") || mp.contains(target)){
            return -1;
        }
        Deque<String> q=new ArrayDeque<>();
        q.offer("0000");
        visited.add("0000");
        int times=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String cur=q.poll();
                if(cur.equals(target)){
                    return times;
                }
                List<String> negihbors=getAllNegihbors(cur);
                for(String child:negihbors){
                    if(mp.contains(child) || visited.contains(child)){
                        continue;
                    }
                    q.offer(child);
                    visited.add(child);
                }
            }
            times++;
        }
        return -1;
    }
}
