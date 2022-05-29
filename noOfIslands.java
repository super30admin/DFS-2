// Time Complexity : O(m*n) = O(mn) + O(mn) 
// Space Complexity : O(n) - minimum of m or n
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

//DFS
class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!='1'){
            return;
        }
        grid[i][j]='0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}

//BFS
class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    q.add(new int[]{i,j});
                    count++;
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir:dirs){
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if(r<0 || c<0 || r>=m || c>=n || grid[r][c]=='0'){
                                continue;
                            }
                            q.add(new int[]{r,c});
                            grid[r][c]='0';
                        }
                    }
                }
            }
        }
        return count;
    }
}