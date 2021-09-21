package trees;

public class noofilands {
	public int numIslands(char[][] grid) {
        if(grid.length==0 || grid==null){
            return 0;
        }
        int noOfIlands=0;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]=='1'){
                 noOfIlands+=dfs(row,col,grid);
                }
                }
            }
        return noOfIlands;
        }
        public int  dfs(int i,int j,char[][] grid){
            if(i<0 || i>=grid.length || j<0 || j >=grid[i].length || grid[i][j]=='0' ){
                return 0;
            }
            grid[i][j]='0';
            dfs(i+1,j,grid);
            dfs(i,j+1,grid);
            dfs(i-1,j,grid);
            dfs(i,j-1,grid);
            return 1;   
        }

}
