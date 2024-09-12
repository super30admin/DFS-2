'''
Iterative:
Time Complexity: O(m*n)
Space Complexity: O(m*n)
Did this code successfully run on Leetcode : Yes
Explanation: Apply DFS to visiit all the islands, set the element to 2 if we visit it and it should be a '1' which is
basically an Island, while iterating through DFS count the number of islands and return it
'''


class Solution:
    def isValid(self, grid: List[List[str]], row: int, col: int, x: int, y: int) -> int:
        return x >= 0 and x < row and y >= 0 and y < col

    def dfsVisit(self, grid: List[List[str]], row: int, col: int, x: int, y: int) -> int:
        # mark as visited
        grid[x][y] = '2'
        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]
        # lets try 4 neighbors
        for i in range(0, 4):
            x1 = x + dx[i]
            y1 = y + dy[i]
            if self.isValid(grid, row, col, x1, y1) and grid[x1][y1] == '1':
                self.dfsVisit(grid, row, col, x1, y1)

    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0:
            return 0

        m = len(grid)
        n = len(grid[0])
        count = 0
        for i in range(0, m):
            for j in range(0, n):
                if grid[i][j] == '1':
                    count += 1
                    self.dfsVisit(grid, m, n, i, j)

        return count