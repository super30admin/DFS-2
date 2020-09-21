    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/number-of-islands/
    Time Complexity for operators : o(n*m)
    Extra Space Complexity for operators : o(n*m) ... recursive stack
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach same like basic approach: Recursive DFS.
                              
            Recursive approach :-
                    A. Two for loops,will go thru each element in matrix. If it has value '1' then we will
                       call dfs. At the end, we will increment the result counter.
                    B. In DFS, first we will make that grid as '0'. Then, we will traverse in all four directions.
                    C. If calcualted r and c are valie and it has '1' value in grid then again call dfs with those
                       co-ordinates.
                    D. Once all the directions got explored, then two for loops will process for next '1'.
                    E. In th end, return result.

       */


class noOfIslands {
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int result = 0;
        // time complexity n*m
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    result += 1;
                }
            }
        }  
        return result;
    }
    
    
    int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    
    private void dfs(char[][] grid, int i, int j){
            
        grid[i][j] = '0';
        
        for(int dirs[] : directions){
            
            int r = i + dirs[0];
            int c = j + dirs[1];
            
            if(r>=0 && r< grid.length && c >=0 && c < grid[0].length && grid[r][c] == '1'){
                // space complexity n*m  recursive stack
                dfs(grid,r,c);
            }
        }
    }
}