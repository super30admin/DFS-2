# Approach: In order to find the number of islands, once we find a '1', we change all the 1's surrounding this island to zero so we dont count those again
# Time - O(M * N)
# Space - O(min(M, N))

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid or len(grid) == 0:
            return grid
        
        rows = len(grid)
        cols = len(grid[0])
        
        q = collections.deque()
        dirs = [(-1, 0), (0, -1), (0, 1), (1, 0)]
        count = 0
        
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    count += 1
                    q.append((i,j))
                    grid[i][j] = '0'
                    
                while q:
                    r, c = q.popleft()
                    
                    for dir in dirs:
                        cr = r + dir[0]
                        cc = c + dir[1]
                        
                        if cr >= 0 and cr < rows and cc >= 0 and cc < cols and grid[cr][cc] == '1':
                            q.append((cr, cc))
                            grid[cr][cc] = '0'
                            
        return count
        



## Approach: DFS
# Time - O(M * N)
# Space - O(M * N)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid or len(grid) == 0:
            return grid
        
        self.rows = len(grid)
        self.cols = len(grid[0])
        count = 0
        
        for i in range(self.rows):
            for j in range(self.cols):
                if grid[i][j] == '1':
                    count += 1
                    self.dfs(grid, i, j)
                    
        return count 
        

    def dfs(self, grid, r, c):
        
        # base case
        if r < 0 or c < 0 or r == self.rows or c == self.cols or grid[r][c] != '1':
            return 
        
        grid[r][c] = '0'
        dirs = [(-1, 0), (0, -1), (0, 1), (1, 0)]
        for dir in dirs:
            cr = r + dir[0]
            cc = c + dir[1]
            
            self.dfs(grid, cr, cc)
            
    
        
        