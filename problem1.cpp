class Solution {
public:
    int m,n;
    int numIslands(vector<vector<char>>& grid) {
        
        
        // bfs ;
        
       if(grid.size() == 0) return 0;
        
        m = grid.size();
        n = grid[0].size();
        
        //direction
        vector<vector<int>> dirs{{0,-1},{0,1},{-1,0},{1,0}}; //R,L,T,B
        queue<vector<int>> q;
      
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                
                if(grid[i][j] == '1') {
                    
                    q.push({i,j});
                    count++;
               while(!q.empty()){
                int size = q.size();
                vector<int> mr = q.front();
               q.pop();
            for(auto dir : dirs) {
                int nr = dir[0] + mr[0];
                int nc = dir[1] + mr[1];
                
     if(nr>=0 && nr < m && nc>=0 && nc<n && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    q.push({nr,nc});
                }
            }
           
          }
            }
            }
        }

        
       return count; 
    }
};