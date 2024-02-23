// Time Complexity :  O(M*N)
// Space Complexity :  O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// BFS, TC = O(m * n), SC = O(m * n)
// class Solution {
// public:
//     vector<vector<int>> dirs{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//     int numIslands(vector<vector<char>>& grid) {
//         // null
//         if(grid.size() == 0) return 0;
//         int m = grid.size();
//         int n = grid[0].size();
//         int count = 0;
//         queue<int> rq; queue<int> cq;
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(grid[i][j] == '1') {
//                     count++;
//                     rq.push(i); cq.push(j);
//                     grid[i][j]='0';//mark as visited before pushing to q always to prevent duplicates
//                     while(!rq.empty()) {
//                         int cr = rq.front(); rq.pop();
//                         int cc = cq.front(); cq.pop();
//                         for(vector<int> dir: dirs) {
//                             int nr = cr + dir[0];
//                             int nc = cc + dir[1];
//                             // bound check
//                             if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
//                                 grid[nr][nc]='0';//change b4 pushng to q always to prevent duplicates
//                                 rq.push(nr); cq.push(nc);
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return count;
//     }
// };

// DFS: Connected Components, TC = O(m * n), SC = O(m * n)
class Solution {
public:
    vector<vector<int>> dirs{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int numIslands(vector<vector<char>>& grid) {
        // null
        if(grid.size() == 0) return 0;
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    void dfs(vector<vector<char>>& grid, int i, int j, int m, int n) {
        // base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;
        // logic
        grid[i][j] = '0'; // marking as visited
        for(vector<int> dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c, m, n);
        }
    }
};