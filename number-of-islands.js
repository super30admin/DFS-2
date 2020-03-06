// Time Complexity : O(M*N) BFS and DFS
// Space Complexity : O(min(M, N)) BFS, O(M*N) DFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {character[][]} grid
 * @return {number}
 */

// BFS
var numIslands = function(grid) {
    if (grid == null || grid.length == 0) return 0;
    
    let result = 0,
        m = grid.length,
        n = grid[0].length,
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] == '1') {
                result++;
                grid[i][j] = '0';
                let q = [[i, j]];
                while (q.length > 0) {
                    let curr = q.shift();
                    for (const dir of dirs) {
                        let r = dir[0] + curr[0],
                            c = dir[1] + curr[1];
                        if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1') {
                            grid[r][c] = '0';
                            q.push([r, c]);
                        }
                    }
                }
            }
        }
    }
    return result;
};

// DFS
// let dirs, m, n;
// var numIslands = function(grid) {
//     if (grid == null || grid.length == 0) return 0;
    
//     let result = 0;
//     m = grid.length;
//     n = grid[0].length;
//     dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    
//     for (let i = 0; i < m; i++) {
//         for (let j = 0; j < n; j++) {
//             if (grid[i][j] == '1') {
//                 result++;
//                 dfs(grid, i, j);
//             }
//         }
//     }
    
//     return result;
// };

// var dfs = function(grid, i, j) {
//     // Base Case
//     if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
    
//     // Logic
//     grid[i][j] = '0';
//     for (const dir of dirs) {
//         let r = i + dir[0],
//             c = j + dir[1];
//         dfs(grid, r, c);
//     }
// }


