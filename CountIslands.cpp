#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We scan the entire grid for any unvisited '1' which marks the start of an island.
Upon finding one, we use BFS to visit all connected land cells, marking them as '0'.
This prevents revisits and lets us count each island exactly once.
*/
class Solution{
public:
    int numIslands(vector<vector<char>>& grid) {
        vector<vector<int>> dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int m=grid.size(), n=grid[0].size();
        int count = 0;
        queue<pair<int,int>> q;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    q.push({i,j});
                    while(!q.empty()){
                        pair<int, int> curr = q.front(); q.pop();
                        for(auto dir : dirs){
                            int r = dir[0] + curr.first;
                            int c = dir[1] + curr.second;

                            if(r>=0 && c>=0 && r<m && c<n && grid[r][c] == '1'){
                                q.push({r,c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
};
