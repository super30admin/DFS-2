//Time Complexity: O(mn)
//Space Complexity : O(mn)
//did your code run on leetcode : yes
//DFS
class Solution {
    int dirs[][];
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(grid,i,j,m,n);
                }
            }
        }
        
        return count;
    
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n){
        //base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j]!='1') return;
        //logic
        grid[i][j] = '2';
        for(int[] dire : dirs){
            int r = i + dire[0];
            int c = j + dire[1];
            dfs(grid, r ,c, m ,n);
        }
    }
}
