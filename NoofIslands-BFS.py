#Time Complexity: O(m*n)
#space Complexity: O(min(m,n))
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]:
            return 0
        
        m = len(grid)
        n = len(grid[0])
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        
        cnt = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    cnt += 1
                    q = deque()
                    q.append((i,j))
                    grid[i][j] = "0"
                    
                    while q:
                        curr = q.popleft()
                        for d in dirs:
                            nr = curr[0] + d[0]
                            nc = curr[1] + d[1]
                            
                            if nr >= 0 and nc >= 0 and nr < m and nc < n:
                                if grid[nr][nc] == "1":
                                    q.append((nr, nc))
                                    grid[nr][nc] = "0"
        return cnt
                    
        
