package DFS-2;

public class problem1 {
// Time Complexity : O(V*E) V are vertices and E are edges
// Space Complexity : O(V*E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// DFS

    int m, n, total;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    total++;
                    helper(grid, i, j);
                }
            }
        }
        return total;
    }
    
    public void helper(char[][] grid, int r, int c){
        //base
        if(r < 0 || r == m || c < 0 || c == n || grid[r][c] != '1') return;
        //logic
        grid[r][c] = '0';
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            helper(grid, nr, nc);
        }
    }
}
