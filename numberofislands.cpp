//Time complexity : O(m * n)
//Space complexity : O(min(m,n))

//Approach :
            // Get the first occurence of 1
            // Start bfs from this occurence
            // Turn every 1 to 0
            // Once this bfs reaches end, find next occurence of 1
            // For every 1, increment the count of islands

class Solution {
public:
    int m , n;
    vector<vector<int>> dirs;
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size() == 0 || grid[0].size() == 0)
            return 0;
        
        dirs = {{ 0 , 1 } , { 0 , -1 }, { 1 , 0 }, { -1 , 0 }};
        m = grid.size();
        n = grid[0].size();
        int result = 0;
        
        queue<vector<int>> q;
        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(grid[i][j] == '1')
                {
                    result++;
                    grid[i][j] = '0';
                    q.push({i , j});
                    while(!q.empty())
                    {
                        vector<int> curr = q.front();
                        q.pop();
                        for(auto dir : dirs)
                        {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr >=0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1')
                            {
                                grid[nr][nc] = '0';
                                q.push({nr,nc});
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
//     void dfs(vector<vector<char>>& grid, int r , int c)
//     {
//         if(r < 0 || c < 0 || r == m || c == n || grid[r][c] == '0')
//             return;
        
//         grid[r][c] = '0';
//         for(auto dir : dirs)
//         {
//             int nr = r + dir[0];
//             int nc = c + dir[1];
            
//             dfs(grid, nr , nc);
//         }
//     }
};