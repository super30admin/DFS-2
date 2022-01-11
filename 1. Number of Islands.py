from collections import deque
class Solution:
    # BFS
    # Time Complexity - O(m*n)
    # Space Complexity - O(min(m,n))
    def numIslands(self, grid) -> int:
        if grid is None or len(grid) == 0:return 0
        m = len(grid)
        n = len(grid[0])
        q = deque()
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    grid[i][j] = '0'
                    count+=1
                    q.append((i,j))
                    while q:
                        curr = q.popleft()
                        for direction in dirs:
                            nr = curr[0] + direction[0]
                            nc = curr[1] + direction[1]
                            if nr>= 0 and nr<m and nc >=0 and nc<n and grid[nr][nc] == '1':
                                grid[nr][nc] = '0'
                                q.append((nr,nc))
        return count