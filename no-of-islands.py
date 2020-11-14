class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if grid == [] or len(grid) == 0:
            return 0
        from collections import deque
        q = deque()
        islands = 0

        def dfs(grid, x, y):

            if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]) or grid[x][y] == '0':
                return
            grid[x][y] = '0'
            dfs(grid, x + 1, y)
            dfs(grid, x, y + 1)
            dfs(grid, x - 1, y)
            dfs(grid, x, y - 1)

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    # grid[i][j]='0'
                    dfs(grid, i, j)

                    # q.append((i,j))
                    # while q:
                    #     pop=q.popleft()
                    #     for dir in dirs:
                    #         x=pop[0]+dir[0]
                    #         y=pop[1]+dir[1]
                    #         if x>=0 and x<len(grid) and y>=0 and y<len(grid[0]) and grid[x][y]=='1':
                    #             grid[x][y]='0'
                    #             q.append((x,y))
                    islands += 1

        return islands
    # bfs- time-O(mn) space-O(min(m,n))
    # dfs- time-O(n) and space-O(mn)
