200. Number of Islands

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        if(m == 0) return 0;
        int count = 0;
        queue<pair<int, int>> q;
        int dirs[4][2] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    q.push({i,j});
                    count++;
                    grid[i][j] = '0';
                    while(!q.empty()) {
                        int cr = q.front().first;
                        int cc = q.front().second;
                        q.pop();
                        for(auto &dir: dirs) {
                            int nr = cr + dir[0];
                            int nc = cc + dir[1];
                            if(nr >=0 && nc >=0 && nr <m && nc <n && (grid[nr][nc] == '1')) {
                                q.push({nr,nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;

    }
};
