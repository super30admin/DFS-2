//Time complexity: O(n) - generally, every value is visited at max twice, so 2n. But asymptotically 'n'. 
//Space complexity: O(n)
//Executed on leetcode

class Solution {
    int len = -1, width = -1;
    public int numIslands(char[][] grid) {
        int result=0;
        len=grid.length;
        if(len==0)
            return 0;
        width=grid[0].length;int i=0, j=0;
        
        while(i<len && j<width)     //if the grid value is 1 moving till the next values are zero and changing value to 0 if it is 1.
        {
           
            if(grid[i][j]=='1')     //Once all the connected values are changed to 0. increment the number of islands value by 1.
            {
                dfs(grid,i,j);
                result++;       //Repeate the process untill no more 1's are available in the grid.
            }            
            j++;
            if(j==width)
            {
                j=0;
                i++;
            }
            
        }
        return result;
        
    }
    void dfs(char[][] grid, int r, int c) {
    /*int nr = grid.length;
    int nc = grid[0].length;

    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
      return;
    }*/

    grid[r][c] = '0';
    if(r-1>=0 && grid[r-1][c] != '0')dfs(grid, r - 1, c);
    if(r+1<len && grid[r+1][c] != '0')dfs(grid, r + 1, c);
    if(c-1>=0 && grid[r][c-1]!='0')dfs(grid, r, c - 1);
    if(c+1<width && grid[r][c+1]!='0')dfs(grid, r, c + 1);
  }
}