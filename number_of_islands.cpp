// Time Complexity : O(m*n)
// Space Complexity :  O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        
        int i, j;
        int r,c;
        int visited[m][n];
        int counter = 0;
        queue<pair<int,int>> q_init;
        
        for(i = 0; i < m; i++)
        {
            for(j = 0; j < n; j++)
            {
                visited[i][j] = 0;
                
                if(grid[i][j] == '1')
                {
                    q_init.push(pair(i,j));
                }
            }
        }
        
        pair<int,int> root;
        
        while(!q_init.empty())
        {
            root = q_init.front(); q_init.pop();
            
            if(visited[root.first][root.second] == 1)
                continue;
            
            queue<pair<int,int>> q_temp;
            
            q_temp.push(root);
            pair<int,int> temp;
            
            vector<pair<int,int>> dir;
            
            dir.push_back(pair(-1,0));
            dir.push_back(pair(1,0));
            dir.push_back(pair(0,-1));
            dir.push_back(pair(0,1));
            
            while(!q_temp.empty())
            {
                temp = q_temp.front(); q_temp.pop();
                
                visited[temp.first][temp.second] = 1;
                
                for(int k = 0; k < dir.size(); k++)
                {
                    r = temp.first + dir[k].first;
                    c = temp.second + dir[k].second;
                    
                    if(r >= 0 && c >= 0 && r < m && c < n)
                    {
                        if(visited[r][c] == 0 && grid[r][c] == '1')
                        {
                            q_temp.push(pair(r,c));
                        }
                    }
                }
            }
            
            counter++;
        }
     
        return counter;
    }
};