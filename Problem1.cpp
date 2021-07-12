// Time Complexity :O[2(m x n)] bfs or dfs
// Space Complexity : O(m x n) queue or system stack size 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// No. of islands 

#include<vector>
#include<iostream>
#include<queue>
using namespace std;


// DFS


class Solution {
    int dirs[4][2] = {{-1,0}, {1,0}, {0,1}, {0,-1}};    // LRUD
    int count = 0;
public:
    int numIslands(vector<vector<char>>& grid) {
        
        if(grid.empty())
            return 0;
        int m = grid.size();
        int n = grid[0].size();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // 2 loops to find the first 1
                if(grid[i][j] == '1'){
                    count = count + 1;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    void dfs(vector<vector<char>>& grid, int r, int c){
        
        // base 
        if(r < 0 || c < 0 || r == grid.size() || c == grid[0].size() || grid[r][c] != '1')
            return;
        
        // logic 
        grid[r][c] = '0';   // mark it visited
        for(auto dir : dirs){
            int row = r + dir[0];
            int col = c + dir[1];
            dfs(grid, row, col);
        }
    }
};


//  BFS

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        
        if(grid.empty())    // base case
            return 0;
        
        int dirs[4][2] = {{-1,0}, {1,0}, {0,1}, {0,-1}};    // LRUD
        queue<vector<int>> q1;
        int count = 0;
 
        
        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid[0].size(); j++){
                if(grid[i][j] == '1'){
                    count = count + 1;
                    grid[i][j] = 0; // mark it as zero then push

                    q1.push({i, j});    // push the co-ordinates
                    
                    while(!q1.empty()){
                        vector<int> curr = q1.front();
                        q1.pop();
                        
                        for(auto dir : dirs){
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];   // go to the neighbours 
                            if(r >= 0 && c >= 0 && r < grid.size() && c < grid[0].size() && grid[r][c] == '1'){
                                grid[r][c] = '0';   // mark visited 
                                q1.push({r,c});
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
};