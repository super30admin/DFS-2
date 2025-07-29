// We use DFS to find number of islands
// TC: O(n2) - within for loop we call dfs so atmost twice
// SC: O(h) - for recursive stack call

class Solution {
    int m;
    int n;
    int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (grid[i][j] == '1'){
                    count = count + 1;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr < m && nc < n && nr >= 0 && nc >= 0 && grid[nr][nc] == '1'){
                grid[nr][nc] = '0';
                dfs(grid, nr, nc);
            }
        }
    }
}
