# DFS Approach --
# TC - O(m * n)
# SC - O(m) --> minimum between m and n since we could have a scenario with 3 rows and 1 col or vice versa.
# so minimum between m and n

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0: return 0

        m = len(grid)
        n = len(grid[0])
        total = 0

        for r in range(m):
            for c in range(n):
                if grid[r][c] == '1':
                    self.dfs(grid, r, c, m, n)
                    total += 1

        return total

    def dfs(self, grid, r, c, m, n):
        # base case
        if r >= m and r < 0 and c >= n and c < 0 and grid[r][c] == '0': return

        dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]

        for direction in dirs:
            new_row = direction[0] + r
            new_col = direction[1] + c

            if new_row >= 0 and new_row < m and new_col >= 0 and new_col < n and grid[new_row][new_col] == '1':
                grid[new_row][new_col] = '0'
                self.dfs(grid, new_row, new_col, m, n)
