//time complexity O(2 x m x n)
//space complexity O(m x n)
//APPROACH: DFS

class Solution {
    int count;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    dfs(grid, i , j);
                }
            }
        }
        return count;
    }
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private void dfs(char[][] grid, int i, int j){
	//base

        //logic
        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1'){
                grid[r][c] = '0';
                dfs(grid, r, c);
            }
        }
    } 
}

//time complexity O(2 x m x n)
//space complexity O(m x n)
//APPROACH: BFS

class Solution {
    int count;
    Queue<int[]> q;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    grid[i][j] = '0';
                    bfs(grid, i , j);
                }
            }
        }
        return count;
    }
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private void bfs(char[][] grid, int i, int j){
        //base

        //logic
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1'){
                    q.add(new int[]{r,c});
                    grid[r][c] = '0';
                    bfs(grid, r, c);
                }
            }
        }

    }
}
