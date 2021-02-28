/* for both we are visiting each node once and that will only go in the stack/queue so worst case:
Time : O(m*n)
Space: o(m*n)
*/

//bfs
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    grid[i][j] = '0';
                    q.add(new int[] {i,j});
                    while(!q.isEmpty()){
                        int[] cell = q.poll();
                        for(int[] dir: dirs){
                            int r = cell[0] + dir[0];
                            int c = cell[1] + dir[1];
                            if(r >=0 && r < n && c >=0 && c < m && grid[r][c] == '1'){
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

//dfs
class Solution2 {
    int count;
    int n; int m;
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        
        count = 0;
        n = grid.length;
        m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                } 
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j){
        //base
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0') return;
        
        //logic
        grid[i][j] = '0';
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c);
        }
        
    }
}