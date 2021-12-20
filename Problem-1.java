// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        
        for(int i=0;i<grid.length;i++) {
            for(int j = 0;j<grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    numberOfIslands++;
                    bfs(i,j,grid.length,grid[0].length,grid);
                }
            }
        }
        return numberOfIslands;
    }
    class Pair {
        int x,y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private void bfs(int row,int col,int rows,int cols, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        grid[row][col] = '2';
        q.add(new Pair(row,col));
        while(!q.isEmpty()) {
            Pair p = q.poll();
            for(int[] dir:directions) {
                int nrow = p.x+dir[0];
                int ncol = p.y+dir[1];
                
                if(nrow>=0 && nrow<rows && ncol>=0 && ncol<cols && grid[nrow][ncol] == '1') {
                    grid[nrow][ncol] = '2';
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
    }
}