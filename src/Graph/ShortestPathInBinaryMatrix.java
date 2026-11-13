package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int n;
    private int m;
    private int[] dx={0,1,1,1,0,-1,-1,-1};
    private int[] dy={1,1,0,-1,-1,-1,0,1};

    class Pair{
        Integer first;
        Integer second;
        Pair(Integer first, Integer second){
            this.first=first;
            this.second=second;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        if(n==0 || m==0 || grid[0][0]==1 || grid[n-1][m-1]==1){
            return -1;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0));
        grid[0][0]=1;
        int chances=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                Pair cur=q.poll();
                if(cur.first==n-1 && cur.second==m-1){
                    return chances;
                }
                for(int i=0;i<8;++i){
                    int curX=cur.first+dx[i];
                    int curY=cur.second+dy[i];
                    if(curX>=0 && curY>=0 && curX<n && curY<m && grid[curX][curY]==0){
                        q.offer(new Pair(curX,curY));
                        grid[curX][curY]=1;
                    }
                }
            }
            chances++;
        }
        return -1;
    }
}
