// have to find a way that you don't put the duplicates in, here i'm putting '0' the moment i visit a 1 so that we keep track of visited 
// idea is to perform BFS on every occurance of 1 inside the BFS we are making every adjacent 1 as 0 
// this way we can accurately identify the island
// in BFS the type of elements in Queue can be array, or you can use two Queues for row and column

// tc -> o(m * n) note that we arent performing dfs at every cell. we are only performing where there's '1' inside dfs we are making it '0' for adjacent '1'
// worst case tc: o(2(m * n)) this happens when every cell is '1' in which case dfs will traverse entire matrix once so m* n also the outer for loop wil traverse entire matrix once
// sc: o(m * n)
class Solution {
    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        m = grid.length;
        n = grid[0].length;
        int total = 0;
        dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        //Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    total++; //observe that we increment total here itself
                }
            }
        }
        return total;
    }
    private void dfs(char[][] grid, int i, int j) {
        //base
        if(i < 0 || i == m || j < 0 || j == n || grid[i][j] != '1') {
            return;
        } 
        //logic
        grid[i][j] = '0';
        for(int [] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c);
        }
    }
}