/*
Time: O(N)
Space: O(N)

Run DFS on the unvisited nodes.
Every vertices covered by one dfs belong to one island.
No. of dfs needed to cover all vertices = no. of island
*/
class Solution {
public:
    int rows, cols;
    vector<vector<char>> grid, vis;
    void dfs(int i, int j){
      if(i==rows || j == cols || i<0 || j<0)  return;
      if(vis[i][j] || grid[i][j]=='0')  return;

      vis[i][j] = 1;
      dfs(i+1,j);
      dfs(i-1,j);
      dfs(i,j+1);
      dfs(i,j-1);
    }

    int numIslands(vector<vector<char>>& grid) {
        this->grid = grid;
        rows = grid.size(), cols = grid[0].size();
        vis = vector(rows, vector<char>(cols, 0));        
        int island = 0;

        for(int i=0;i<rows;i++){
          for(int j=0;j<cols;j++){
            if(!vis[i][j] && grid[i][j]=='1'){
              island++;
              dfs(i,j);
            }
          }
        }

        return island;
    }
};
