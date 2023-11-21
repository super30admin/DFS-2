# Time Complexity: O(mn) or O(2mn)
# Space Complexity: O(mn) of Recursive Stack

# Approach is to start DFS at 'any' islands. Once encountered, do a DFS to find all '1' and make them '0'

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.islands = 0
        self.m = len(grid)
        self.n = len(grid[0])

        if grid is None or len(grid) == 0:
            return self.islands
        
        for i in range(self.m):
            for j in range(self.n):
                if(grid[i][j] == '1'):
                    grid[i][j] = '0'
                    self.helper(grid, i, j)
                    self.islands += 1
        
        return self.islands

    def helper(self, grid: List[List[str]], r: int, c: int) -> None:

        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        
        if r < 0 or c < 0 or r == self.m or c == self.n:
            return
        
        for dir in dirs:
            nr = r + dir[0]
            nc = c + dir[1]

            if(nr >= 0 and nc >= 0 and nr < self.m and nc < self.n):
                if grid[nr][nc] == '1':
                    grid[nr][nc] = '0'
                    self.helper(grid, nr, nc)
