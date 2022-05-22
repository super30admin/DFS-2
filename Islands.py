# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """

        rows = len(grid)
        cols = len(grid[0])
        visited = set()
        islands = 0

        def recursion(row, col):
            if row < 0 or row >= rows:
                return 0
            if col < 0 or col >= cols:
                return 0
            visited.add((row, col))

            if grid[row][col] == "0":
                return 0

            # left
            if (row, col-1) not in visited:
                recursion(row, col-1)
            # right
            if (row, col+1) not in visited:
                recursion(row, col + 1)
            # Up
            if (row - 1, col) not in visited:
                recursion(row-1, col)
            # down
            if(row + 1, col) not in visited:
                recursion(row+1, col)

            return 1

        for row in range(rows):
            for col in range(cols):
                # print(row,col, visited)
                if (row, col) not in visited and grid[row][col] == "1":
                    # print(visited)
                    islands = islands + recursion(row, col)
        return islands
