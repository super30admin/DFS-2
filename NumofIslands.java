//TC will be O(m*n)
//SC will be O(m*n)

class NumofIslands {
    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        int count = 0;
        dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}}; // U D L R

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col){
        //base case
        if(row < 0 || row == m || col== n || col < 0 || grid[row][col] != '1'){
            return ;
        }
        //logic
        grid[row][col] = '2';
        for(int[] dir : dirs ){
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(grid, nr, nc);
        }
    }

        public static void main(String[] args) {
            char[][] grid =  {{'1','1','1','1','0'},
                    {'1','1','0','1','0'},
                    {'1','1','0','0','0'},
                    {'0','0','0','0','0'}};

            NumofIslands solution = new NumofIslands();
            int numberOfIslands = solution.numIslands(grid);

            System.out.println("Number of islands: " + numberOfIslands);
        }
    }
