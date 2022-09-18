class Solution {
    public int numIslands(char[][] grid) {
        
        int x=0;
        
        for( int i=0;i<grid.length;i++){
            for( int j=0;j<grid[0].length;j++){
                
                if(grid[i][j]=='1'){
                    x++;
                    dfs(grid,i,j);
                }
            }
        }
        return x;
    }
    
    public void dfs(char [][] grid, int x, int y){
        
        if(x<0|| y<0|| x>grid.length-1|| y>grid[0].length-1 || grid[x][y]!='1'){
            return;
        }
        
        
        if(grid[x][y]=='1'){grid[x][y]=(char)(-1); }
        
        
        int [][]dirs={{1,0},{0,1},{-1,0},{0,-1}};
         
        for(int []dir : dirs){
            
            int xx=x+dir[0];
            int yy=y+dir[1];
            
            dfs(grid,xx,yy);
        }
        
    }
    
}

//TC: mXn
// SC: mXn