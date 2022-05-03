import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    // BFS approach
    // TC: O(m * n) m - number of rows & n - number of columns
    // SC: O(m * n) worst case: If all the elements of the grid are 1 then we will end up putting all of them into the queue
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int total = 0;

        int[][] dirs = new int[][]{
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };

        int rows = grid.length;
        int columns = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // This nested for loop is to search for occurrence of 1
        // As soon as we find 1, initiate the BFS process
        for(int i=0; i < rows; i++) {
            for (int j=0; j < columns; j++){
                if(grid[i][j] == '1') {
                    // we found the first island. After this we need to identify how big is this island
                    total++;

                    queue.add(new int[]{i, j});

                    // Otherwise, this will create an infinite loop. So, to mark it as visited, make it as 0
                    grid[i][j] = '0';

                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();

                        for(int[] dir : dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];

                            // Now, check whether the new co-ordinates are within the bounds or not
                            if(nr >= 0 && nr < rows && nc >= 0 && nc < columns && grid[nr][nc] == '1') {
                                queue.add(new int[]{nr,nc});
                                grid[nr][nc] = '0';
                            }

                        }
                    }
                }
            }
        }

        return total;
    }
}
