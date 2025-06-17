// # DFS-2

// ## Problem1 (https://leetcode.com/problems/number-of-islands/) 

// var numIslands = function(grid) {
//     let n = grid.length;
//     let m = grid[0].length;
//     let islandCount = 0;
//     let directions = [[1,0], [-1,0], [0,1], [0,-1]];

//     function dfs(r, c) {
//         // Base condition: out of bounds or water or already visited
//         if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] !== '1') return;

//         // Mark as visited
//         grid[r][c] = '2';

//         // Visit all 4 directions
//         for (let [dr, dc] of directions) {
//             dfs(r + dr, c + dc);
//         }
//     }

//     for (let i = 0; i < n; i++) {
//         for (let j = 0; j < m; j++) {
//             if (grid[i][j] === '1') {
//                 islandCount++;
//                 dfs(i, j);
//             }
//         }
//     }

//     return islandCount;
// };



var numIslands = function(grid) {
    //USYING BFS
    //Time Complexity : O(M x N)
    //Space Complexity : O(M x N)
    let n = grid.length;
    let m = grid[0].length;
    let isLandsCount = 0;
    let directions = [[1,0], [-1,0], [0,-1], [0,1]];

    function bfs(sr, sc){    
        let queue = [[sr, sc]];
        while(queue.length){
            let [r, c] = queue.shift();
            for(let [dr, dc] of directions){
                let nr = r + dr;
                let nc = c + dc;
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] === '1'){
                    grid[nr][nc] = '2';
                    queue.push([nr, nc]);
                }
            }
        }
    }
    for(let i = 0; i < n; i++){
        for(let j = 0; j < m; j++){
            if(grid[i][j] === '1'){
                isLandsCount += 1;
                grid[i][j] = '2'; 
                bfs(i, j);
            }
        }
    }
    return isLandsCount;
};
