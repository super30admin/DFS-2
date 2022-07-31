class Solution {
public:
    //Time complexity :O(M×N) where M is the number of rows and N is the number of columns.

//Space complexity : O(M×N) in case that the grid map is filled with lands where DFS goes  M×N deep.
       void dfs(vector<vector<char>>& grid,int i,int j){
            if(i<0||j<0||i>=grid.size()||j>=grid[0].size()||grid[i][j]!='1')return;
            if(grid[i][j]=='2' ||grid[i][j]=='0') return;
            grid[i][j]='2';
            
       //      int dx[4]={-1,0,0,1};
       //       int dy[4]={0,1,-1,0};
       //      for(int k=0;k<4;i++){
       //          int nx=i+dx[i];
       //          int ny=j+dy[i];
       //          dfs(grid,nx,ny);
       // }
              dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
            }
            
            
            
        
    int numIslands(vector<vector<char>>& grid) {
        
     int m=grid.size();
        int n=grid[0].size();
        int islands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    ++islands;
                    dfs(grid,i,j);
                }
            }
        }
        return islands;
    }
};