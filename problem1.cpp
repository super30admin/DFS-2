/*

// Time Complexity : O(M*N)
// Space Complexity : O(M*N) number of stack recursive calls
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
ITerate throught the matrix, find the 1 and then make all conntected 1 -> 0 . Increase the count by 1.
*/

#include<iostream>
#include<vector>
#include<queue>

using namespace std;

class Solution {
    void dfs(vector<vector<char>>& grid ,int x,int y,int m,int n){
        if(x>=0 && x<m && y>=0 && y<n && grid.at(x).at(y) == '1' ){
            grid.at(x).at(y) = '0';
            dfs(grid,x+1,y,m,n);
            dfs(grid,x-1,y,m,n);
            dfs(grid,x,y+1,m,n);
            dfs(grid,x,y-1,m,n);
        }
    }
public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid.at(0).size();
        int cnt{};
        for(int i{};i<m;++i){
            for(int j{};j<n;++j){
                if(grid.at(i).at(j) == '1'){
                    dfs(grid,i,j,m,n);
                    cnt++;
                }
                
            }
        }
        return cnt;
    }
};