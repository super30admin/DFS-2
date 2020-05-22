// Time Complexity : O(rows*columns)
// Space Complexity : O(rows*columns)

class Solution {
    public int numIslands(char[][] grid) {
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfs(i,j,grid);
                    result++;
                }
            }
        }
        
        return result;
    }
    
    public void bfs(int i, int j, char[][] grid){
        grid[i][j]='0';
        Queue<Integer> q = new LinkedList<>();
        int rowLen = grid.length, colLen = grid[0].length;
        q.add(i*colLen+j);
        
        int[] ax = {-1,0,1,0};
        int[] ay = {0,1,0,-1};
        
        while(!q.isEmpty()){
            int val = q.poll();
            for(int k=0;k<4;k++){
                int r = val/colLen+ax[k];
                int c = val%colLen+ay[k];
                
                if(r>=0 && c>=0 && r<rowLen && c<colLen  && grid[r][c]=='1'){
                    grid[r][c]='0';
                    q.add(r*colLen+c);
                }
            }
        }
        
    }
}

// Time Complexity : O(rows*columns)
// Space Complexity : O(rows*columns)

class Solution {
    public int numIslands(char[][] grid) {
        int result=0, rowLen = grid.length;
        if(rowLen==0)
            return 0;
        int colLen = grid[0].length;;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i*colLen+j,grid,rowLen, colLen);
                    result++;
                }
            }
        }
        
        return result;
    }
    
    public void dfs(int val, char[][] grid, int rowLen, int colLen){
        grid[val/colLen][val%colLen]='0';
        
        int[] ax = {-1,0,1,0};
        int[] ay = {0,1,0,-1};
        
        for(int k=0;k<4;k++){
            int r = val/colLen+ax[k];
            int c = val%colLen+ay[k];
                
            if(r>=0 && c>=0 && r<rowLen && c<colLen  && grid[r][c]=='1'){
                dfs(r*colLen+c,grid,rowLen, colLen);
            }
        }
    }
}
