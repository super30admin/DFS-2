package DFS2;
// Time Complexity : O(mxn)
// Space Complexity : O(min(m,n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


import java.util.ArrayDeque;
import java.util.Queue;

// Your code here along with comments explaining your approach
class NumberOfIslands{
    public int numIslands(char[][] grid) {
        int count = 0;
        Queue<int[]> q;
        int [][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    q = new ArrayDeque<>();
                    count++;
                    q.add(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] cell = q.poll();
                        for(int [] dir : dirs){
                            int r = cell[0] + dir[0];
                            int c = cell[1] + dir[1];
                            if(r >= 0 && r < grid.length && c >=0 && c < grid[0].length && grid[r][c] == '1'){
                                q.add(new int[]{r, c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}