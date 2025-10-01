// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Start DFS from every 1 and maintain a count
// Once we start DFS, convert every 1 connected to the starting cell into a 0 (connected components)
// Return the count

class Solution {
private:
    vector<vector<int>> dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    void dfs(vector<vector<char>>& grid, int r, int c, int m, int n) {
        for(auto& dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                grid[nr][nc] = '0';
                dfs(grid, nr, nc, m, n);
            }
        }
    }
public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size(); int n = grid[0].size();
        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return count;
    }
};