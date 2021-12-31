//time o(mn)
//space o(min(m,n))

class Solution {
    class Pair {
        int x;
        int y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
    }
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = '2';
                    numberOfIslands++;
                    bfs(grid, i, j, grid.length, grid[0].length);
                }
            }
        }
        return numberOfIslands;
    }
    
    public void bfs(char[][] grid, int i, int j, int rows, int cols) {
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()) {
            Pair p = q.poll();
            
            int pX = p.getX();
            int pY = p.getY();
            
            //grid[pX][pY] = '2';
            
            for(int[] dir : dirs) {
                int newX = pX + dir[0];
                int newY = pY + dir[1];
                if(newX >= 0 && newX < rows && newY >=0 && newY < cols) {
                    if(grid[newX][newY] == '1') {
                        q.add(new Pair(newX, newY));
                        grid[newX][newY] = '2';
                    }
                }
            }
            
        }
    }
    
    
//     public void dfs(char[][] grid, int i, int j, int rows, int cols) {
//         if(i<0 || i==rows || j<0 || j==cols || grid[i][j] != '1') {
//             return;
//         }
        
//         grid[i][j] = '2';
        
//         dfs(grid, i-1, j,   rows,  cols);
//         dfs(grid, i+1, j,   rows,  cols);
//         dfs(grid, i, j-1,   rows,  cols);
//         dfs(grid, i, j+1,   rows,  cols);
        
//     }
}
