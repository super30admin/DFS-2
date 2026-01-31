/**
 * @param {character[][]} grid
 * @return {number}
 */
// bfs
/**
Intuition:
Iterate over the grid, and for each unvisited land cell ('1'), increment the island count and initiate a breadth-first search using a queue. The BFS explores all neighboring land cells in four directions, marking each visited cell as '0' to avoid revisiting. By the time the queue is empty, all cells of the current island have been visited. Repeating this process across the grid ensures that each connected component is counted exactly once.
T.C: O(m*n)
S.C: O(min(m,n))
*/
var numIslands = function (grid) {
    if (!grid.length) return 0;
    let islandCount = 0;
    const rowLength = grid.length;
    const colLength = grid[0].length;
    const directions = [[0, 1], [1, 0], [-1, 0], [0, -1]];
    // iterate over grid
    for (let i = 0; i < rowLength; i++) {
        for (let j = 0; j < colLength; j++) {
            if (grid[i][j] === '1') {
                islandCount++;
                const queue = [[i, j]];
                // mark the cell to 0, so that we don't visit it again
                grid[i][j] = '0';
                let idx = 0;
                while (idx < queue.length) {
                    const [currR, currC] = queue[idx++];
                    for (let [r, c] of directions) {
                        const newR = currR + r;
                        const newC = currC + c;
                        // check out of bounds and make sure the current cell is land
                        if (newR >= 0 && newC >= 0 && newR < rowLength && newC < colLength && grid[newR][newC] === '1') {
                            queue.push([newR, newC]);
                             // mark the cell to 0, so that we don't visit it again
                            grid[newR][newC] = '0';
                        }
                    }
                }
            }
        }
    }
    return islandCount;
};

// dfs 
/**
Intuition:
This approach is using dfs, i am iterating over all the elements of the given grid, if i am encountering 1 as the curreny value, incrementing the islandCount and starting dfs, by the time we complete dfs, all the 1's that are connected to the initial cell will be marked as 0.
And we iterate on the remaining 1's in the grid and increment the count and call the dfs again.
This process will increment the count by 1 for each connected component.

T.C: O(m*n)
S.C: O(m*n)
 */
var numIslands = function (grid) {
    // if grid is empty
    if (!grid.length) return 0;
    let islandCount = 0;
    const rowLength = grid.length, colLength = grid[0].length;
    const directions = [[0, -1], [0, 1], [-1, 0], [1, 0]];

    const dfs = (row, col) => {
        // base case
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength || grid[row][col] !== '1') return;

        // action
        grid[row][col] = '0';

        // recursion
        for (let [r, c] of directions) {
            dfs(r + row, c + col);
        }
    }

    for (let i = 0; i < rowLength; i++) {
        for (let j = 0; j < colLength; j++) {
            if (grid[i][j] === '1') {
                islandCount++;
                dfs(i, j);
            }
        }
    };

    return islandCount;
}