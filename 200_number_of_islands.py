from collections import deque


class Solution:
    dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    def numIslandsDFS(self, grid: List[List[str]]) -> int:
        """
            https://leetcode.com/problems/number-of-islands/
            // Time Complexity : O(mn)
                'm' is the noOfRows, 'n' is the noOfCols
            // Space Complexity : O(mn)
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                - Traverse the matrix
                - If we find a '1':
                    - Increment Count
                    - Recursively call DFS on adjacent elements
                - Return count
        """
        count = 0
        rows = len(grid)

        # edge case
        if not grid or not rows:
            return count

        cols = len(grid[0])

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == '1':
                    self._dfs(grid, row, col)
                    count += 1
        return count

    def _dfs(self, grid: List[List[str]], row, col):
        # base
        if row < 0 or row >= len(grid) or col < 0 or col >= len(grid[0]) or (grid[row][col] == '1'):
            return

        # logic
        grid[row][col] = '0'
        for dir in self.dirs:
            r = dir[0] + row
            c = dir[1] + col
            self._dfs(grid, r, c)

    def numIslandsBFS(self, grid: List[List[str]]) -> int:
        """
            https://leetcode.com/problems/number-of-islands/
            // Time Complexity : O(mn)
                'm' is the noOfRows, 'n' is the noOfCols
            // Space Complexity : min(m,n) or the sqrt(m^2 + n^2) Diagonal
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                    - Traverse the matrix
                    - If we find a '1'
                        - Increment Count
                        - Call BFS on adjacent elements
                    - Return count
        """
        count = 0
        rows = len(grid)

        # edge case
        if not grid or not rows:
            return count

        cols = len(grid[0])

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == '1':
                    grid[row][col] = '0'
                    self._bfs(grid, row, col)
                    count += 1
        return count

    def _bfs(self, grid, row, col):
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        queue = deque()
        queue.append((row, col))
        while queue:
            cur = queue.pop()
            for dir in dirs:
                r = dir[0] + cur[0]
                c = dir[1] + cur[1]
                if (r >= 0 and r < len(grid)) and (c >= 0 and c < len(grid[0])) and (grid[r][c] == '1'):
                    grid[r][c] = '0'
                    queue.append((r, c))
