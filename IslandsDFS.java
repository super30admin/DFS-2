// DFS -
// Space complexity = O(m*n)
//  Time complexity = O(m*n)
class Solution {
    int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        int res =0;
        for(int i=0;i< grid.length;i++) {
            for(int j=0;j< grid[0].length;j++) {
                if(grid[i][j]=='1') {
                    res++;
                    grid[i][j] ='0';
                    dfs(grid, i, j);
                }
                

            }
        }
        return res;
    }
    
    
    private void dfs(char[][] grid, int i, int j) {
        for(int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if(r>=0 && r< grid.length && c<grid[0].length && c>=0 && grid[r][c]=='1')                                 {                                
                    grid[r][c]='0';
                dfs(grid, r,c);
                            
                }
            }
        
        
    }
}