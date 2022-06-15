#Time Complexity: O(mn)
#Space Complexity: O(mn)
class Solution:
    dirns = [[1,0],[-1,0],[0,1],[0,-1]]
    def numIslands(self, grid: List[List[str]]) -> int:
        
        m = len(grid)
        n = len(grid[0])
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    
                    self.bfs(i,j,grid,m,n)
                    count += 1
        return count
                    
    def bfs(self,i,j,grid,m,n):
        q = deque()
        q.append([i,j])
        
        while q:
            r,c = q.popleft()
            for dirn in self.dirns:
                nr = r + dirn[0]
                nc = c + dirn[1]
                if nr>=0 and nr<m and nc>=0 and nc<n and grid[nr][nc] == '1':
                    q.append([nr,nc])
                    grid[nr][nc] = '2'
                    
                    
                    
                
                
                