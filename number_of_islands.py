'''
Time complexity: O(n*m)
Space complexity: O(n*m)
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0 or grid[0] is None or len(grid[0]) is None:
            return 0
        count = 0
        n = len(grid)
        m = len(grid[0])
        
        for i in range(n):
            for j in range(m):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j)
                    count = count + 1
        return count
    
    def dfs(self, grid, i, j):
        dirs = [[-1,0], [1,0], [0,-1], [0,1]]
        grid[i][j] = 0
        for dir in dirs:
            r = i + dir[0]
            c = j + dir[1]
            
            if r >= 0 and r < len(grid) and c >= 0 and c < len(grid[0]) and grid[r][c] == '1':
                self.dfs(grid, r, c)