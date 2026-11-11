package Graph;//Given an m x n binary matrix mat, return the distance of the nearest 0 for
//each cell.
//
// The distance between two cells sharing a common edge is 1.
//
//
// Example 1:
//
//
//Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
//Output: [[0,0,0],[0,1,0],[0,0,0]]
//
//
// Example 2:
//
//
//Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
//Output: [[0,0,0],[0,1,0],[1,2,1]]
//
//
//
// Constraints:
//
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 10⁴
// 1 <= m * n <= 10⁴
// mat[i][j] is either 0 or 1.
// There is at least one 0 in mat.
//
//
//
// Note: This question is the same as 1765: https://leetcode.com/problems/map-
//of-highest-peak/
//
// Related Topics Array Dynamic Programming Breadth-First Search Matrix 👍 11047
// 👎 457

import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Pair{
    public int x;
    public int y;

    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }

    int getX(){
        return this.x;
    }

    int getY(){
        return this.y;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[] dx=new int[]{1,-1,0,0};
        int[] dy=new int[]{0,0,1,-1};
        Queue<Pair> q = new LinkedList<>();
        int[][] dist=new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                dist[i][j]=-1;
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j));
                    dist[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int x=q.peek().getX();
                int y=q.peek().getY();
                q.poll();
                for(int i=0;i<4;++i){
                    int curX=x+dx[i];
                    int curY=y+dy[i];
                    if(curX>=0 && curX<n && curY>=0 && curY<m && dist[curX][curY]==-1){
                        q.offer(new Pair(curX,curY));
                        dist[curX][curY]=dist[x][y]+1;
                    }
                }
            }
        }
        return dist;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
