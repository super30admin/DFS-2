# Space Complexity: O(m*n)
# Time Complexity: O(m*n)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        R = len(grid)
        C = len(grid[0])
        c = 0
        dirs = [(-1,0),(1,0),(0,-1),(0,1)]
        
        
        for i in range(R):
            for j in range(C):
                if grid[i][j] == "1":
                    c+=1
                    q = collections.deque()
                    q.append((i,j))
                    while q: 
                        x,y = q.popleft()
                        for dx, dy in dirs: 
                            nx = x + dx
                            ny = y + dy

                            if 0<=nx<R and 0<=ny<C and grid[i][j] == '1':
                                q.append((nx,ny))
                                grid[nx][ny] = '0'

        return c
