class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        vector<vector<bool>> visited(grid.size(), vector<bool>(grid[0].size(), false)); 
        int count = 0;
        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid[0].size(); j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    makeIsland(grid, visited, i, j);
                }
            }
        }
        return count; 
    }

    void makeIsland(vector<vector<char>>& grid, vector<vector<bool>>& visited, int r, int c) {
        if(r < 0 || r >= grid.size() || c < 0 || c > grid[0].size()) return; 
        if(!visited[r][c] && grid[r][c] == '1') {
            visited[r][c] = true;
            makeIsland(grid, visited, r+1, c);
            makeIsland(grid, visited, r-1, c);
            makeIsland(grid, visited, r, c+1);
            makeIsland(grid, visited, r, c-1);
        } else return;
    }
};