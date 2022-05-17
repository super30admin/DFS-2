// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Maintain a count variable. Iterate over a i/p grid, call dfs operation when cell with the value '1' is found.
 * In DFS method change the cell values from 1 to 0 to indicate it is visited. At the end return count variable.   
 */

class Solution {
public:
    vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;
    int numIslands(vector<vector<char>>& grid) {
        if (grid.size() == 0)
        {
            return 0;
        }
        
        m = grid.size();
        n = grid[0].size();
        
        int island = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    island++;
                    dfs(grid, i, j);        
                }
            }
        }
        return island;
    }
    
    void dfs(vector<vector<char>>& grid, int row, int col)
    {
        grid[row][col] = '0';     
        for (auto d : dir)
        {
            int new_r = row + d[0];
            int new_c = col + d[1];
                
            if (new_r >= 0 && new_r < m && new_c >= 0 && new_c < n && grid[new_r][new_c] == '1')
            {
                dfs(grid, new_r, new_c);
            }
        }
    }
};