// Time Complexity : O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//BFS
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.empty() || grid.size() == 0)
            return 0;
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        queue<vector<int>> q;
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.push({i,j});
                    grid[i][j] = '0';
                    while(!q.empty()){
                        vector<int> curr = q.front();
                        q.pop();
                        for(vector<int> dir : dirs){
                            int r = dir[0]+curr[0];
                            int c = dir[1] + curr[1];
                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == '1'){
                                q.push({r,c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
};

// Time Complexity : O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//DFS
class Solution {
public:
    int m,n;
    vector<vector<int>> dirs;
    int numIslands(vector<vector<char>>& grid) {
        if(grid.empty() || grid.size() == 0)
            return 0;
        m = grid.size();
        n = grid[0].size();
        dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    void dfs(vector<vector<char>>& grid, int row, int col){
        //base
        if(row<0 || row>=m || col<0 || col>=n || grid[row][col] != '1')
            return;
        //logic
        grid[row][col] = '0';
        for(vector<int> dir : dirs){
            int r = dir[0] + row;
            int c = dir[1] + col;
            dfs(grid, r, c);
        }
    }
};
