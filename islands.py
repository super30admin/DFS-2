# Time Complexity : O(mn)
# Space Complexity : O(min(m, n)) -> queue / O(mn) - recursive stack

class Solution:
    def numIslandsBFS(self, grid: List[List[str]]) -> int:
        
        if len(grid) == 0: return 0
        
        m = len(grid)
        n = len(grid[0])
        
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        q = collections.deque()
        ct = 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    q.append((i,j))
                    grid[i][j] = '2'
                    ct += 1
                    while q:
                        cur = q.popleft()
                        for d in dirs:
                            r = cur[0] + d[0]
                            c = cur[1] + d[1]
                            if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == '1':
                                q.append((r, c))
                                grid[r][c] = '2'
        return ct

    def dfs(self, grid: List[List[str]], r: int, c: int):
        m = len(grid)
        n = len(grid[0])
        if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == '1':
            grid[r][c] = '2'
            dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
            for d in dirs:
                nr = r + d[0]
                nc = c + d[1]
                self.dfs(grid, nr, nc)
        else:
            return

    def numIslandsDFS(self, grid: List[List[str]]) -> int:
        
        if len(grid) == 0: return 0
        
        ct = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    ct += 1
                    self.dfs(grid, i, j)
        return ct
                
        