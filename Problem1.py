'''
Time Complexity: O(m * n)
Space Complexity: O(m * n)
Run on Leetcode: YES
'''
class Solution:
    def dfs(self, grid: list[list[str]], i: int, j: int, m: int, n: int, directions: list[list[int]]):
        # base case:
        if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == '0':
            return
        # logic:
        grid[i][j] = '0'
        for direction in directions:
            nr = i + direction[0]
            nc = j + direction[1]
            self.dfs(grid, nr, nc, m, n, directions)
        
        
        
    def numIslands(self, grid: list[list[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        directions = [[-1,0], [0,1], [1,0], [0,-1]]
        result = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    result += 1
                    self.dfs(grid, i, j, m, n, directions)
        return result