// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach - using dfs to get the #. whenever we encounter 1 we will call dfs on it
//During dfs we will call the neighbors recursively. 

public class NumberOfIslands{
    //dfs approach 
    private int n;
    private int m;
    int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int count = 0;
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

    private void dfs(char[][] grid, int i, int j){
        //base 
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') return;

        //logic 
        grid[i][j] = 0;
        for(int d[]: dirs){
            int r = i + d[0];
            int c = j + d[1];
            dfs(grid, r, c);
        }

    }


    //bfs approach 
    // private int n;
    // private int m;
    // int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    // public int numIslands(char[][] grid) {
    //     this.m = grid.length;
    //     this.n = grid[0].length;
    //     int count = 0;
    //     Queue<int[]> q = new LinkedList<>();
    //     for(int i = 0; i < m; i++){
    //         for(int j = 0; j < n; j++){
    //             if(grid[i][j] == '1'){
    //                 count++;
    //                 q.offer(new int[]{i,j});
    //                 while(!q.isEmpty()){
    //                     int curr[] = q.poll();
    //                     for(int d[]: dirs){
    //                         int r = d[0] + curr[0];
    //                         int c = d[1] + curr[1];
    //                         if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1'){
    //                             grid[r][c] = 0;
    //                             q.offer(new int[]{r,c});
    //                         }
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return count;
    // }
}