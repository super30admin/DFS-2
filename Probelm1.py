"""
I used the DFS traversal technique as discussed, to explore and mark all connected land cells in the grid. Each time a new unvisited land cell is found, DFS is triggered to mark the entire island.
Time Complexity: O(nm)
Space Complexity: O(nm)
"""
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]:
            return 0

        self.m = len(grid)
        self.n = len(grid[0])
        count = 0

        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == '1':
                    count += 1
                    self.dfs(grid, i, j)
        
        return count

    def dfs(self, grid: List[List[str]], i: int, j: int):
        if i < 0 or i >= self.m or j < 0 or j >= self.n or grid[i][j] == '0':
            return

        grid[i][j] = '0'

        directions = [(0,1), (1,0), (-1,0), (0,-1)]
        for dr, dc in directions:
            self.dfs(grid, i + dr, j + dc)   