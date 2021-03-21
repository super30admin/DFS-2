//TC: O(m*n) where m, n are number of rows and columns respectively
//SC: O(m*n) 

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) { 
        
        //dfs stack
        
        if(grid.empty() || grid[0].empty())
            return 0;
        
        stack<pair<int, int>> s;
        int dr[] = {1, -1, 0, 0};
        int dc[] = {0, 0, 1, -1};
        
        int numIs = 0;
        

        //implementing iterative dfs using stacks
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid[0].size(); j++){
                
                if(grid[i][j] == '1')
                {
                    numIs++;
                    s.push({i, j});
                    while(!s.empty()){
                        auto pr = s.top();
                        s.pop();
                        int cur_r = pr.first;
                        int cur_c = pr.second;
                        grid[cur_r][cur_c] = '0';

                        for(int k = 0; k<4; k++){
                            int nr = cur_r + dr[k];
                            int nc = cur_c + dc[k];
                        
                            if(nr >= 0 && nr<grid.size() && nc >=0 && nc<grid[0].size() && grid[nr][nc] == '1'){
                            s.push({nr, nc});
                            grid[nr][nc] = '0';
                        }
                    }                    
                }
                
            }
            }
        }
        
        return numIs;
        
        
        
        
        
        
        //dfs recursive
        
        /*if(grid.empty() || grid[0].empty())
            return 0;
        
        int numIs = 0;
        
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid[0].size(); j++){
                if(grid[i][j] == '1')
                    numIs += dfs(i, j, grid);
            }
        }
        
        
        return numIs;*/       
        
        
        
        
        //bfs
        
        /*if(grid.empty() || grid[0].empty())
            return 0;
        
        queue<pair<int, int>> q;
        int dr[] = {0, 0, 1, -1};
        int dc[] = {1, -1, 0, 0};
        
        int numIs = 0;
        
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid[0].size(); j++){
                
                if(grid[i][j] == '1')
                {
                    numIs++;
                    q.push({i, j});
                    while(!q.empty()){
                        auto pr = q.front();
                        q.pop();
                        int cur_r = pr.first;
                        int cur_c = pr.second;
                        grid[cur_r][cur_c] = '0';

                        for(int k = 0; k<4; k++){
                            int nr = cur_r + dr[k];
                            int nc = cur_c + dc[k];
                        
                            if(nr >= 0 && nr<grid.size() && nc >=0 && nc<grid[0].size() && grid[nr][nc] == '1'){
                            q.push({nr, nc});
                            grid[nr][nc] = '0';
                        }
                    }                    
                }
                
            }
            }
        }
        
        return numIs;*/
    }
    
    
    
    /*int dfs(int i, int j, vector<vector<char>>& grid){
        
        if(i >= grid.size() || i<0 || j >= grid[i].size() || j<0 || grid[i][j] == '0')
            return 0;
        
        grid[i][j] = '0';
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
        
        return 1;
        
        
    }*/
    
};