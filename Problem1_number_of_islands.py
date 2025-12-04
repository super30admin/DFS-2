class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        rows, cols =  len(grid), len(grid[0])
        islands = 0

        def dfs(r, c):
            if r<0 or r>=rows or c<0 or c>=cols:
                return
            #if water or visited
            if grid[r][c] != '1':
                return

            # Water or already visited
            grid[r][c] = '0'
            
            # Explore neighbors (4-directional)
            dfs(r + 1, c)  # down
            dfs(r - 1, c)  # up
            dfs(r, c + 1)  # right
            dfs(r, c - 1)  # left


        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == '1':
                    islands+=1
                    dfs(row, col)

        return islands
