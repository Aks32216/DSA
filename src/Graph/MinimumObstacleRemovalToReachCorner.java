package Graph;

import java.util.*;

class Solution {

    int n,m;
    int[] dx={1,-1,0,0};
    int[] dy={0,0,1,-1};

    class Pair{
        int first;
        int second;

        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }

    public int minimumObstacles(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int[][] dist=new int[][];
        for(int[] row:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        Deque<Pair> q=new ArrayDeque<>();
        q.offerFirst(new Pair(0,0));
        dist[0][0]=grid[0][0];

        while(!q.isEmpty()){
            Pair cur=q.pollFirst();
            int x=cur.first;
            int y=cur.second;

            if(x==n-1 && y==n-1){
                return dist[x][y];
            }

            for(int i=0;i<4;++i){
                int curX=x+dx[i];
                int curY=y+dy[i];
                if(dist[curX][curY]>dist[x][y]+grid[curX][curY]){
                    dist[curX][curY]=dist[x][y]+grid[curX][curY];
                    if(grid[curX][curY]==0){
                        q.offerFirst(new Pair(curX,curY));
                    } else {
                        q.offerLast(new Pair(curX,curY));
                    }
                }
            }
        }
        return -1;

    }
}
