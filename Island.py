# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        count = 0
        m = len(grid)
        n = len(grid[0])
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    q = deque()
                    q.append((i,j))
                    grid[i][j] = '0'
                    while q:
                        cr, cc = q.popleft()
                        for r, c in dirs:
                            nr, nc = r + cr, c + cc
                            if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == '1':
                                q.append((nr,nc))
                                grid[nr][nc] = '0'
        return count
