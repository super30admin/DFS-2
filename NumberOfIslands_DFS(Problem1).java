/* 
DFS Approach
Time complexity: O(mn)
Algorithm:
    - Traverse through the 2D array, if 1 is found. Perform DFS on that node. Increase the count
    - Keep performing DFS on the nearby nodes of the original node if 1 is found and set them to 0.
    - Return count
Did the solution run on leetcode: Yes
Any problems faced: No

*/

class Solution {
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        
        m = grid.length;
       
        if(m==0 || grid==null){
            return 0;
        }
          n = grid[0].length;
        int count=0;
       
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0')return;
         int dirs[][] = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        grid[i][j] = '0';
        for(int[] dir: dirs){
            int r = dir[0]+i;
            int c = dir[1]+j;
            dfs(grid,r,c);
        }
    }
}