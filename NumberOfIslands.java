// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    // DFS Solution: Time : O(m*n) Space : O(1) stack space: O(m*n)
    // 1. We need to traverse this matrix as graph, we consider that this matrix is a undirected graph, with 1 s are connected in 4 directions.
    // 2. Rather than keeping visited, we just change value of visited nodes to '0' or anything else than '1'.
    // 3. We will start from a node with value 1 and will cover all connected 1 s with DFS.
    // 4. We count the number of times DFS is called from original grid, which is our answer.

    public int numIslandsDFS(char[][] grid) {
        int m = grid.length;
        if(grid == null || m == 0){
            return 0;
        }

        int n = grid[0].length;
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != '1'){
            return;
        }

        grid[r][c] = '2';

        dfs(grid, r+1, c);
        dfs(grid, r, c+1);
        dfs(grid, r-1, c);
        dfs(grid, r, c-1);
    }


    // BFS Solution Time: O(m*n) Space: O(m*n)

    public int numIslandsBFS(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == '1'){
                    count++;
                    grid[r][c] = '0';
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{r,c});

                    while(!q.isEmpty()){

                        int[] curr = q.remove();
                        for(int[] dir : dirs){
                            int i = curr[0] + dir[0];
                            int j = curr[1] + dir[1];

                            if(i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == '1'){
                                q.add(new int[] {i,j});
                                grid[i][j] = '0';
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
