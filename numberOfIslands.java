/**
 * Problem: https://leetcode.com/problems/number-of-islands/
*/
 

/**
  * Approach 1: BFS
  * TC: O(m * n)
  * SC: O(min(m, n))
*/

class Location {
    int x, y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int dirs[][] = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        Queue<Location> queue = new LinkedList<>();
        int islands = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    ++islands;
                    queue.add(new Location(i, j));
                    
                    while (!queue.isEmpty()) {
                        Location l = queue.poll();
                        
                        
                        for (int d[] : dirs) {
                            int x = l.x + d[0];
                            int y = l.y + d[1];
                            
                            if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != '1') {
                                continue;
                            }
                            grid[x][y] = '0';
                            queue.add(new Location(x, y));
                        }
                    }
                }
            }
        }
        return islands;
    }
}

/**
  * Approach 1: DFS
  * TC: O(m * n)
  * SC: O(m * n)
*/
class Location {
    int x, y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int dirs[][] = new int[][] {
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        Queue<Location> queue = new LinkedList<>();
        int islands = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                
                if (grid[i][j] == '1') {
                    ++islands;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        return islands;
    }
    
    private void dfs(char grid[][], int x, int y, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != '1') {
            return;
        }
        
        grid[x][y] = '0';
        
        for (int d[] : dirs) {
            dfs(grid, x + d[0], y + d[1], n, m);
        }
    }
}