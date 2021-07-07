# Time Complexity : Mutating: O(m*n) | Visited: O(m*n)
# Space Complexity : Mutating: O(m*n) (Recursion stack) | Visited: O(m*n) (Recursion + visited array)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -


class Solution:
    # Mutating the input grid
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    count += 1
                    self.__dfs(grid, i, j)
        return count
    
    def __dfs(self, grid, i, j):
        #Base Condition
        if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]) or grid[i][j] == '0':
            return
        
        #Logic
        grid[i][j] = '0'
        self.__dfs(grid, i + 1, j)
        self.__dfs(grid, i - 1, j)
        self.__dfs(grid, i, j + 1)
        self.__dfs(grid, i, j - 1)


class Solution:
    # Using extra space of visited array
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        self.visited = [[False for _ in range(len(grid[0]))] for _ in range(len(grid))]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1' and not self.visited[i][j]:
                    count += 1
                    self.__dfs(grid, i, j)
        return count
    
    def __dfs(self, grid, i, j):
        #Base Condition
        if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]) or grid[i][j] == '0' or self.visited[i][j]:
            return
        
        #Logic
        self.visited[i][j] = True
        self.__dfs(grid, i + 1, j)
        self.__dfs(grid, i - 1, j)
        self.__dfs(grid, i, j + 1)
        self.__dfs(grid, i, j - 1)