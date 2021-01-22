# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        """
            -iterate over grid.. if its a 1 we do DFS on it and marking it first then check other cells
        """
        if not grid:
            return 0
        
        m = len(grid)
        n = len(grid[0])
        count = 0
        
        dirs = [[0,1],
                [-1,0],
               [0,-1],
               [1,0]]
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j, m, n, dirs)
                    print(i,j)
                    count += 1

        return count 
    
    
    def dfs(self, grid, i, j, m, n,dirs): 
        if grid[i][j] != '1':
            return 
        
        grid[i][j] = -1
        
        for direction in dirs:
            row = direction[0] + i
            col = direction[1] + j
            
            if row >= 0 and row < m and col >= 0 and col < n and grid[row][col] == '1':
                self.dfs(grid, row, col, m, n, dirs)