class Solution {

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0) return 0;

        int count = 0;

        for(int i = 0;i< grid.length; i++){

            for(int j = 0; j < grid[0].length ; j++){

                if(grid[i][j] == '1'){

                    count++;

                    dfs(grid, i, j);

                }

            }

        }

        return count;

    }

    

    private void dfs(char[][] grid, int i, int j){

        if(grid[i][j] == '1'){

            grid[i][j] = '0';

            int[][] dirs = {{0,1}, {1,0}, {-1, 0}, {0, -1} };

            for(int k = 0; k< dirs.length; k++){

                int x = dirs[k][0] + i;

                int y = dirs[k][1] + j;

                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length)

                    dfs(grid, x ,y);

            } 

        } 

    }

}
