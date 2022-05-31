# Time: O(mn)
# Space: min of m,n

class Solution:
    count = 0
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0:
            return 0
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        m = len(grid)
        n = len(grid[0])
        self.count = 0
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self.count += 1
                    self.dfs(grid, i, j, m, n, dirs)
        
        return self.count
    
    def dfs(self, grid, i, j, m, n, dirs):
        if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] != '1':
            return
        
        grid[i][j] = '2'
        for di in dirs:
            r = i + di[0]
            c = j + di[1]
            self.dfs(grid, r, c, m, n, dirs)



# Time: O(mn)
# Space: O(mn)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0:
            return 0
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        m = len(grid)
        n = len(grid[0])
        q = list()
        islands = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    islands += 1
                    q.append([i,j])
                    grid[i][j] = '2'
                    while len(q) != 0:
                        curr = q.pop(0)
                        for di in dirs:
                            r = curr[0] + di[0]
                            c = curr[1] + di[1]
                            if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == '1':
                                q.append([r,c])
                                grid[r][c] = '2'
                    
        return islands