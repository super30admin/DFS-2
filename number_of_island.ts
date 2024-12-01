// TC: O(2mxn) SC: O(mxn) 
// TC: If all the elements are 1 then, we will visit all the element in 1st DFS call and for subsequent traversal it will be just to find any 1s
// SC: Size of Recursive Stack
function numIslands(grid: string[][]): number {
  let count = 0;
  function dfs(grid: string[][], row: number, col: number) {
    let direction: number[][] = [
      [0, 1], // right
      [1, 0], // down
      [0, -1], // left
      [-1, 0], // up
    ];
    for (let dir = 0; dir < direction.length; dir++) {
      let newRow = row + direction[dir][0];
      let newCol = col + direction[dir][1];
      if (
        newRow >= 0 &&
        newRow < grid.length &&
        newCol >= 0 &&
        newCol < grid[0].length &&
        grid[newRow][newCol] == "1"
      ) {
        grid[newRow][newCol] = "-1";
        dfs(grid, newRow, newCol);
      }
    }
  }

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (grid[i][j] == "1") {
        // traverse
        count++;
        dfs(grid, i, j);
      }
    }
  }

  return count;
}

// TC: O(mxn) SC: O(min(mxn))
// Because we will visit all the cell once and do the DFS by number of island
function numIslands_withBFS(grid: string[][]): number {
  let direction: number[][] = [
    [0, 1], // right
    [1, 0], // down
    [0, -1], // left
    [-1, 0], // up
  ];
  let count = 0;
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (grid[i][j] == "1") {
        // traverse
        count++;

        let queue: number[][] = [];
        queue.push([i, j]);
        while (queue.length != 0) {
          let obj:number[] = queue.shift()!
          let row:number = obj[0]
          let col:number = obj[1]
          for (let dir = 0; dir < direction.length; dir++) {
            let newRow = row + direction[dir][0];
            let newCol = col + direction[dir][1];
            if (
              newRow >= 0 &&
              newRow < grid.length &&
              newCol >= 0 &&
              newCol < grid[0].length &&
              grid[newRow][newCol] == "1"
            ) {
              grid[newRow][newCol] = "-1";
              queue.push([newRow, newCol]);
            }
          }
        }
      }
    }
  }

  return count;
}

describe("Number of Island", () => {
  it("Happy Path - DFS", () => {
    expect(
      numIslands([
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"],
      ])
    ).toStrictEqual(1);
  });

  it("Happy Path - BFS", () => {
    expect(
      numIslands_withBFS([
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"],
      ])
    ).toStrictEqual(1);
  });
});
