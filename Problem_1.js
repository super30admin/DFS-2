// Problem1 (https://leetcode.com/problems/number-of-islands/)

// DFS
// TC: O(2mn)
// SC: O(mn) -> Recursion stack

// BFS
// TC: O(mn)
// SC: O(min(m,n))

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

let dirs;
let dfs = (grid, i, j) => {
    if (i < 0 || i >= grid.length || j < 0 || j > grid[0].length || grid[i][j] !== "1")
        return;
    // Set visited island to "2"
    grid[i][j] = "2";
    dirs.forEach(dir => {
        dfs(grid, i + dir[0], j + dir[1]);
    })
}

let bfs = (grid, i, j) => {
    // Queue will store the visited nodes
    let q = [[i, j]];
    grid[i][j] = "2";
    while (q.length > 0) {
        let node = q.shift();
        // Check all 4 directions
        dirs.forEach(dir => {
            let nr = node[0] + dir[0];
            let nc = node[1] + dir[1];
            // If a valid cell, change to 2
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] === "1") {
                grid[nr][nc] = "2";
                q.push([nr, nc]);
            }
        })
    }
}

/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
    if (grid === null)
        return 0;

    let totalIslands = 0;
    dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]];

    // Go through all the grid elements
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            // If it is an island i.e "1", start searching for island
            if (grid[i][j] === "1") {
                bfs(grid, i, j);
                // dfs(grid, i, j);
                totalIslands++;
            }
        }
    }

    // reverting the grid
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (grid[i][j] === "2") {
                grid[i][j] = "1"
            }
        }
    }

    return totalIslands;
};