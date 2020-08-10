/**
Problem: Number of islands
Did it run on LeetCode : Yes

Time Complexity : O(m*n), where m is the number of rows, and n is the number of columns of the grid
Space Complexity : O(m*n), where m is the number of rows, and n is the number of columns, as we use a queue in BFS

Approach : BFS
1. We keep track of the neighboring elements with the help of directions array.
2. We use queue to implement BFS. We first check if the element in the present cell of the grid is 1. If it is 1, then we increment the number of islands and make that cell 0.
3. Then we go to their neighbors and add them to the queue. And repeat the process.

*/

class Solution {
    public int numIslands(char[][] grid) {
       if(grid == null || grid.length == 0) {
           return 0;
       }
        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == '1') {
                    numIslands++;
                    q.add(new int[]{i,j});
                    grid[i][j] = 0;
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] dir : directions) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if(r>=0 && c>=0 && r<m && c<n && grid[r][c] == '1') {
                                grid[r][c] = '0';
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return numIslands;
    }
}