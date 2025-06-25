#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    vector<vector<int>> dir;
    int m, n;
    int numIslands(vector<vector<char>>& grid) {
        dir = {{-1,0},{1,0},{0,1},{0,-1}};
        m = grid.size();
        n = grid[0].size();
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
    void dfs(vector<vector<char>>& grid, int i, int j) {
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] != '1') 
            return;
        grid[i][j] = '0';
        for(auto& x : dir){
            int r = x[0] + i;
            int c = x[1] + j;
            dfs(grid, r, c);
        }
    }
};