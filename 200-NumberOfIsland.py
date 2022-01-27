class Solution:
    def dfs(self, grid, r, c):
        grid[r][c] = '0'
        lst = [(r-1, c),(r+1, c),(r, c-1),(r, c+1)]
        for row, col in lst:
            if row>=0 and col >=0 and row < len(grid) and col < len(grid[row]) and grid[row][col] == '1':
                self.dfs(grid, row, col)
    
    def numIslands(self, grid: List[List[str]]) -> int:
        island = 0
        for r in range(len(grid)):
            for c in range(len(grid[r])):
                if grid[r][c] == '1':
                    self.dfs(grid, r, c)
                    island += 1
        return island
    
# T.C = >O(m * n) Length of the matrix
# S.C => O(n) => using recursion and uses stack in background
# Approach => Here we find all the elemets in the matrix that are equal to 1 and checks its 
# all direction. As we collect number 1 we add the island count always.
# Thus when recursion unfolds we get the total count of the island 