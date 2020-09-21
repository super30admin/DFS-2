# Time Complexity : O(nm)
# Space Complexity : O(nm) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Change 1 to zero for every grp of 1 found increment count

class Solution(object):
    def dfs(self, grid, i, j, dirs):
        grid[i][j] = '0'
        
        for d in dirs:
            row = i + d[0]
            col = j + d[1]
            if 0 <= row < len(grid) and 0 <= col < len(grid[0]) and grid[row][col] == '1':
                self.dfs(grid, row, col, dirs)
            
        
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if len(grid) == 0 or grid == None:
            return 0
        count = 0
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j, dirs)
                    count += 1
        
        return count