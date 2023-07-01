import java.util.Queue;
import java.util.LinkedList;

public class IslandsNumberBFS {

        public int numIslands(char[][] grid) {

            // BFS

            int m = grid.length; int n = grid[0].length;

            int[][] dirFour = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

            int nIsland = 0;

            for(int i = 0; i < m; i++) { // O(m*n)

                for(int j = 0; j < n; j++) {

                    // new 1 = new island starts
                    if(grid[i][j] == '1') {

                        // increase number of islands count by 1
                        nIsland++;

                        // initiate a new queue for BFS run
                        Queue<int[]> q = new LinkedList<>();

                        // start queue with i,j position whose grid value gave 1 first
                        q.add(new int[] {i,j});

                        // make grid value zero once 1 is encountered, to avoid conflict in counting number of islands during BFS
                        grid[i][j] = 0;

                        // run BFS until queue gets empty
                        while(!q.isEmpty()) { // O(m*n) worst case - only one BFS run
                            // mind time complexity != o(m^2*n^2), but = O(m*n)

                            // pop out the front of queue
                            int[] curr = q.poll();

                            // check four directions of popped element
                            for(int[] dir: dirFour) {

                                int nr = curr[0] + dir[0];

                                int nc = curr[1] + dir[1];

                                // if new position is in bounds of grid, value 1 is found
                                if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {

                                    // add new 1 position to queue
                                    q.add(new int[] {nr, nc});

                                    // make grid value of newly found 1 as 0
                                    grid[nr][nc] = 0;
                                }

                            }

                        }

                    }
                }
            }
            // output the total number of islands
            return nIsland;
        }



}

/* Time Complexity = O(m*n)
nested for loops = m*n, single worst-case BFS covering all grid positions (1) = m*n
worst case = 2(m*n) = O(m*n)

Space Complexity = O(min(m,n)) = O(m) if m < n, O(n) if n < m
maximum of number of elements going in queue = length of diagonal of grid  = min(m,n)*/

