class Solution {
public:
    void DFS (vector<vector<char>>& grid, int i, int j) {
        grid[i][j] = '0';

        if (i-1 > -1 && grid[i-1][j] == '1') DFS(grid,i-1,j);
        if (i+1 < grid.size() && grid[i+1][j] == '1') DFS(grid,i+1,j);
        if (j-1 > -1 && grid[i][j-1] == '1') DFS(grid,i,j-1);
        if (j+1 < grid[0].size() && grid[i][j+1] == '1') DFS(grid,i,j+1);
        //extra 4 for diagonal, I could loop, but not necessary
       /* if (i-1 > -1 && j-1>-1 && grid[i-1][j-1] == '1') DFS(grid,i-1,j-1);
        if (i+1 < grid.size() && j+1<grid.size() && grid[i+1][j+1] == '1') DFS(grid,i+1,j+1);
        if (j-1 > -1 && i+1<grid.size() && grid[i+1][j-1] == '1') DFS(grid,i+1,j-1);
        if (j+1 < grid[0].size() && i-1>-1 && grid[i][j+1] == '1') DFS(grid,i-1,j+1);*/
    }

    int numIslands(vector<vector<char>>& grid) {
        int res = 0;
        for (int i = 0; i < grid.size(); ++i)
            for (int j = 0; j < grid[0].size(); ++j)
                if (grid[i][j] == '1') {
                    ++res;
                    DFS(grid,i,j);
                }

        return res;
    }
};
