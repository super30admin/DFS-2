// Apporach 1 : BFS
// Time Complexity : O(2 * n * m) 
//                     ... in worst case scenario, when there are all '1' in matrix,
//                         for loop moves iterates over all element.
//                         For first '1' element, for loop iterates over all elements and set them to '0'
//                         Therefore, it is not (m*n)^2 instead, its m*n + m*n.   
// Space Complexity : O(min(m, n))
//
// Apporach 2 : DFS
// Time Complexity : O(2 * n * m) 
//                     ... in worst case scenario, when there are all '1' in matrix,
//                         for loop moves iterates over all element.
//                         For first '1' element, for DFS recursion goes over all elements and 
//                         set them to '0'. Therefore, it is not (m*n)^2 instead, its m*n + m*n.   
// Space Complexity : O(m * n) ..... Recursion stack is created for m * n in worst case.
/*
Leetcode : https://leetcode.com/problems/number-of-islands/description/

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), 
return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or 
vertically. You may assume all four edges of the grid are all surrounded by water.
*/


/**
 * Approach 1 : BFS
*/


class Solution {
    vector<vector<int>> dir{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

public:
    int numIslands(vector<vector<char>>& grid) {
        queue<vector<int>> q;
        int count = 0;
        int n = grid.size();
        int m = grid[0].size();

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == '1') {
                    count++;
                    q.push({i, j});
                    grid[i][j] = '0';

                    while (!q.empty()) {
                        vector<int> temp = q.front();
                        q.pop();
                        int ci = temp[0];
                        int cj = temp[1];
                        for (auto& pair : dir) {
                            int ni = ci + pair[0];
                            int nj = cj + pair[1];
                            if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == '1'){
                                q.push({ni, nj});
                                grid[ni][nj] = '0';
                        }
                    }
                }
            }
        }
    }
    return count;
}
}
;



/**
 * 
 * Approach 2 : DFS
 * 
 * 
*/


class Solution {
    vector<vector<int>> dir{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

public:
    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    void dfs(vector<vector<char>>& grid, int i, int j){
        int n = grid.size();
        int m = grid[0].size();

        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') return;  
        grid[i][j] = '0';
        for(auto &pair : dir){
            int ni = i + pair[0];
            int nj = j + pair[1];
            dfs(grid, ni, nj);
        }
    }
};