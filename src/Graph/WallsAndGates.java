package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    class Pair{
        private Integer first;
        private Integer second;

        Pair(Integer first,Integer second){
            this.first=first;
            this.second=second;
        }

        public Integer getFirst() {
            return first;
        }

        public Integer getSecond() {
            return second;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        int n,m;
        n=rooms.length;
        m=rooms[0].length;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Pair> q=new ArrayDeque<>();
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(rooms[i][j]==0){
                    q.offer(new Pair(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                Pair cur=q.poll();
                int x=cur.getFirst();
                int y=cur.getSecond();
                for(int i=0;i<4;++i){
                    int curX=x+dx[i];
                    int curY=y+dy[i];
                    if(curX>=0 && curY>=0 && curX<n && curY<m && rooms[curX][curY]==Integer.MAX_VALUE){
                        rooms[curX][curY]=rooms[x][y]+1;
                        q.offer(new Pair(curX,curY));
                    }
                }
            }
        }
    }
}
