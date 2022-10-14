//BFS Approach

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;
        
        int dirs[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    island++;
                    
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int[] dir : dirs){
                            int nr = cur[0] + dir[0];
                            int nc = cur[1] + dir[1];
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return island;
    }
}

//Time Complexity : O(m * n)
//Space Complexity : O(min(m, n))