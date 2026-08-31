"""
APPROACH:
1. Scan every cell in the grid from top-left to bottom-right.
2. When an unvisited land cell ("1") is found, it means a new island is discovered.
3. Run BFS from that cell to visit all connected land cells (up, down, left, right).
4. Mark each visited land cell as "0" so it is never counted again.
5. Increment the island count each time a new BFS is started.

PATTERN:
Grid BFS / Flood Fill (Connected Components)

TIME COMPLEXITY:
O(m x n) - every cell is visited at most once overall

SPACE COMPLEXITY:
O(m x n) - worst case queue holds all cells if grid is entirely land

EXAMPLE:
Input:
grid = [
  ["1","1","0","0"],
  ["1","1","0","0"],
  ["0","0","1","0"],
  ["0","0","0","1"]
]

Output: 3
Why: top-left 2x2 block is one island, (2,2) is a second island, (3,3) is a third island
"""

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        # 4 possible directions to move: up, down, left, right
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        m = len(grid)  # number of rows
        n = len(grid[0])  # number of columns
        count = 0  # tracks total number of islands found

        q = collections.deque()  # queue used for BFS

        # scan every cell in the grid
        for i in range(m):
            for j in range(n):
                # found the start of a new, unvisited island
                if grid[i][j] == "1":
                    count = count + 1  # this is a new island, so increment count

                    # mark this cell as visited by sinking it to "0"
                    grid[i][j] = "0"

                    q.append([i, j])  # add starting cell to queue

                    # BFS: explore all connected land cells from this starting point
                    while q:
                        curr = q.popleft()  # process next cell in queue

                        # check all 4 neighbors of current cell
                        for dir in dirs:
                            r = curr[0] + dir[0]  # neighbor row
                            c = curr[1] + dir[1]  # neighbor column

                            # if neighbor is inside grid bounds and is unvisited land
                            if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == "1":
                                q.append([r, c])  # add neighbor to queue to explore later
                                grid[r][c] = "0"  # mark neighbor visited so it's not recounted

        return count  # total number of islands found