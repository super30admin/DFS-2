// Time Complexity : O(n) space complexity : O(n)

class Solution {
public:
    vector<vector<int>> dir = {{-1,0}, {0,-1}, {1,0}, {0, 1}};
    void helper(vector<vector<char>>& grid, int row, int col) {
        grid[row][col] = '0';
        for(auto &x : dir) {
            int newRow = row + x[0];
            int newCol = col + x[1];
            if(newRow >= 0 && newRow < grid.size() && newCol >= 0 && newCol < grid[0].size() && grid[newRow][newCol] == '1') {
                helper(grid, newRow, newCol);
            }
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size()==0) return 0;
        int rows = grid.size();
        int cols = grid[0].size();
        int counter = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == '1') {
                    ++counter;
                    helper(grid, i,j );
                }
            }
        }
        return counter;
    }
};