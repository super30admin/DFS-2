#include <vector>
#include <iostream>
using namespace std;
void destroyLand(vector<vector<char>>& grid, int row, int col) {
    if(grid[row][col]=='0') return;
    grid[row][col] = '0';
    int m = grid.size(), n = grid[0].size();
    if(row+1<=m-1)destroyLand(grid, row+1, col);
    if(row-1>=0) destroyLand(grid, row-1, col);
    if(col+1<=n-1) destroyLand(grid, row, col+1);
    if(col-1>=0) destroyLand(grid, row, col-1);
}
int numIslands(vector<vector<char>>& grid) {
    int islands = 0;
    int m = grid.size(), n = grid[0].size();
    for(int i=0;i<=m-1;i++){
        for(int j=0;j<=n-1;j++){
            int initial_value = grid[i][j]-'0';
            destroyLand(grid,i,j);
            islands += initial_value;
        }
    } 
    return islands;
}
int main() {
    vector<vector<char>> grid = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '1', '1'},
        {'0', '0', '0', '1', '0'},
        {'0', '1', '1', '0', '1'},
        {'1', '0', '0', '0', '1'}
    };
    int result = numIslands(grid);
    cout << "Number of islands: " << result << endl; // Output: 5
    return 0;
}
// Time Complexity: O(m*n)
// Space Complexity: O(m*n) in the worst case, where m is the number of rows and n is the number of columns in the grid
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No
// Your code here along with comments explaining your approach in three sentences only
// Trigger a DFS flood filling function which would destroy all land pixels and keep counting the number of times we had to trigger the function, which would be equal to the number of islands