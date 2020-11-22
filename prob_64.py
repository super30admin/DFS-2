# leecode - 200
# Island
# Time - O(mxn)
# space - O(1)
# DFS - Make all the islands and its connections 0 , once the count is incremented and this was traverse through the whole array
class Solution(object):
    # m =0
    # n=0
    # count = 0
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not (grid) or len(grid) == 0:
            return 0
        m = len(grid)  # rows
        n = len(grid[0])  # columsn
        count = 0
        # edge case

        for i in range(0, m,
                       1):  # iterate through the grid and if we found 1 then increment the count and by using dfs approach check for nearest 1's and make them 0.

            for j in range(0, n, 1):
                if grid[i][j] == '1':
                    count += 1  # 1st connected island so I increment here
                    self.helper_dfs(grid, i, j)
        return count

    def helper_dfs(self, grid, i, j):
        # base case
        if i < 0 or j < 0 or i >= len(grid) or j >= (len(grid[0])) or grid[i][j] == '0':
            return

        dirs = [(0, 1), (1, 0), (-1, 0), (0, -1)]
        grid[i][j] = '0'
        for dir in dirs:
            r = dir[0] + i
            c = dir[1] + j
            self.helper_dfs(grid, r,
                            c)  # connected island so make it to zero -- if we dont do this we will need a visited m X n matrix
            # self.helper_dfs(grid,row,col)
        # return




#without dirs array
#dfs
class Solution(object):
    # m =0
    # n=0
    # count = 0
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not (grid) or len(grid) == 0:
            return 0
        m = len(grid)  # rows
        n = len(grid[0])  # columsn
        count = 0
        # edge case

        for i in range(0, m,
                       1):  # iterate through the grid and if we found 1 then increment the count and by using dfs approach check for nearest 1's and make them 0.

            for j in range(0, n, 1):
                if grid[i][j] == '1':
                    count += 1  # 1st connected island so I increment here
                    self.helper_dfs(grid, i, j)
        return count

    def helper_dfs(self, grid, i, j):
        # base case
        if i < 0 or j < 0 or i >= len(grid) or j >= (len(grid[0])) or grid[i][j] == '0':
            return

        grid[i][j] = '0'

        self.helper_dfs(grid, i + 1, j)
        self.helper_dfs(grid, i - 1, j)
        self.helper_dfs(grid, i, j - 1)
        self.helper_dfs(grid, i, j + 1)

        # connected island so make it to zero -- if we dont do this we will need a visited m X n matrix
        # self.helper_dfs(grid,row,col)
        # return


# leecode - 200
# Island -BFS
# Time - O(mxn)
# space - O(m X n)
# Make all the islands and its connections 0 , once the count is incremented and this was traverse through the whole array
class Solution(object):
    # m =0
    # n=0
    # count = 0
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        m = len(grid)  # if we declare n here, it will tro an error for an epty gris case
        if not (grid) or m == 0:
            return 0
        # rows
        n = len(grid[0])  # columsn
        count = 0
        # edge case
        q = []

        for i in range(
                m):  # iterate through the grid and if we found 1 then increment the count and by using Bfs approach check for nearest 1's and make them 0.

            for j in range(n):
                if grid[i][j] == '1':
                    count += 1  # 1st connected island so I increment here
                    q.append((i, j))
                    grid[i][j] = 0
                    dirs = [(0, 1), (1, 0), (-1, 0), (0, -1)]
                    while q:
                        curr = q.pop(0)  # poppin from current index

                        for dir in dirs:
                            r = curr[0] + dir[0]
                            c = curr[1] + dir[1]

                            if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == '1':
                                grid[r][c] = 0
                                q.append((r, c))
        return count






