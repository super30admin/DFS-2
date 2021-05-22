// Time Complexity :O(m*n) m->rows ; n->coloumns
// Space Complexity : O(min(m,n))  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int count = 0;
    int dirs[4][2] = {{-1,0},{1,0},{0,1},{0,-1}};
public:
    int numIslands(vector<vector<char>>& grid) {
        //BFS
        queue<pair<int,int>> q;
        pair<int,int> curr;
        for(int i = 0; i<grid.size(); i++){
            for(int j =0; j<grid[0].size();j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.push(make_pair(i,j));
                    while(!q.empty()){
                        curr = q.front();
                        q.pop();
                        //grid[curr.first][curr.second] = '0';
                        for(auto dir : dirs){
                            int r = curr.first + dir[0];
                            int c = curr.second + dir[1];
                            if(r >= 0 && r < grid.size() && c >= 0 
                            && c < grid[0].size() && grid[r][c] == '1'){
                                grid[r][c] = '0';
                                q.push({r,c});
                            }
                        }    
                    }
                }
            }
        }
        return count;
    }
    void dfs(vector<vector<char>>& grid, int i,int j){
        //base
        if(i < 0 || i == grid.size() || j < 0 
           || j == grid[0].size() || grid[i][j] != '1') return;
        //logic
        grid[i][j] = '0';
        for(auto dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid,r,c);
        }
    }
};