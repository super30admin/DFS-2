// Time Complexity : O((m*n))
// Space Complexity : O(min(mn))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <vector>
class Solution {
public:
    vector<vector<int>> dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    void dfs(vector<vector<char>>& grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j>=n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int k=0; k<4; k++){
            int x = i + dirs[k][0];
            int y = j + dirs[k][1];
            dfs(grid, x, y, m, n);
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        int ans=0;
        for (int i =0; i<grid.size(); i++) {
            for (int j=0; j< grid[0].size(); j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j, grid.size(), grid[0].size());
                    ans++;
                }
            }
        }
        return ans;
    }
};
