// Time Complexity : O(m*n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we see that there are connencted components and decide to use bfs/dfs. we need to push r,c into queue and do bfs. but we observe that 
// some nodes might get missed, so we traverse over m*n to cover all nodes. To avoid repeated visit across nodes, we manipulate the values
// int the grid after we reach once.



class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.empty() || grid.size()==0) return 0;
        int m = grid.size();
        int n = grid[0].size();
        queue<pair<int,int>>q;
        vector<pair<int,int>>dir = {{-1,0},{1,0},{0,-1},{0,1}}; // U D L R
        int count=0;
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    grid[i][j] = '2';
                    q.push({i,j});
                    while(!q.empty())
                    {
                        auto curr = q.front();q.pop();
                        for(auto d: dir)
                        {
                            int nr = curr.first + d.first;
                            int nc = curr.second + d.second;
                            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1')
                            {
                                q.push({nr,nc});
                                grid[nr][nc] = '2';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
};