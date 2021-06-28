// DFS solution

// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    int[][]dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        this.dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        int counter = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i,j);
                    counter++;
                }
            }
        }
        return counter;
    }
    
    private void dfs(char[][]grid, int i, int j){
        grid[i][j] = '0';
        for(int[]dir: dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y] == '1'){
                dfs(grid, x, y);
            }
        }
    }
}

// BFS solution

// Time Complexity : O(mxn)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I got a time exceed initially when I did grid[curr[0]][curr[1]] = '0'.

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][]dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int counter = 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    counter++;
                    queue.add(new int[]{i, j});
                    while(!queue.isEmpty()){
                        int[] curr = queue.poll();
                        for(int[] dir: dirs){
                            int x = curr[0]+dir[0];
                            int y = curr[1]+dir[1];
                            if(x>=0 && y>=0 && x<m && y<n && grid[x][y] == '1'){
                                queue.add(new int[]{x,y});
                                grid[x][y] = '0';
                            }
                        }
                    }
                }
            }
        }
        
        return counter;
    }
}
