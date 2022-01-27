
public class NumberOfIslands {
	//BFS
	//Time Complexity : O(m*n), where m are rows and n columns
	//Space Complexity : O(min(m, n))
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int numIslands(char[][] grid) {
        // null
        if(grid == null || grid.length == 0)
            return 0;

        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    q.offer(new int[] {i, j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] dir: dirs) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1') {
                                q.offer(new int[] {r, c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }

        return count;
    }


