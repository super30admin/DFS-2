
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
    let dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]];
    let numOfIslands = 0;
    let rowLen = grid.length;
    let colLen = grid[0].length;

    // Count the island for all available individual 1, any other 1 next to the curr 1 will be assumed water to find only unique islands
    
    const countIsland = (i, j) => {
        if (grid[i][j] === '1') {
            numOfIslands++;
            let queue = [];
            queue.push([i, j]);

            while (queue.length > 0) { // Run BFS till all cells with island are exhausted
                let curr = queue.pop();
                for (let dir of dirs) {
                    let newRow = curr[0] + dir[0];
                    let newCol = curr[1] + dir[1];

                    if (newRow >= 0 && newRow < rowLen && newCol >= 0 && newCol < colLen
                        && grid[newRow][newCol] === '1') { // boundary check
                        queue.push([newRow, newCol]);
                        grid[newRow][newCol] = '0'; //set as visited
                    }
                }
            }
        }
    }

    for (let i = 0; i < rowLen; i++) {
        for (j = 0; j < colLen; j++) {
            countIsland(i, j)
        }
    }
    return numOfIslands;
};