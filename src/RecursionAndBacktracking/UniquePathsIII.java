package RecursionAndBacktracking;

import java.util.Stack;

class Solution {

    private int result=0;
    private int totalNonObstackle=0;
    private int n,m;
    private int[] dx={1,-1,0,0};
    private int[] dy={0,0,1,-1};

    private void dfs(int row,int col,int visited,int[][] grid){
        if(grid[row][col]==2){
            if(visited==totalNonObstackle){
                result++;
            }
            return;
        }
        int original=grid[row][col];
        grid[row][col]=-1;
        for(int i=0;i<4;++i){
            int curX=row+dx[i];
            int curY=col+dy[i];
            if(curX>=0 && curY>=0 && curX<n && curY<m && grid[curX][curY]!=-1){
                dfs(curX,curY,visited+1,grid);
            }
        }
        grid[row][col]=original;
        Stack<Integer> st=new Stack<>();
        st.
    }


    public int uniquePathsIII(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int start=-1;
        int end=-1;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(grid[i][j]==1){
                    start=i;
                    end=j;
                }
                if(grid[i][j]!=-1){
                    totalNonObstackle++;
                }
            }
        }
        dfs(start,end,1,grid);
        return result;
    }
}

