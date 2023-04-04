# Time Complexity : O(mn), where m and n is the dimensions of the grid
# Space Complexity : O(mn), where m and n is the dimensions of the grid

from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # function to mark all connected land as visited
        def mark_visited(grid, i, j, visited):
            visited[i][j] = True
            
            # check all adjacent cells
            if i > 0 and grid[i-1][j] == "1" and not visited[i-1][j]:
                mark_visited(grid, i-1, j, visited)
            if i < len(grid) - 1 and grid[i+1][j] == "1" and not visited[i+1][j]:
                mark_visited(grid, i+1, j, visited)
            if j > 0 and grid[i][j-1] == "1" and not visited[i][j-1]:
                mark_visited(grid, i, j-1, visited)
            if j < len(grid[0]) - 1 and grid[i][j+1] == "1" and not visited[i][j+1]:
                mark_visited(grid, i, j+1, visited)
        
        # initialize visited array
        visited = [[False for j in range(len(grid[0]))] for i in range(len(grid))]
        
        # count number of islands
        count = 0
        
        # loop through each cell in the grid
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                # if cell is unvisited and land is found
                if not visited[i][j] and grid[i][j] == "1":
                    mark_visited(grid, i, j, visited)
                    count += 1
        
        return count