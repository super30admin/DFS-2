

// Time - O(M * N)
// Space - MIN(M,N)


class Solution {

    int count;
    int [][] dirs;
    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        // iterate through m and n

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++ ) {

                // if we encounter 1 then increment count and iterate through the babies using dfs
                if(grid[i][j] == '1') {

                    count++;
                    dfs(grid,i,j,m,n);

                }

            }
        }

        return count;


    }

    private void dfs(char[][] grid, int r, int c, int m, int n) {

        // base
        if(r < 0 || c < 0 || r == m || c == n || grid[r][c] != '1') return;

        //logic

        //make the first element as "0" when encountered and run dfs on neighboring elements
        grid[r][c] = '0';

        for(int [] dir: dirs) {

            int i = r + dir[0];
            int j = c + dir[1];
            dfs(grid,i,j,m,n);

        }


    }


}