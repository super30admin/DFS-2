# Time Complexity : Add - O(m*n)
# Space Complexity :O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''

1. DFS is performed from the element containing 1's and as each element is explored it is put as -1 to prevent
   from revisiting
2. When recursion terminated a global count is incremented by 1
'''

class Solution:
    
    def __init__(self):
        self.count = 0
        
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid or len(grid) < 1 or len(grid[0]) < 1:
            return 0
        
        rows = len(grid)
        cols = len(grid[0])
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    self._dfs(grid, i,j)
                    self.count += 1
                    
        return self.count
                    
    def _dfs(self, grid, cur_x, cur_y):
        
        dirs = [(0,-1),(0,1),(1,0),(-1,0)]
        
        #base
        if cur_x < 0 or cur_x >= len(grid) or cur_y < 0 or cur_y >= len(grid[0]) or grid[cur_x][cur_y] != '1':
            return        
        
        #logic
        grid[cur_x][cur_y] = -1
        for dir_x, dir_y in dirs:
            new_x = cur_x + dir_x
            new_y = cur_y + dir_y
            self._dfs(grid, new_x, new_y)
            