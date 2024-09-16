// Time Complexity : O(M*N) traverse all elements worst case
// Space Complexity : O(M*N) because of recursive call stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve before class


// Your code here along with comments explaining your approach
//Used DFS

class Solution {
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    
    public int numIslands(char[][] grid) {
        // base cases
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // dimensions of matrix
        int m = grid.length, n = grid[0].length;
        // DFS approach, each call to DFS-VISIT covers one Island.
        int nIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if it is part of island, we want to visit it.
                // Also, increment count.
                if (grid[i][j] == '1') {
                    dfsVisit(grid, m, n, i, j);
                    nIslands++;
                }
            }
        }

        return nIslands;
    } 
    
    private void dfsVisit(char[][] grid, int m, int n, int row, int col){
    	//whenever a node is visisted mark it with a different number
        grid[row][col] = '2';
        
        //traverse it's neighbours
        for(int i=0; i<4; i++){
            int x = row + dx[i];
            int y = col + dy[i];
            
            //check for within bounds and for nodes which are '1'
            if(isValid(m, n, x , y) && grid[x][y] == '1'){
                dfsVisit(grid, m, n, x, y);
            }
        }
    }
    
    private boolean isValid(int m, int n, int x, int y){
        return x>=0 && x<m && y>=0 && y<n;
    }
}