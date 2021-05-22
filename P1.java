//time-o(m*n)
//space-o(m*n)
//passed in leetcode- yes

class Solution {
    public int numIslands(char[][] grid) {
        //null checks
        if(grid==null || grid.length==0) return 0;
        
        int count = 0;
        
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++; // inc island count
                    dfs(grid, i, j); //call dfs check all its connected components vertically and horizontally
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int r, int c)
    {
        //base case 
        //bound check and if water, dont do anything---important
        if( r<0  || r>=grid.length || c<0 || c>=grid[r].length || grid[r][c]=='0') return ;
        
        //action
        grid[r][c] = '0';//sinking the land mass, so we dont recount it again
        
        //recursive calls
        dfs(grid, r, c+1);//right
        dfs(grid, r, c-1);//left
        dfs(grid, r+1, c);//up
        dfs(grid, r-1, c);//down
        
        
    }
}

/* private void dfs(char[][]grid,int r,int c){
        if(r<0 ||r==m || c<0 || c==n || grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir : dirs){
            int row=r+dir[0];
            int col=c+dir[1];
            dfs(grid,row,col);
        }
    }*/