// Time Complexity : O(M×N)
// Space Complexity : O(M×N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    int dirs [][];
    public int numIslands(char[][] grid) {
        // int [][]dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
        // int m = grid.length;
        // int n = grid[0].length;
        // Queue<Integer> q = new LinkedList<>();
        // int count = 0;
        // for(int i = 0; i<m; i++){
        //     for(int j = 0; j<n; j++){
        //         if(grid[i][j]=='1'){
        //             count++;
        //             q.add(i);
        //             q.add(j);
        //             grid[i][j]= '0';

        //             while(!q.isEmpty()){
        //                 int cr = q.poll();
        //                 int cc = q.poll();
        //                 for(int []dir : dirs){
        //                     int nr = cr+dir[0];
        //                     int nc = cc+dir[1];
        //                     if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1' ){
        //                         q.add(nr);
        //                         q.add(nc);
        //                         grid[nr][nc]='0';
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
        // return count;

        dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i , j ,m ,n);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j, int m, int n){
        
        if(i<0 || j<0 || i==m || j==n || grid[i][j]=='0') return;
        grid[i][j] = '0';
        for(int []dir: dirs){
            int nr = i+dir[0];
            int nc = j +dir[1];
            dfs(grid, nr, nc, m ,n);
        }
    }
}