// Time Complexity :O(m x n)
// Space Complexity :O(min(m,n))
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// using bfs
// whenever we see a 1, increase the count by 1, make it 0
//make all neighbouring 1's also 0 ( for not counting again )
class Solution {
    public int numIslands(char[][] grid) {
        int [][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1') 
                {
                    count ++;
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int [] cell = q.poll();
                        for(int[] dir: directions){
                            int row = dir[0] + cell[0];
                            int col = dir[1] + cell[1];
                            if(row>=0 && row < m && col>=0 && col<n && grid[row][col] == '1'){
                                q.add(new int[]{row,col});
                                grid[row][col] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}





// Time Complexity :O(m x n)
// Space Complexity :O(m x n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// using dfs
// each dfs call is one island found
class Solution {
    int [][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1') 
                {
                    count ++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        if( i<0 || i ==m || j<0 || j==n || grid[i][j]!='1') return;
        grid[i][j] = '0';
        for( int[] dir: directions){
            int row = dir[0] + i;
            int col = dir[1] + j;
            dfs(grid, row,col);
        }
    }
}