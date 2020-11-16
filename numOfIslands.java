// Time Complexity : o(2mn)
// Space Complexity : min(m,n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 200
//Approach :  BFS 

class Solution {
    int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0 ;
        Queue<int []> q = new LinkedList<>();
        
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == '1'){
                    count++; 
                    q.add(new int[] {i,j});
                    grid[i][j] = '0';
                    
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int [] dir : dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr >= 0 && nc >= 0 && nr < m  && nc < n && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.add(new int[] {nr,nc});
                            }
                        }
                    }
                }
                 
            }
        }
      return count;  
    }
}


// Time Complexity : o(2mn)
// Space Complexity : o(mn) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 200
//Approach :  DFS 


class Solution {
        int[] dr= new int[]{-1,0,1,0};
        int[] dc= new int[]{0,1,0,-1};
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    public int numIslands(char[][] grid) {
    int count=0;
       
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    numIslandsDFS(grid,i,j);
                    count++;
                }
            }
            
        }
        
        return count;
    }
    
    
    
    public void numIslandsDFS(char[][] grid, int row, int col){
         for(int[] dir: dirs){
            int nr = dir[0]+row;
            int nc = dir[1]+col;
             
             if(isValid(grid,nr,nc) && grid[nr][nc]=='1'){
                grid[nr][nc]='0';
                numIslandsDFS(grid,nr,nc);
            }
        }
            
        }
    
    
    public boolean isValid(char[][] grid, int row, int col){

        if(row>=grid.length|| col>=grid[0].length || row<0 || col<0)
            return false;
        return true;
        
    }
}



