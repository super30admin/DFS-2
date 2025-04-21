class Solution {

    int[][] directions = new int[][]{{0,1}, {1,0}, {-1, 0}, {0,-1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1')
                {
                    count = count+1;
                    grid[i][j] ='2';
                    dfs(grid, i, j);

                }
            }
        }

        return count;

        
    }

    private void dfs(char[][] grid, int i , int j)
    {
        for(int[] direction : directions)
        {
            int r =direction[0] + i;
            int c = direction[1] + j;

            if(r >=0 && c >= 0 && r < grid.length && c < grid[0].length)
            {
                if(grid[r][c] == '1')
                {
                    grid[r][c] ='2';
                    dfs(grid, r, c);

                }

            }

        }



    }
}