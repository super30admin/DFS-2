/**Leetcode Question 200 - Number of Islands */
/**Algo - DFS
 * Find the first 1 in the grid array, increment the count by 1
 * Pass the grid, r & c of the 1 found
 * In the recursive function, mark the current element as 0 so that we know it has been visited
 * Check for all the neighbours similarly.
*/
/**TC- O(M*N)
 * SC - O(M*N)
 */
public class NumberOfIslands {
    class Solution {
        int m, n, count;
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            m = grid.length;
            n = grid[0].length;
            count=0;
            for(int i =0; i< m; i++){
                for(int j =0; j<n; j++){
                    if(grid[i][j] == '1'){
                        count++;
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }
        private void dfs(char[][] grid, int r, int c){
            //base
            if(r<0 || r== m || c<0 || c==n || grid[r][c]=='0'){
                return;
            }
            
            //logic
            grid[r][c] = '0';
            int[][] direction = new int[][] {{1,0},{-1,0},{0,-1},{0,1}};
            for(int[] dir: direction){
                int row = r + dir[0];
                int col = c + dir[1];
                dfs(grid, row, col);
            }
        }
    }
}
/**Algo - BFS */
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count =0;
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == '1'){
                    q.add(new int[] {i,j});
                    count++;
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir : directions){
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == '1'){
                                grid[r][c] = '0';
                                q.add(new int[] {r,c});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
