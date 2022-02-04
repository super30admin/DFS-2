// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class NumberOfIslands_DFS {
    static int[][] dirs;
    static int count;

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int i, int j, int m, int n){
        //base
        if(i<0 || j<0 || i==m || j==n || grid[i][j] == '0')
            return;

        //logic
        grid[i][j] = '0';
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c, m, n);
        }
    }
}

