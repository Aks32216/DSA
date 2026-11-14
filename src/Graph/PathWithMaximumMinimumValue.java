package Graph;

import java.util.PriorityQueue;

class Solution {
    private int n;
    private int m;
    private int[] dx={1,-1,0,0};
    private int[] dy={0,0,1,-1};

    class Triplet{
        int val;
        int row;
        int col;

        Triplet(int val,int row,int col){
            this.val=val;
            this.row=row;
            this.col=col;
        }

        @Override
        public String toString() {
            return "Triplet{" +
                    "val=" + val +
                    ", row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    public int maximumMinimumPath(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        if(n==0 || m==0){
            return 0;
        }
        PriorityQueue<Triplet> pq=new PriorityQueue<>((Triplet a,Triplet b)->Integer.compare(b.val,a.val));
        boolean[][] visited=new boolean[n][m];
        visited[0][0]=true;
        pq.offer(new Triplet(grid[0][0],0,0));
        int minPathValue=Integer.MAX_VALUE;
        while(pq.isEmpty()){
            Triplet cur=pq.poll();
            minPathValue=Math.min(cur.val,minPathValue);
            if(cur.row==n-1 && cur.col==m-1){
                return minPathValue;
            }
            for(int i=0;i<4;++i){
                int curX=cur.row+dx[i];
                int curY=cur.col+dy[i];
                if(curX>=0 && curY>=0 && curX<n && curY<m && visited[curX][curY]==false){
                    visited[curX][curY]=true;
                    pq.offer(new Triplet(grid[curX][curY],curX,curY));
                }
            }
        }
        return 0;
    }
}
