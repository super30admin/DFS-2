from collections import deque


# Time COmplexity: O(mxn)
# Space Complexity: O(mxn)
class Solution(object):
    direc = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    result = 0

    # implementation using bfs insert into queue and pop the element and check for. boundaries and value of the location and update it to 0 and append to queueu
    def bfs(self, i, j, grid):
        q = deque()

        q.append((i, j))

        while q:
            row, col = q.popleft()

            for d in self.direc:
                r = row + d[0]
                c = col + d[1]

                if len(grid) > r >= 0 and len(grid[0]) > c >= 0 and grid[r][c] == '1':
                    grid[r][c] = 0
                    q.append((r, c))

    #     Dfs approach , where we will check if current node is out of bound and element value is 0 the return or else chnage it to 0 and call the function on its childrens
    def dfs(self, i, j, grid):

        if i < 0 or j < 0 or len(grid) <= i or len(grid[0]) <= j or grid[i][j] == '0':
            return

        grid[i][j] = '0'
        for d in self.direc:
            r = i + d[0]
            c = j + d[1]

            self.dfs(r, c, grid)

    def numIslands(self, grid):
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    # self.bfs(i, j, grid)
                    self.dfs(i, j, grid)
                    self.result += 1

        return self.result

        """
        :type grid: List[List[str]]
        :rtype: int
        """
