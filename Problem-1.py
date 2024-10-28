#Approach
# maintain a visited array and start with 0,0 and explore all the reachable
#land once we come out of the land that is one island like that all the lands are checed


#Complexities
#Time: O(m*n)
#Space: O(m*n)



from typing import List
class Solution:
    def __init__(self):
        self.directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]

    def numIslands(self, grid: List[List[str]]) -> int:
        result = 0
        rows, columns = len(grid), len(grid[0])
        visited = [[False for _ in range(columns)] for _ in range(rows)]

        for i in range(rows):
            for j in range(columns):
                if not visited[i][j] and grid[i][j] == '1':
                    result += 1
                    self.dfs(grid, visited, i, j)
        return result

    def dfs(self, grid, visited, i, j):
        if not (0 <= i < len(grid) and 0 <= j < len(grid[0])) or visited[i][j] or grid[i][j] != '1':
            return

        visited[i][j] = True

        for [di, dj] in self.directions:
            nr, nc = i + di, j + dj
            self.dfs(grid, visited, nr, nc)



