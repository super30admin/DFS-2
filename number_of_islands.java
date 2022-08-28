// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
// We can solve this question using dfs or bfs, the bfs is used to improve on space complexity. 


class Solution {
    // use this a global variable only while using dfs
    int [][] dirs;
    int m; int n;
    public int numIslands(char[][] grid) {
        
        // Using BFS // time complexity is 2(m*n) // space complexity min(m,n)
        // if (grid== null || grid.length==0) return 0;
        // int m = grid.length; int n = grid[0].length;
        // int count=0;
        // int [][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        // for (int i=0; i<m; i++){
        //     for (int j=0; j<n; j++){
        //         if(grid[i][j]=='1'){
        //             count++;
        //             Queue<int []> q = new LinkedList<>();
        //             q.add(new int[]{i,j});
        //             grid[i][j]='0';
        //             while(!q.isEmpty()){
        //                 int [] curr = q.poll();
        //                 for(int [] dir: dirs){
        //                     int nr = curr[0] + dir[0];
        //                     int nc = curr[1] + dir[1];
        //                     if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc]=='1'){
        //                         q.add(new int[]{nr,nc});
        //                         grid[nr][nc]='0';  
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
        // return count;
        
        // Using DFS // Time complexity in worst case is (m*n)/ space is (m*n)
        if (grid== null || grid.length==0) return 0;
        m = grid.length; n = grid[0].length;
        int count=0;
        dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                 if(grid[i][j]=='1'){
                     count++;
                     dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char [][] grid, int i, int j){
        //base case 
        if(i < 0 || j < 0 || i==m || j==n || grid[i][j]=='0') return;
        
        grid[i][j]='0';
        for(int[] dir: dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            dfs(grid, r, c);
        }
    }
}