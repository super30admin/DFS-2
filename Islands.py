'''
    Time Complexity:
        O(mn) (where m = number of rows of grid, n = number of columns of grid)

    Space Complexity:
        O(mn) (where m = number of rows of grid, n = number of columns of grid)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        DFS approach.
        Start at the point where you find a Land.
        DFS all the neighboring lands and mark them covered.
'''
LAND = '1'

class Solution:
    def __init__(self):
        self.grid = []
        self.visited = []
        self.islands = 0

    def numIslands(self, grid: List[List[str]]) -> int:
        self.grid = grid

        if self.grid and self.grid[0]:
            self.count_islands()

        return self.islands

    def count_islands(self):
        self.visited = [[False] * len(self.grid[0]) for _ in range(len(self.grid))]

        for i, row in enumerate(self.grid):
            for j, area in enumerate(row):
                if area == LAND and not self.visited[i][j]:
                    self.islands += 1
                    self.cover_island(i, j)

    def cover_island(self, i, j):
        if i not in range(len(self.grid)):
            return

        if j not in range(len(self.grid[i])):
            return

        if self.grid[i][j] != LAND or self.visited[i][j]:
            return

        self.visited[i][j] = True
        self.cover_island(i + 1, j)
        self.cover_island(i - 1, j)
        self.cover_island(i, j + 1)
        self.cover_island(i, j - 1)
