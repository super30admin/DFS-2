//time: O(m*n)
//space: O(m*n)
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int result = 0;
        vector<vector<int>> dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        // right, left, down, up
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = 'v';
                    queue<pair<int,int>> q;
                    q.push(make_pair(i,j));
                    while(!q.empty()) {
                        pair<int,int> curr = q.front();
                        q.pop();
                        for(int k = 0; k < dirs.size(); k++) {
                            int x = curr.first + dirs[k][0];
                            int y = curr.second + dirs[k][1];
                            if(x >= 0 && y >= 0 && x < m && y < n) {
                                // right, left, down, up
                                if(grid[x][y] == '1') {
                                    grid[x][y] = 'v';
                                    q.push(make_pair(x,y));
                                }
                            }
                        }
                        
                    }
                    result++;
                }
            }
        }
        return result;
    }
};