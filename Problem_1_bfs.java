// Time complexity - O(m*n) {O(mn) for iterating over matrix and O(mn) for dfs}
// Space complexity - O(d), {d = diagonal length of matrix}

// BFS

class Solution {
    public int numIslands(char[][] grid) {
        // Edge case
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir : dirs){
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];
                            if(r >= 0 && r < m && c >= 0 && c <n && grid[r][c] == '1'){
                                grid[r][c] = '0';
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
