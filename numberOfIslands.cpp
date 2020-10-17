//time complexity:O(m*n)
//space complexity:O(m*n)
//executed on leetcode: yes
//approach:using dfs recursion
//any issues faced? no

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size()==0)
            return 0;
        int numi=0;
        for(int i=0; i<grid.size(); i++)
        {
            for(int j=0; j<grid[0].size(); j++)
            {
                if(grid[i][j]=='1')
                {
                    numi=numi+dfs(grid,i,j);
                    
                }
            }
        }
        return numi;
    }
    int dfs(vector<vector<char>>& grid, int i, int j)
    {
        if(i<0 || j<0 || i==grid.size() || j==grid[0].size() || grid[i][j]=='0')
            return 0;
        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        return 1;
    }
};