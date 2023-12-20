class Solution {
    vector<vector<int>> dirs;
    int m,n;
public:
    int numIslands(vector<vector<char>>& grid) {

        this->dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        m = grid.size();
        n = grid[0].size();

        int count = 0;

        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }

    return count;
        
    }
    private:
    void dfs(vector<vector<char>>& grid, int i, int j)
    {

        grid[i][j] = '0';
        for(vector<int> dir: dirs)
        {

            int r = i + dir[0];
            int c = j + dir[1];

            if(r>= 0 && c>=0 && r<m && c < n && grid[r][c] == '1')
            {
                dfs(grid,r,c);
            }

        }
    }
};