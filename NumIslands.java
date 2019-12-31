/*Time Complexity: O(m*n)
Space Complexity: O(m*n)
Accepted on Leetcode: Yes
Approach: DFS Solution: Imagining a graph instead of a 2D array. A node containing a '1' is a root node that triggers a Depth First Search.
*/

class Solution {
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        if(grid == null || m==0)
            return 0;

        n = grid[0].length;
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        // called dfs on one cell which had a '1'. now make all neighbors as '0'
        //Base case
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        int[][] dirs = new int[][] {{0,-1}, {0,1}, {-1,0}, {1,0}};
        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(grid, r, c);
        }
    }
}

/*Time Complexity: O(m*n)
Space Complexity: O(m*n)
Accepted on Leetcode: Yes
Approach: BFS Solution: Put a 1 entountered into a queue and set its value as '0' to mark it as visited. Then process the queue and iterate through the elements.
*/

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(grid == null || m==0)
            return 0;
        int n = grid[0].length;
        int[][] dirs = new int[][] {{0,-1},{0,1},{1,0}, {-1,0}};

        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';

                    while(!q.isEmpty()){
                        int cur[] = q.poll();

                        for(int[] dir : dirs){
                            int r = dir[0] + cur[0];
                            int c = dir[1] + cur[1];

                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == '1'){
                                q.add(new int[]{r,c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
} 