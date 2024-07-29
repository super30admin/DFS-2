// Time Complexity : O(mn)
// Space Complexity : O(Min of (m,n)) : diagonal
// Did this code successfully run on Leetcode : yes
class Solution {
    public int numIslands(char[][] grid) {
        Queue<Integer> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] directionsArray = new int[][] {{-1,0}, {0,1}, {0,-1}, {1,0}};
        int result = 0;
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = '0';
                    q.add(i);
                    q.add(j);
                    result++;
                    while(!q.isEmpty()) {
                        int r = q.remove();
                        int c = q.remove();
                        for(int[] dir: directionsArray) {
                            int cr = r + dir[0];
                            int cc = c + dir[1];
                            if(cr >= 0 && cc >= 0 && cr < m && cc < n && grid[cr][cc] == '1') {
                                q.add(cr);
                                q.add(cc);
                                grid[cr][cc] = '0';
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
}



//DFS
//TC : O(mn)
//SC : O(mn)

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directionsArray = new int[][] {{-1,0}, {0,1}, {0,-1}, {1,0}};
        int result = 0;
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j, directionsArray);
                }
            }
        }
        return result;
    }
    private void dfs(char[][] grid, int i, int j, int[][] directions) {
        //base
        if( i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        //logic
        for(int[] dir : directions) {
            int cr = dir[0] + i;
            int cc = dir[1] + j;
            dfs(grid, cr, cc, directions);
        }
    }
}