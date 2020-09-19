//** https://leetcode.com/problems/employee-importance/
//// Time Complexity :
//// Space Complexity :
//// Did this code successfully run on Leetcode :
//// Any problem you faced while coding this :

//// Your code here along with comments explaining your approach

// numIslands = 0
// for each element in grid
//   if element is water
//     skip this element
//   else
//     numIslands += 1
//     do a dfs converting this and all neighbors to land

// return numIslands

// dfs on element
//   for each direction in [up, down, left, right]
//      if element + direction is invalid
//        skip this direction
//      if element is water
//        skip this direction
//      else
//        mark it as water so it will be skipped
//        dfs (recursive) on element + direction
var LAND, WATER, numIslands;

LAND = '1';

WATER = '0';

numIslands = function(grid) {
  var col, countIslands, dfsSetItselfAndNeighborsToWater, directions, i, j, maxX, maxY, ref, ref1, row;
  if (grid === null || grid.length === 0 || grid[0].length === 0) {
    return 0;
  }
  maxX = grid[0].length;
  maxY = grid.length;
  directions = [[-1, 0], [1, 0], [0, -1], [0, 1]];
  dfsSetItselfAndNeighborsToWater = function(y, x) {
    var dirX, dirY, i, len, results;
    if (!((0 <= y && y < maxY) && (0 <= x && x < maxX))) {
      return;
    }
    if (grid[y][x] === WATER) {
      return;
    }
    grid[y][x] = WATER;
    results = [];
    for (i = 0, len = directions.length; i < len; i++) {
      [dirX, dirY] = directions[i];
      results.push(dfsSetItselfAndNeighborsToWater(y + dirY, x + dirX));
    }
    return results;
  };
  countIslands = 0;
  for (row = i = 0, ref = maxY; (0 <= ref ? i < ref : i > ref); row = 0 <= ref ? ++i : --i) {
    for (col = j = 0, ref1 = maxX; (0 <= ref1 ? j < ref1 : j > ref1); col = 0 <= ref1 ? ++j : --j) {
      if (grid[row][col] === WATER) {
        continue;
      }
      countIslands += 1;
      dfsSetItselfAndNeighborsToWater(row, col);
    }
  }
  return countIslands;
};

numIslands([['1', '0']]) === 1;

numIslands([['1', '1', '0']]) === 1;

//numIslands([
//  ['1','1','1','0'],
//  ['1','1','1','0'],
//  ['0','0','0','0']
//]) is 1

//# sourceMappingURL=problem1-no-islands-my-way.js.map
