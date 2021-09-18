//Time complexity: O(M * N) 
//Space complexity: O(M * N)
class Solution {
    int[][] dirs;
    Queue<int[]> q;
    int m;
    int n;
    public int numIslands(char[][] grid) {

        //number of rows
        m = grid.length;
        //number of columns
        n = grid[0].length;
        int num_islands = 0;
        dirs=  new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //if we find 1 we will increment the count by 1 
                if(grid[i][j] == '1') {
                    num_islands++;
                    //call dfs on every node
                    dfs(grid, i, j);                     
                }
            }
        }
        return num_islands;
    }

    private void dfs(char[][] grid, int i, int j) {
        //base 
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] != '1') {
            return;
        }
        //logic
        grid[i][j] = '0';
        for(int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c);
        }

    }
}