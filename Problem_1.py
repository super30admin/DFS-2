class Solution:
    def __init__(self):
        self.m = 0
        self.n = 0
        self.dir = [[0, 1], [1, 0], [-1, 0], [0, -1]]

    """
    BFS
    TC - O(mxn)
    SC - O(mxn)
    """

    def approach1(self, grid) -> int:
        cnt = 0
        q = []
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    cnt += 1
                    grid[i][j] = '0'
                    q.append([i, j])
                    while len(q) > 0:
                        cur = q.pop(0)
                        for d in self.dir:
                            r = cur[0] + d[0]
                            c = cur[1] + d[1]
                            if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == '1':
                                q.append([r, c])
                                grid[r][c] = '0'
        return cnt

    """
    DFS
    TC - O(mxn)
    SC - O(mxn)
    """

    def approach2(self, grid, r, c):
        if r < 0 or c < 0 or r == self.m or c == self.n or grid[r][c] != '1':
            return
        grid[r][c] = '0'
        for d in self.dir:
            nr = r + d[0]
            nc = c + d[1]
            self.approach2(grid, nr, nc)

    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return -1
        # return self.approach1(grid)
        self.m = len(grid)
        self.n = len(grid[0])
        cnt = 0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == '1':
                    cnt += 1
                    self.approach2(grid, i, j)
        return cnt



