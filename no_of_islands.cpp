//We iterate thorugh the matrix.
        //We apply dfs/bfs on all elements equal to 1 and either recursively call dfs on its neighbours(equal to 1) in the case of dfs or add its neighbours(equal to 1) to the queue for bfs.
        //We must also change all the neighbours operated on to 0, so that we dont visit again.
class Solution {
    vector<vector<int>>dirs={{0,1},{1,0},{-1,0},{0,-1}};
public:
    /*int numIslands(vector<vector<char>>& grid) {
        if(grid.empty())
            return 0;
        vector<vector<int>>dirs={{0,1},{1,0},{-1,0},{0,-1}};
        int count=0;
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid[0].size();j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    queue<vector<int>>q;
                    grid[i][j]='0';
                    q.push({i,j});
                    while(!q.empty())
                    {
                        vector<int>curr=q.front();
                        q.pop();
                        for(auto dir:dirs)
                        {
                            int r=curr[0]+dir[0];
                            int c=curr[1]+dir[1];
                            if(r>=0 && r<grid.size() && c>=0 && c<grid[0].size() && grid[r][c]=='1')
                            {
                                q.push({r,c});
                                grid[r][c]='0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }*/
    int numIslands(vector<vector<char>>& grid) {
        if(grid.empty())
            return 0;
        int count=0;
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid[0].size();j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    grid[i][j]=='0';
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    void dfs(vector<vector<char>>& grid,int i,int j)
    {
        if(i<0 || i>=grid.size() || j<0 || j>=grid[0].size() || grid[i][j]=='0')
            return;
        grid[i][j]='0';
        for(auto dir:dirs)
        {
            int r=i+dir[0];
            int c=j+dir[1];
            dfs(grid,r,c);
        }
    }
};