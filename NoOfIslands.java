// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class NoOfIslands {
    public int numIslands(char[][] grid) {
        int ans = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    ans+=1;
                    dodfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    
    private void dodfs(char[][] grid, int i, int j){
        if(i>=grid.length || j>= grid[0].length || i<0 || j<0){
            return;
        }
        if(grid[i][j]=='0')return;
        grid[i][j]='0';
        dodfs(grid,i-1,j);
        dodfs(grid,i+1,j);
        dodfs(grid,i,j-1);
        dodfs(grid,i,j+1);
    }
}


