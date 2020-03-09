//DFS-2

//Problem1 (https://leetcode.com/problems/number-of-islands/)

// DFS - Time - O(mn) Space - O(mn)

class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    dfs(grid, row, col);
                    numOfIslands++;
                }
            }
        }
        
        return numOfIslands;
    }
    
    public void dfs(char[][] grid, int row, int col){
        
        if(row < 0 || row > grid.length - 1
           || col < 0 || col > grid[0].length - 1                 
           || grid[row][col] == '0')    return ;
        
        //Mark as visited
        grid[row][col] = '0';
        
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
        
    }
}

// BFS - Time - O(mn) Space - O(mn)
class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int islands = 0;
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    islands ++;
                    Queue<int[]> q = new LinkedList<>();
                    grid[row][col] = '0';
                    q.add(new int[]{row, col});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                            for(int[] dir: dirs){
                                int r = curr[0] + dir[0];
                                int c = curr[1] + dir[1];
                                if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1'){
                                    grid[r][c] = '0';
                                    q.add(new int[]{r, c});
                                }
                            }
                           
                        }
                    }
                    
            }
        }
        
        
        return islands;
    }

}