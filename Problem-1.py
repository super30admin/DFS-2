"""
Approach: DFS

TC: O(m*n)
SC: O(min(m,n))
"""
class Solution:
    # approach dfs
    def __init__(self):
        self.m = 0
        self.n = 0
    def numIslands(self, grid: List[List[str]]) -> int:
        self.m = len(grid)
        self.n = len(grid[0])
        count = 0
        for r, row in enumerate(grid):
            for c , cell in enumerate(row):
                if cell == '1':
                    count += 1
                    self.dfs(grid, r, c)

        return count

    def dfs(self, grid, r, c):
        # base
        if r < 0 or r >= self.m or c < 0 or c > =self.n or grid[r][c] != '1':
            return
            # logic
        grid[r][c] = '0'
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        for roff, coff in dirs:
            nr = r + roff
            nc = c + coff
            self.dfs(grid, nr, nc)

    # approach: bfs
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        count = 0
        q = deque()
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        for r, row in enumerate(grid):
            for c, cell in enumerate(row):
                if cell == '1':
                    count += 1
                    grid[r][c] = '0'
                    q.append((r, c))

                    while q:
                        curr_r, curr_c = q.popleft()

                        for roff, coff in dirs:
                            nr = curr_r + roff
                            nc = curr_c + coff
                            if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == '1':
                                grid[nr][nc] = '0'
                                q.append((nr, nc))

        return count