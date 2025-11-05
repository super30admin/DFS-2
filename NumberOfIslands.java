// Time Complexity : O(m*n).
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Approach : I implemented BFS to solve this problem. We should traverse the given matrix and when we encounter 1 we mark it as visited
// and check if neighbors are 1's. If yes mark them as 0 which means visited. When the neighbors are 0's, that means we have completed
// parsing one island and continue parsing other levels.


class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null){
            return 0;
        }
        int islands = 0;
        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') { //perform BFS when we encounter 1
                    islands++; //increment islands for each level
                    grid[i][j] = '0'; //mark it as visited
                    queue.add(new int[] { i, j });
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] curr = queue.poll();
                            for (int[] dir : directions) {
                                int nr = curr[0] + dir[0]; //neighboring rows
                                int nc = curr[1] + dir[1]; //neighboring columns
                                if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {//bounds and condition check
                                    grid[nr][nc] = '0'; // mark as visited
                                    queue.add(new int[] {nr,nc}); // add to queue
                                }
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }

}
