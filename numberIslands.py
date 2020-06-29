from collections import deque
class Solution(object):
    # Time Complexity : O(n*m), where n and m is the number of rows and columns respectively in the grid.
    # Space Complexity : O(x), where x is minimum of m or n.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # This approach uses a bfs, where every cell is visited and if any
    # cell is 1, a BFS is performed to find the connected component, the
    # cells are marked visited while traversing to avoid re processing.
    def numIslandsBFS(self, grid):
        if not grid:
            return 0

        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        retVal, n, m = 0, len(grid), len(grid[0])
        q = deque()

        # visiting every cell in grid
        for i in range(n):
            for j in range(m):
                # if island beginning found
                if grid[i][j] == '1':
                    retVal += 1
                    # mark visited and add to queue
                    # not required to mark 1st node of island 0, works without line 29
                    grid[i][j] = '0'
                    q.append((i, j))
                    # BFS
                    while q:
                        curr = q.popleft()
                        # visiting all 4 neighbors
                        for dir in dirs:
                            r = curr[0] + dir[0]
                            c = curr[1] + dir[1]
                            # if neighbor also island
                            if 0 <= r < n and 0 <= c < m and grid[r][c] == '1':
                                grid[r][c] = '0'
                                q.append((r, c))
        # resultant var
        return retVal

#------------------------------------------------------x---------------------------------------------------------------#

    # Time Complexity : O(n*m), where n and m is the number of rows and columns respectively in the grid.
    # Space Complexity : O(n*m), where n and m is the number of rows and columns respectively in the grid.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # This approach uses a DFS, where every cell is visited and if any
    # cell is 1, a DFS is performed to find the connected component, the
    # cells are marked visited while traversing to avoid re processing.
    def __init__(self):
        self.retVal = 0
        self.dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        self.n, self.m = 0, 0
        self.grid = None

    def numIslands(self, grid):
        if not grid:
            return 0
        self.n, self.m = len(grid), len(grid[0])
        self.grid = grid
        # visiting every cell in grid
        for i in range(self.n):
            for j in range(self.m):
                if grid[i][j] == '1':
                    self.retVal += 1
                    self.dfs(i, j)

        return self.retVal

    def dfs(self, i, j):
        # if out of bounds or '0'
        if i < 0 or i >= self.n or j < 0 or j >= self.m or self.grid[i][j] == '0':
            return
        # marking cell visited
        self.grid[i][j] = '0'
        # visiting all 4 neighbors
        for dir in self.dirs:
            r = i + dir[0]
            c = j + dir[1]
            self.dfs(r, c)
