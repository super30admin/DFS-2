/*
 ? Problem: Number of Islands
 * Time Complexity : O(n*m)
 * Space Complexity : O(n*m)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>
#include <queue>

class Solution {
private:
    void bfs(int row, int col, std::vector<std::vector<char>>& grid, std::vector<std::vector<int>>& visited) {
        visited[row][col] = 1;
        std::queue<std::pair<int, int>> q;
        q.push({row, col});
        int n = grid.size();
        int m = grid[0].size();


        while(!q.empty()) {
            std::pair<int, int> current = q.front();
            q.pop();

            std::vector<std::vector<int>> directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for(auto dir : directions) {
                int nrow = current.first + dir[0];
                int ncol = current.second + dir[1];
                if(nrow < n && ncol < m && nrow >= 0 && ncol >= 0 && grid[nrow][ncol] == '1'
                && !visited[nrow][ncol]) {
                    visited[nrow][ncol] = 1;
                    q.push({nrow, ncol});
                }
            }
        }
    }
public:
    int numIslands(std::vector<std::vector<char>>& grid) {
        if(grid.empty()) return 0;

        int row = grid.size();
        int col = grid[0].size();

        int islands = 0;
        std::vector<std::vector<int>> visited(row, std::vector<int>(col, 0));

        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if(!visited[r][c] && grid[r][c] == '1') {
                    islands++;
                    bfs(r, c, grid, visited);
                }
            }
        }
        return islands;
    }
};