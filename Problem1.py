class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        cnt = 0
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    cnt += 1
                    q = deque()
                    q.append([i,j])
                    grid[i][j] = "0"
                    while q:
                        curr = q.popleft()
                        for dire in dirs:
                            nr = curr[0] + dire[0]
                            nc = curr[1] + dire[1]
                            if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == "1":
                                q.append([nr,nc])
                                grid[nr][nc] = "0"
                            
        return cnt

        
        