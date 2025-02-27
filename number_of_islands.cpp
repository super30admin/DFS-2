class Solution {
    public:
        int numIslands(vector<vector<char>>& grid) {
            int m = grid.size();
            int n = grid[0].size();
            int count = 0; 
            queue<pair<int, int>> q;
            vector<pair<int, int>> directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1'){
                        count++;
                        q.push({i,j});
                        grid[i][j] = '0'; 
                        while(!q.empty()){
                            auto[r,c] = q.front();
                            q.pop();
                            for(auto [dx, dy] : directions){
                                int newRow = r + dx;
                                int newCol = c + dy;
                                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                                grid[newRow][newCol] == '1'){
                                    q.push({newRow, newCol});
                                    grid[newRow][newCol] = '0';
                                }
                            }
                        }
                    }
                }
            }
            return count;
        }
    };