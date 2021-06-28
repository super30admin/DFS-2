package DFS2;

/*
BFS
Time Complexity: O(m * n)
Space Complexity: O(m * n) */

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {
	int dirs1[][];
    public int numIslandsBFS(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        dirs1 = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0; j < n ; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    queue.add(new int[] {i, j});
                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for(int dir[]: dirs1) {
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];
                            if(nr >= 0 && nc >= 0 && nr < m && nc<n && grid[nr][nc]=='1') {
                                grid[nr][nc] = '0';
                                queue.add(new int[] {nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
