// Time Complexity : O(M*N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: BFS using queue, if 1 is found change it to 0,
// keep track of count and check vicinity. Total number of BFS is count.

// 200. Number of islands

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<pair<int,int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        queue<pair<int,int>> q;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    q.push({i,j});
                    while(!q.empty()){
                        auto curr = q.front();
                        q.pop();
                        for(auto dir : dirs){
                            int nr = curr.first + dir.first;
                            int nc = curr.second + dir.second;
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n 
                            && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.push({nr,nc});
                            } 
                        }
                    }
                }
            }
        }
        return count;
    }
};