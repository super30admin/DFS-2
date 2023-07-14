// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : yes

#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    int m;
    int n;

public:
    int numIslands(vector<vector<char>>& grid) {
        // Edge case
        m = grid.size();
        if (grid.empty() || m == 0)
            return 0;

        n = grid[0].size();
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

private:
    void dfs(vector<vector<char>>& grid, int i, int j) {
        // Base case
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0')
            return;

        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        grid[i][j] = '0';

        for (const auto& dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c);
        }
    }
};
