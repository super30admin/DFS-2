// Solution - 1 (DFS)
// TimeComplexity: O(m*n)
// SpaceComplexity: O(m*n)

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = {{1,0}, {0,1},{-1,0},{0,-1}};
        int result =0;
        for(int i =0; i<n; i++) {
            for(int j=0; j<m; j++) {
                char ch = grid[i][j];
                if(ch == '1') {
                    result++;
                    dfs(grid, m, n, i, j, dirs);   
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int m, int n, int r, int c, int[][] dirs) {
        // base
        if(r<0 || c<0 || r>=n || c>=m || grid[r][c]!='1') return;

        // logic
        grid[r][c] = '0';
        for(int k =0 ; k<4; k++) { 
            int row = r + dirs[k][0];
            int col = c + dirs[k][1];
            dfs(grid, m, n, row, col, dirs);
        }

    }
}




// Solution - 2 (BFS)
// TimeComplexity: O(m*n)
// SpaceComplexity: O(min(m,n))

class Solution {
    public int numIslands(char[][] grid) {
        
        Queue<Integer> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = {{1,0}, {0,1},{-1,0},{0,-1}};
        int result =0;
        for(int i =0; i<n; i++) {
            for(int j=0; j<m; j++) {
                char ch = grid[i][j];
                if(ch == '1') {
                    result++;
                    q.add(i);
                    q.add(j);
                    while(!q.isEmpty()) {
                        int currR = q.poll();
                        int currC = q.poll();
                        for(int k =0 ; k<4; k++) {
                            int r = currR + dirs[k][0];
                            int c = currC + dirs[k][1];
                            if(r>=0 && c>=0 && r<n && c<m) {
                                if(grid[r][c] == '1') {
                                    grid[r][c] = '0';
                                    q.add(r);
                                    q.add(c);
                                }
                            }
                        }   
                    }   
                }
            }
        }
    return result;
    }
}
