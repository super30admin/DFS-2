// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//DFS
//1. Store all the indexes at 1's in an array
//2. While processing Change all the elements from 1 to 0
//3. Move along the one's array to find another one.


class Solution {
public:
    int result;
    vector<pair<int,int>> all_ones;
    int numIslands(vector<vector<char>>& grid) {
        //edge
        if(grid.size()==0) return 0;
        //logic
        int m = grid.size();
        int n = grid[0].size();
        char one = '1';
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]== one)  {
                    all_ones.push_back({i,j});
                }
            }
        }
       for(int i=0; i<all_ones.size(); i++){
           pair<int,int> temp = all_ones[i];
           if(grid[temp.first][temp.second] == one){
               dfs(grid, m, n, temp.first, temp.second);
               result++;
           }
       }
        
        return result;
    }
    
   void dfs(vector<vector<char>> &grid, int m, int n, int sr, int sc){
        
       //edge
       char zero  = '0';
       if(grid[sr][sc] == zero) return;
       
       //logic
       char one = '1';
       if( grid[sr][sc] == one) grid[sr][sc] ='0';
       
       vector<vector<int>> dir = {{1,0},{-1,0},{0,1},{0,-1}};
       //recursion
       for(int i=0; i<dir.size(); i++){
           int row = sr+dir[i][0];
           int col = sc+dir[i][1];
           if(row>=0 && row<m && col>=0 && col<n)
                dfs(grid, m, n, row, col);
       }
    }
};
