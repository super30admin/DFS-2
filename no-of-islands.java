//Time : O(m*n)
//Space : O(m*N)

class Solution {
    public void exploreIsland(char[][] grid, int i, int j, int r, int c){
        if(i < 0 || i >= r || j < 0 || j >= c || grid[i][j]!= '1') return;
        
        grid[i][j] = '2';
        
        exploreIsland(grid, i+1, j, r, c);
        exploreIsland(grid, i, j+1, r, c);
        exploreIsland(grid, i-1, j, r, c);
        exploreIsland(grid, i, j-1, r, c);
    }
    
    public int numIslands(char[][] grid) {
        int r = grid.length;
        if(r == 0) return 0;
        int c = grid[0].length;
        int count = 0;
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == '1'){
                    exploreIsland(grid, i, j, r, c);
                    count += 1;
                }
            }
        }
        return count;
    }
}