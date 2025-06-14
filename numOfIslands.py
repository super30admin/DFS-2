"""
Approach: Start from a 1 and visit all the 1 only (land) and mark them as visited. every start of an island
denotes an island being explored and res can be incremented.
t.c. => O(m * n)
s.c. => O(m * n) for recursion stack
"""
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]

        def helper(i, j):
            if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == '0':
                return
            
            grid[i][j] = '0'
            for x, y in directions:
                helper(x + i, y + j)
        
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '0':
                    continue
                res += 1
                helper(i, j)
        return res