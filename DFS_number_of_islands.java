// Time Complexity : O(m*n), where m is the number of rows and n is the number of columns in the grid (traversing all the cells)
// Space Complexity : O(m*n), where m is the number of rows and n is the number of columns in the grid (space for the recursive stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain english
//1. Keep traversing over the entire grid and once you find 1(land) make that cell 0 and call DFS on that cell.
//2. In the DFS function explore all 4-neighbours of the cell and if you find any neighbour to be 1(land) again make it 0
        //and recursively call DFS on it
//3. Increment the count by 1, after one complete dfs is finished (That is you found 1 island). Keep doing this till the traversal of the 
        //complete grid is done

// Your code here along with comments explaining your approach

class Solution {
    int count;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        //rows and columns in the grid
        m = grid.length;
        n = grid[0].length;
        count = 0;
    
        //traverse the entire grid to check for land(1)
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    //call dfs
                    dfs(grid, i, j);
                    //increase the count by 1 once the dfs is resolved
                    count++;
                }
            }
        }
        //return the count of islands
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j){
        //base
        
        //logic
        //create a directions array to explore all the neighbours of a cell
        int[][] dirs = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            //call dfs if you find a neighbour equal to 1 and make that neighbour 0
            if(r>=0 && r<m && c>=0 && c<n && grid[r][ c] =='1'){
                grid[r][c] ='0';
                dfs(grid, r, c);
            }
        }
    }
}