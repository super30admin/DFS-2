class Solution {
    private int[][] d ={{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
            int n =0;
            for(int i = 0; i < grid.length; ++i){
          for(int j=0;j<grid[0].length;++j){
              if(grid[i][j]=='1'){
                  a(grid,i,j);
                  ++n;
              }}}
              return n;}
              private void a(char[][] grid, int i, int j){
                  if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0'){
                    return;
                  }
                  grid[i][j] = '0';
                  for(int[]x :d){
                      a(grid, i+x[0], j+x[1]);
                  }
              }
}
//tc=O(mn)
//sc=O(d)
