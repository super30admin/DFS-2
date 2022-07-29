//Time Complexity: O(m*n), where m is the no. of rows & n is the no. of columns
//Space Complexity: O(m*n), Recursion Stack Space
//Code run successfully on LeetCode.

public class Problem1_DFS {

    int[][] dirs = new int[][] {{-1,0},{0,-1},{1,0},{0,1}};
    
    public int numIslands(char[][] grid) {
        
        if(grid == null|| grid.length == 0)
            return -1;
        
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i =0; i < m; i++){
            for(int j =0; j < n; j++){
                
                if(grid[i][j] == '1'){
                    
                    result++;
                    dfs(grid,i,j,m,n);
                }
            }
        }
        
        return result;
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n){
        
        if(i < 0 || i >= m || j < 0|| j >= n || grid[i][j] != '1')
          return;
        
        grid[i][j] = '0';
        
        for(int[] dir : dirs){
            
            int nr = i + dir[0];
            int nc = j + dir[1];
            
            dfs(grid, nr, nc, m ,n);
            
        }
    }
}
