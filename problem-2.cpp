// https://leetcode.com/problems/number-of-islands/description/
// Time Complexity : O(m*n)
// Space Complexity : O(min (m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//BFS
class Solution {
    public:
        int numIslands(vector<vector<char>>& grid) {
            int n = grid.size();
            int m = grid[0].size();
            vector<pair<int,int>> dir = {{0,1}, {0, -1}, {1,0}, {-1,0}};
            queue<pair<int,int>> q;
            int count = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(grid[i][j] == '1'){
                        q.push({i,j});
                        grid[i][j] = '0';
                        count++;
                        while(!q.empty()){
                            auto [x,y] = q.front();
                            q.pop();
                            for(auto [dx,dy]:dir){
                                int a = x + dx;
                                int b = y + dy;
                                if(a >= 0 && a < n && b >= 0 && b < m && grid[a][b] == '1'){
                                    q.push({a,b});
                                    grid[a][b] = '0';
                                }
                            }
                        }
                    }
                }
            }
            return count;
        }
    };

// DFS
// Time Complexity : O(m*n)
// Space Complexity : O(min (m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public:
        void dfs(vector<vector<char>>& grid, int n, int m, vector<pair<int,int>> dir){
            if(n < 0 || n == grid.size() || m < 0 || m == grid[0].size() || grid[n][m] == '0'){
                return;
            }
            grid[n][m]='0';
            for(auto [x,y]:dir){
                int dx = x+n;
                int dy = y+m;
                dfs(grid, dx, dy, dir);
            }
        }
        int numIslands(vector<vector<char>>& grid) {
            int n = grid.size();
            int m = grid[0].size();
            vector<pair<int,int>> dir = {{0,1}, {0, -1}, {1,0}, {-1,0}};
            int count = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(grid[i][j] == '1'){
                        count++;
                        dfs(grid, i, j, dir);
                    }
                }
            }
            return count;
        }
    };
