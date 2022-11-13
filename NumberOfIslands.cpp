// Approach - BFS
// Time Complexity - O(m*n)
// Space Complexity - O(min(m, n))
// It runs on Leetcode!
// Problems Faced - No! 
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        queue<vector<int>> q;
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    q.push({i, j});
                    while(!q.empty()){
                            vector<int> currElem = q.front(); q.pop();
                            for(vector<int> dir : dirs){
                                int nr = currElem[0] + dir[0];
                                int nc = currElem[1] + dir[1];
                                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1'){
                                    grid[nr][nc] = '0';
                                    q.push({nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
};


// Approach - DFS
// Time Complexity - O(m*n)
// Space Complexity - O(m*n)) -> Will be 2*m*n in the worst case scenario.
// It runs on Leetcode!
// Problems Faced - No! 
class Solution {
    vector<vector<int>> dirs;
    private:
    void dfs(vector<vector<char>>& grid, int i, int j, int m, int n){
        // base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0')
            return;
        
        // logic
        grid[i][j] = '0';
        for(vector<int> dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(grid, nr, nc, m, n);
        }
    }
public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
};