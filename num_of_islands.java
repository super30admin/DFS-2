//T.C- O(NxM)- n- rows and m-cols 
//S.C- O(NxM)- n- rows and m-cols
class Solution {
    public void dfs(char[][] grid, int r, int c ){
      int numrows= grid.length;
      int numcols= grid[0].length;

      if(r<0 || c<0 || r>=numrows || c>=numcols|| grid[r][c]=='0'){
        return; //if it is out of bounds or 0, no island
      }
      grid[r][c]='0'; //mark it as visited
      dfs(grid, r-1, c); //perform dfs on its neighbors //up
      dfs(grid, r+1,c);//down
      dfs(grid,r,c-1); //left
      dfs(grid,r,c+1); //right

    }
    public int numIslands(char[][] grid) {
      if(grid==null || grid.length==0){
        return 0;
      }
      int numrows= grid.length;
      int numcols= grid[0].length;
      int num_islands=0;

      for(int r=0; r<numrows;r++){ //traverse through the graph
        for(int c=0; c<numcols;c++){
          if(grid[r][c]=='1'){ //if u find 1 then that means island is there, add it to count
            num_islands++;
            dfs(grid,r,c); //and perform dfs
          }
        }
      }
      return num_islands;
        
    }
}