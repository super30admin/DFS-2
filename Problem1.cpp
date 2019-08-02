//
// Created by shazm on 8/2/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution{
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size()==0 || grid[0].size()==0){return 0;}

        int m = grid.size();
        int n = grid[0].size();
        int count = 0;

        for(int x = 0; x<m; x++){
            for(int y = 0; y<n; y++){
                if(grid[x][y]=='1'){
                    count++;
                    dfs(x,y,grid,m,n);
                }
            }
        }

        return count;
    }
private:
    void dfs(int i, int j, vector<vector<char>> &grid, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!='1'){
            return;
        }

        grid[i][j] = NULL;
        dfs(i-1,j,grid,m,n); //UP
        dfs(i+1,j,grid,m,n); //DOWN
        dfs(i,j-1,grid,m,n); //LEFT
        dfs(i,j+1,grid,m,n); //RIGHT
    }
};