// Time Complexity : O(mn) where m*n is the size of grid
// Space Complexity : O(mn) where m*n is the size of grid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class NumOfIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    dfs(i,j,grid);
                }
            }
        }

        return islands;
    }

    public void dfs(int r, int c, char[][] grid){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]=='0'){
            return;
        }

        if(grid[r][c]=='1'){
            grid[r][c]='0';
        }

        dfs(r+1,c,grid);
        dfs(r-1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);
    }

    public static void main(String [] args){
        NumOfIslands islands = new NumOfIslands();
        char [][] grid = new char[][] {
          {'1','1','1','1','0'},
          {'1','1','0','1','0'},
          {'1','1','0','0','0'},
          {'0','0','0','0','1'}
        };
        System.out.println(islands.numIslands(grid));
    }
}