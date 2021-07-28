//Time complexity: O(m*n), where m*n is the size of the grid.
//Space complexity: O(m*n)

class Solution1 {
    char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int islands = 0; 
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j);
                    islands++;
                }
            }
        }
        return islands; 
    }
    
    public void dfs(int i, int j) {
        //base case
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(i-1, j);
        dfs(i, j-1);
        dfs(i+1, j);
        dfs(i, j+1);
    }
}