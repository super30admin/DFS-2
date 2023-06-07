// TC:O(m*n)
// SC:O(m*n)

// Approach:
// Here DFS/BFS can be used,
// Traversing the 2D matrix when we encounter '1' trigger the DFS/BFS , by doing BFS/DFS make all the 
// connected elements to 0 to mark visited ,Number of dfs/bfs calls is the answer.

class Solution {
public:
    vector<vector<int>>dirs={{-1,0},{1,0},{0,-1},{0,1}};

    int numIslands(vector<vector<char>>& grid) {
        int count=0;
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid[0].size();j++)
            {
                    if(grid[i][j]=='1')
                    {
                        dfs(grid,i,j);
                        count++;
                    }
            }
        }
        return count;
    }

    void dfs(vector<vector<char>>& grid, int i,int j)
    {
        if(i<0 || j<0 || i>=grid.size() || j>=grid[0].size() || grid[i][j]=='0')
        return;

        if(grid[i][j]=='1')
         grid[i][j]='0';

        for(int k=0;k<dirs.size();k++)
        {
            int nr = i+dirs[k][0];
            int nc = j+dirs[k][1];

            dfs(grid,nr,nc);
        }
      
    }
};