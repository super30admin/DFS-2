import java.util.*;
// Time Complexity : O(m * n)
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        Queue<Integer> row = new java.util.LinkedList<>();
        Queue<Integer> col = new java.util.LinkedList<>();
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    row.add(i);
                    col.add(j);
                    while(!row.isEmpty()){
                        int cr = row.poll();
                        int cc = col.poll();
                        for(int[] dir : dirs){
                            int nr = cr + dir[0];
                            int nc = cc + dir[1];
                            if(nr >= 0 && nc >= 0 && nr < m && nc < n 
                               && grid[nr][nc] == '1'){
                                row.add(nr);
                                col.add(nc);
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
}