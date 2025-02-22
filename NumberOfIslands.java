//The approach here is to perform BFS traversal for each 1 in the matrix and make it 0 along with all the neighbors which are 1.
//After each BFS traversal, we find one island, so we increase the island count by 1.
//Time Complexity: O(m*n) where m and n are the lengths of rows and columns in the matrix.
//Space Complexity: O(m*n)
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return '0';
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1'){
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir: dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr>=0 && nr <m && nc>=0 && nc<n && grid[nr][nc] == '1'){
                                q.add(new int[]{nr, nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                    count++;
                }                
            }
        }
        return count;
    }
}

//In this approach, we perform DFS traversal for each time we encounter a 1 in the matrix. The approach is the same as above, we make the value 0 and perform dfs on it's neighbors.
//When the DFS is complete for each 1, we find an island, so we increase the count by 1.
//Time Complexity: O(m*n) where m and n are the lengths of rows and columns in the matrix.
//Space Complexity: O(m*n)
class Solution1 {
    int count;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return '0';
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j, dirs);
                    count++;
                }                
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c, int[][] dirs){
        //base
        if(r<0 || r==grid.length || c<0 || c==grid[0].length || grid[r][c] == '0'){
            return;
        }
        //logic
        grid[r][c] = '0';
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc, dirs);
        }
    }
}