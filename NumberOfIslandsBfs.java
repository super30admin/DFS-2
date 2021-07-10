// Time Complexity : O(m * n)
// Space Complexity : O(Min(m,n))

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = 0;
                    q.add(new int[] {i,j});
                }
                while(!q.isEmpty()){
                    int cur[] = q.poll();
                    for(int[] dir: dirs){
                        int r = cur[0] + dir[0];
                        int c = cur[1] + dir[1];
                        if(r < m && c < n && r >= 0 && c >= 0 && grid[r][c] == '1'){
                            grid[r][c] = '0';
                            q.add(new int[]{r,c});
                        }
                    }
                }
            }
        }
        return count;
    }
}