


// Your code here along with comments explaining your approach
//Have to count total number of islands,use dfs to find where island is present ie 1 from the root and count ina ll directions 
//upon finding 0 ,the traversing ends and count is incremented.


// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int countislands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    countislands+=dfs(grid,i,j);
                }
            }
        }
        return countislands;
    }
   public int dfs(char[][] grid,int i,int j){
        if(i < 0 || i>=grid.length ||j< 0 || j >= grid[i].length || grid[i][j] == '0'){
            return 0;
        }
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        return 1;
    }
    
       
        
        
    
}