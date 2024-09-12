// Time Complexity : O(mn) m=no of row, n=no of cols for both approaches
// Space Complexity : O(mn) m=no of row, n=no of cols for both approaches
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// DFS Approach
class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int m=grid.length, n = grid[0].length, count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1') {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid,int r,int c) {
        int[][] dirs = {{0,-1},{-1,0},{1,0},{0,1}};
        if(r<0 || r>grid.length || c<0 || c>grid[0].length || grid[r][c]=='0')
            return;
        grid[r][c]=0;
        for(int[] dir:dirs){
            int newRow = r+dir[0];
            int newCol = c+dir[1];
            if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol]=='1') {
                dfs(grid,newRow,newCol);
            }
        }
    }
}


// BFS Approach

class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j]=='1') {
                    count++;
                    grid[i][j]='0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()) {
                        int[] curr=q.poll();
                        for(int[] dir:dirs) {
                            int r = dir[0]+curr[0];
                            int c = dir[1]+curr[1];
                            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]=='1') {
                                grid[r][c]='0';
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}