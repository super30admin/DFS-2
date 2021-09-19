// Time Complexity: As we are maintaining visited by updating the 1 to 0 on first dfs itself, it is not explored in any further traversal O(m*n)
// Space Complexity: Though there is no additional datastructure used, recursion stack uses O(m*n) space else it is O(1)
// Did you complete it on leetcode: Yes
// Any problems faced: found little difficulty in understanding where to exactly apply dfs

// Write your approach:
// Idea here is to traverse each cell and apply dfs in optimal way, where if a 1 is found,
// we explore that cells neighbours and assign current cell value to 0
// so that it is not explored through any other way.
// Recursion marks all neighbouring 1s 0 as well, once stack is emptied,
// we increase island count with 1. We keep exploring any following 1 and increasing count
// final count is returned.
class Solution {
    int m; int n;
    int[][] dirs = {{1,0}, {-1,0}, {0,-1}, {0,1}};
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        m = grid.length;
        if(m==0) return 0;
        n = grid[0].length;
        int islandCount = 0;
        for(int i=0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j]=='1') {
                    helper(grid,i,j);
                    ++islandCount;
                }
            }
        }
        return islandCount;
    }
    
    public void helper(char[][] grid, int i, int j) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!='1') return;
        grid[i][j] = '0';
        for(int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            helper(grid, r, c);
        }
    }
}