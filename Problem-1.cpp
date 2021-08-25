/*
Time Complexity = O(M*N)
Space Complexity = O(M*N)
where M is the number of rows and N is the number of coloumns in the matrix.
*/
class Solution {
public:
    int m,n;
    void dfs(vector<vector<char>>& grid, int i, int j)
    {
        //base
        if(i<0 || i==m || j<0 || j==n || grid[i][j]=='0')
            return;
        
        //logic
        grid[i][j]='0';
        dfs(grid, i, j+1);
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
    int numIslands(vector<vector<char>>& grid) {
        int i,j;
        m = grid.size();
        n = grid[0].size();
        int count=0;
        for(i=0;i<m;i++)
            for(j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {   count++;
                    dfs(grid, i, j);   
                }
            }
        return count;
    }
};
