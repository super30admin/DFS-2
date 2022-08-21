# 200. Number of Islands

'''
Leetcode all test cases passed: Yes
Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        n is the no of columns in grid
        m is the no of row in grid
        Time Complexity: O(m * n) 
        Space Complexity: O(m * n)
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        r = [(-1,0),(1,0),(0,-1),(0,1)]
        rows = len(grid)
        cols = len(grid[0])
        count = 0
        
        def dfs(m,n):
            if m < 0 or n < 0 or m >= rows or n >= cols or grid[m][n] != '1':
                return
            grid[m][n] = "0"
            for x,y in r:  
                dfs(m+x,n+y)
            return 
        
        for m in range(rows):
            for n in range(cols):
                if grid[m][n] == '1':
                    for x,y in r:  
                        dfs(m+x,n+y)
                    count += 1
                    
        return count
 
