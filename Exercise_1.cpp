// Time Complexity                              :  O(M*N) where M is the number of rows and N is the number of columns
// Space Complexity                             :  O(M*N) if all the grid values are going to be 1 then the 
//                                                 recursion will keep moving forward till it has touched all the grid values.
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/number-of-islands/submissions/

class Solution {
private:
    int n,m;
    vector<vector<int>> itr{{1,0},{-1,0},{0,1},{0,-1}};
public:
    int numIslands(vector<vector<char>>& grid) {
    
        vector<vector<char>> gridDFS = grid;
        vector<vector<char>> gridBFS = grid;
        n = grid.size();
        m = grid[0].size();
        int rtc = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1') {
                    rtc++;
                    dfsRecursive(grid,i,j);
                }
            }
        }
        
        int dtc = dfsiterative(gridDFS);
        int btc = bfsIterative(gridBFS);
        
        int ans;
        if(rtc == dtc and dtc == btc)
            ans = btc;
        
        return ans;
    }
    
    // dfs
    void dfsRecursive(vector<vector<char>>& grid,int i, int j) {
        if(i < 0 or  i >= n or j < 0 or j >= m or grid[i][j] == '0' ) return;
        
        if(grid[i][j] == '1') {
            grid[i][j] = '0';
        }
        
        for(auto it : itr) {
            dfsRecursive(grid,i+it[0],j+it[1]);
        }
        
    }
    
    // dfs
    int dfsiterative(vector<vector<char>>& grid) {
        
        int count =0;
        stack<pair<int,int>> st;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == '1') {
                    count++;
                    st.push({i,j});
                    while(!st.empty()) {
                        auto [r,c] = st.top();
                        st.pop();
                        for(auto it : itr) {
                            int nr = r + it[0];
                            int nc = c + it[1];
                            if(nr < 0 or nr >= n or nc < 0 or nc >= m or grid[nr][nc] == '0') continue;
                            grid[nr][nc] = '0';
                            st.push({nr,nc});
                            
                        }
                    }
                }
            }
        }
        return count;
    }
    
    // bfs
    int bfsIterative(vector<vector<char>>& grid) {
        int count = 0;
        queue<pair<int,int>> q;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == '1') {
                    count++;
                    q.push({i,j});
                    while(!q.empty()) {
                        auto [r,c] = q.front();
                        q.pop();
                        for(auto it : itr) {
                            int nr = r + it[0];
                            int nc = c + it[1];
                            if(nr < 0 or nr >= n or nc < 0 or nc >= m or grid[nr][nc] == '0') 
                                continue;
                            grid[nr][nc] = '0';
                            q.push({nr,nc});
                            
                        }
                    }   
                }
            }
        }
        
        return count;
    }
    
    
};