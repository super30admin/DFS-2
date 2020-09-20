//T: O(m*n)
//S: O(m*n)
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        vector<vector<int>> dirs = {{0,-1}, {0,1}, {-1,0}, {1,0}};
        int cnt = 0;
        queue<pair<int, int>> qu;
       for(int i=0; i<grid.size();i++){
           for(int j=0; j<grid[i].size(); j++){
               if(grid[i][j] == '1'){
                   qu.push({i,j});
                    while(!qu.empty()){
                        pair<int, int> x = qu.front(); qu.pop();

                        for(auto dir: dirs){
                            int r = dir[0]+x.first;
                            int c = dir[1]+x.second;

                            if(r >=0 && r<grid.size() && c>=0 && c<grid[r].size() && grid[r][c] == '1'){
                                qu.push({r,c});
                                grid[r][c] = '0';
                            }
                        }

                    }
                   cnt+=1;
               }
           }
        }
        return cnt;
    }
};