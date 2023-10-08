class Solution {
public:
vector<vector<char>> grid;
vector<vector<int>> dirs={{0,1},{1,0},{0,-1},{-1,0}};
vector<vector<bool>> seen;
int count=0;
int n, m;
    int numIslands(vector<vector<char>>& grid) {
        this->grid=grid;
         n=grid.size();
         m=grid[0].size();

        seen=vector(n,vector<bool>(m,false));

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' and !seen[i][j])
                {
                    seen[i][j]=true;
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int r, int c)
    {
        for(vector<int> d:dirs)
        {
            int newR=r+d[0];
            int newC=c+d[1];
            if(valid(newR, newC) and !seen[newR][newC])
            {
                seen[newR][newC]=true;
                dfs(newR, newC);
            }
        }
    }
    bool valid(int r, int c)
    {
        return r>=0 and c>=0 and r<n and c<m and grid[r][c]=='1';
    }
};