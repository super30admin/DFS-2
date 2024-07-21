import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static int numIslandsBFS(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>(); //To hold the 1s
        //O(min(m,n)) S.C -> as in worst case, it holds the diagonal length of matrix in the q
        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
        int result = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) { //O(m*n) T.C
                if(grid[i][j] == '1') { //if any gird value with 1 is encountered
                    grid[i][j] = '0'; //change it immediately to 0 as we have already visited it
                    result++; //and increment the island count
                    q.add(new int[]{i,j}); //add this grid to q to process its children
                    while(!q.isEmpty()) { //process the q here itself as all connected 1s are still only one island
                        int[] current = q.poll();
                        for(int[] dir : dirs) { //check all its directions and its children's directions
                            int r = dir[0] + current[0];
                            int c = dir[1] + current[1];

                            if(r>=0 && c>=0 && r<m && c<n && grid[r][c] == '1') { //boundary check
                                q.add(new int[]{r,c}); //if any neighbor is also 1, add it to q to process immediately
                                grid[r][c] = '0'; //change the value to 0 to make it visited
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static int numIslandsDFS(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') { //if any grid values 1 is encountered
                    result++; //increment the island count here itself as all connected 1s are counted as single island
                    dfs(grid, i, j, dirs); //and perform dfs on all its children
                }
            }
        }
        return result; //notice result was calculated here itself and not in recursion because we only need a single 1
        //to form an island and all the connected 1s to it doesn't matter anymore. We only perform dfs on the children
        //to make sure they are visited and not counted again.
    }

    static void dfs(char[][] grid, int r, int c, int[][] dirs) { //O(m*n) T.C
        //base
        if(r<0 || c<0 || r == grid.length || c == grid[0].length //do not proceed if grid is not within matrix
                || grid[r][c] == '0') return; //or is equal to 0, just return to its parent call.

        //logic
        grid[r][c] = '0'; //change the grid value to 0 to make it visited.

        //recurse
        for(int[] dir: dirs) { //perform dfs on all its children too.
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            dfs(grid, nr, nc, dirs); //O(m*n) S.C, as in worst case if all grids are 1, the recursive stack can
            //contain all the nodes in it at one point.
        }
    }

    public static void main(String[] args) {
        char[][] grid1 = new char[][]{{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','1','0'}};

        System.out.println("Number of islands in " + Arrays.deepToString(grid1) + " using BFS is " +
                numIslandsBFS(grid1));

        char[][] grid2 = new char[][]{{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','1','0'}};

        System.out.println("Number of islands in " + Arrays.deepToString(grid2) + " using DFS is " +
                numIslandsDFS(grid2));
    }
}