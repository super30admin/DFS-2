// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 200: Number of Islands
// Approach: DFS
// TC: O(m * n)
// SC: O(m * n)

class Solution
{
public:
    int m, n;
    vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U D L R

    int numIslands(vector<vector<char>> &grid)
    {

        // Base Case
        if (grid.empty())
        {
            return 0;
        }

        m = grid.size();
        n = grid[0].size();
        int count = 0;

        // Call DFS on all elements with 1
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    void dfs(vector<vector<char>> &grid, int row, int col)
    {

        // Base case
        if (row < 0 || row >= m || col < 0 || col >= n ||
            grid[row][col] != '1')
        {
            return;
        }

        // Mark the cell as visited
        grid[row][col] = '2';

        // Explore all four directions
        for (auto &dir : dirs)
        {
            int nr = row + dir[0];
            int nc = col + dir[1];
            dfs(grid, nr, nc);
        }
    }
};
