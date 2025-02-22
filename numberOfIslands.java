// Problem1 (https://leetcode.com/problems/number-of-islands/)

// Time Complexity : O(m x n)
// Space Complexity : O(m x n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, traverse the matrix and when 1 is found add it to queue, increase the count by 1 and while q is not emptycheck if there
 *  are any 1's in neighbourhood and change those to 0's and add elements for making them already visited. Finally, return count.
 */
/* Iterative solution */
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    Queue<int []> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int []curr = q.poll();
                        int cr = curr[0];
                        int cc = curr[1];
                        for(int []dir:dirs){
                            int nr = cr + dir[0];
                            int nc = cc + dir[1];
                            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] == '1'){
                                grid[nr][nc]=0;
                                q.add(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}

/* Recursive solution */
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, dirs);
                }
    
            }

        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j, int [][]dirs){
        //base
        if(i< 0 || i == grid.length || j<0 || j == grid[0].length || grid[i][j] != '1') return;
        //logic
        grid[i][j] = '0';
        for(int []dir: dirs){
            int nr = i+dir[0];
            int nc = j+dir[1];
            dfs(grid, nr, nc, dirs);
        }
    }

}