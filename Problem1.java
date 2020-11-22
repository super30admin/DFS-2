// Time Complexity :O(m*n) -- we are looping into rows and columns
// Space Complexity  : O(1)
// Approach : DFS ( looked in leet code : running successfully on leet code)
// loop through the given char grid and find land i.e. 1 then there will be a chance of having the island.
// so search in all 4 directions to see if we find the land . 
// in dfs function , after recursively approaching all directions , still we dont find land then made the land to zero.
// in the main function , we make the counter (no of islands by 1)
// we repeat this process for all the elements in char grid array.


class Solution {
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {

     if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int cnt = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (grid[i][j] == '1') {
                    DFS (grid, i, j, m, n);
                    cnt++;
                }
        return cnt;
        
    }

public void DFS (char[][] grid, int i, int j, int m, int n) {
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
    grid[i][j] = '0';
    for (int[] dir : dirs)  DFS(grid, i + dir[0], j + dir[1], m, n); 
}
    
}
