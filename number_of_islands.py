class Solution(object):
    # T.C is O(mn)
    # S.C is O(minimum of m or minimum of n)
    # all test cases passed in leetcode

    from collections import deque
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        row_length = len(grid)
        column_length = len(grid[0])

        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        queue = deque()
        islands = 0

        # Find the island when grid value is '1' complete the whole island and come back to search for new island
        for row in range(row_length):
            for column in range(column_length):
                if grid[row][column] == '1':
                    grid[row][column] = '0'
                    queue.append([row, column])

                    islands += 1

                    # Complete 1 island then come out of loop and check for next island
                    while queue:
                        processing_ele = queue.popleft()
                        for dir_move in dirs:
                            nr = dir_move[0] + processing_ele[0]
                            nc = dir_move[1] + processing_ele[1]

                            if nr >= 0 and nr < row_length and nc >= 0 and nc < column_length and grid[nr][nc] == '1':
                                grid[nr][nc] = '0'
                                queue.append([nr, nc])

        return islands


class Solution(object):
    from collections import deque
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        self.row_length = len(grid)
        self.column_length = len(grid[0])

        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        self.queue = deque()
        self.islands = 0

        for row in range(self.row_length):
            for column in range(self.column_length):
                if grid[row][column] == '1':
                    grid[row][column] = '0'
                    self.islands += 1

                    self.dfs(grid, row, column)

        return self.islands

    def dfs(self, grid, row, column):
        for dir_move in self.dirs:
            nr = dir_move[0] + row
            nc = dir_move[1] + column

            if nr >= 0 and nr < self.row_length and nc >= 0 and nc < self.column_length and grid[nr][nc] == '1':
                grid[nr][nc] = '0'
                self.dfs(grid, nr, nc)
