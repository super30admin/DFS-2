/*
Approach: BFS (level-order) to count islands.
- Iterate over the grid; when a '1' is found, increment island count and start BFS from that cell.
- During BFS mark visited land cells as '0' to avoid revisiting. Add neighboring land cells to the queue.

Time Complexity: O(m * n) — each cell is processed at most once.
Space Complexity: O(m * n) — queue may hold O(m*n) cells in the worst case.

LeetCode: https://leetcode.com/problems/number-of-islands/
*/
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        for (int[] dir : dirs) {
                            int cr = current[0] + dir[0];
                            int cc = current[1] + dir[1];
                            if (cr >= 0 && cc >= 0 && cr < grid.length && cc < grid[0].length
                                    && grid[cr][cc] != '0') {
                                queue.add(new int[]{cr, cc});
                                grid[cr][cc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
