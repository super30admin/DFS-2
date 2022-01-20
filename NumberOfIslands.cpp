//Time Complexity O(m*n)
// Space Complexity O(m*n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
using namespace std;

class Solution {
public:
    int count=0;
    int dirs[4][2]={{0,1},{0,-1},{-1,0},{1,0}};
    int rows;
    int cols;
    int numIslands(vector<vector<char>>& grid) {
        rows=grid.size();
        cols=grid[0].size();
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    
    void dfs(vector<vector<char>>& grid, int row, int col)
    {
        if(row<0 || row>=rows || col<0 || col >=cols || grid[row][col] == '0')
        {
            return;
        }
        
        grid[row][col]='0';
        for(auto &dir:dirs)
        {
            int nr=row+dir[0];
            int nc=col+dir[1];
            dfs(grid,nr,nc);
        }
    }
};
