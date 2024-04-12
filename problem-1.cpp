// 200. Number of Islands
// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<vector<int>> dir = {{0,1},{0,-1},{1,0},{-1,0}};
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size(), n = grid[0].size(), count = 0;
        vector<vector<int>> visited(m, vector<int>(n,0));
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == '1' && visited[i][j] == 0)
                {
                    visited[i][j] = 1;
                    dfs(grid, visited, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(vector<vector<char>>& grid, vector<vector<int>>& visited, int r, int c, int m, int n)
    {
        int nr, nc;
        for(int i = 0; i < 4; i++)
        {
            nr = r + dir[i][0];
            nc = c + dir[i][1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n)
            {
                if(grid[nr][nc] == '1' && visited[nr][nc] == 0)
                {
                    visited[nr][nc] = 1;
                    dfs(grid, visited, nr, nc, m, n);
                }
            }
        }
        return;
    }
};
