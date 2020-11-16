// Using BFS
// Time complexity is O(m*n) - m = #rows; n = #columns
// Space complexity is O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size() == 0) return 0;
        int nIslands = 0;
        
        int rows = grid.size();
        int cols = grid[0].size();
        queue<vector<int>> q;
        vector<vector<int>> directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        vector<int> currCell;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = '2';
                    q.push({i, j});
                    
                    while(!q.empty()) {
                        currCell = q.front();
                        q.pop();
                        for(auto dir : directions) {
                            int neighRow = currCell[0] + dir[0];
                            int neighCol = currCell[1] + dir[1];
                            
                            if(neighRow >= 0 && neighRow < rows 
                               && neighCol >= 0 && neighCol < cols 
                               && grid[neighRow][neighCol] == '1') {
                                grid[neighRow][neighCol] = '2';
                                q.push({neighRow, neighCol});
                            }
                        }
                    }
                    nIslands++;
                }
            }
        }
        return nIslands;
    }
};


// Using DFS
// Time complexity is O(m*n) - m = #rows; n = #columns
// Space complexity is O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    vector<vector<int>> directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    void dfs(vector<vector<char>>& grid, int row, int col) {
        // base
        if(row < 0 || row >= grid.size() 
          || col < 0 || col >= grid[0].size() 
          || grid[row][col] == '0') return;
        grid[row][col] = '0';
        
        
        for(auto dir : directions) {
            int neighRow = row + dir[0];
            int neighCol = col + dir[1];
            dfs(grid, neighRow, neighCol);
        }
    }
    
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size() == 0) return 0;
        int nIslands = 0;
        
        int rows = grid.size();
        int cols = grid[0].size();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    nIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return nIslands;
    }
};
