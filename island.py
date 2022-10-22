'''
Time Complexity: O(m*n)
Space Complexity: O(m+n)
'''
from collections import deque
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        q = deque([])
        count = 0
        rows = len(grid)
        cols = len(grid[0])
        direction = [[-1, 0], [1,0], [0,1], [0,-1]]
        def dfs(nr, nc):
            for i in direction:
                nnr = nr+i[0]
                nnc = nc+i[1]
                if(nnr>=0 and nnr<rows and nnc>=0 and nnc<cols and grid[nnr][nnc]=='1'):
                    grid[nnr][nnc] = '0'
                    dfs(nnr, nnc)
            return

        for i in range(rows):
            for j in range(cols):
                if(grid[i][j]=='1'):
                    count +=1
                    grid[i][j] = '0'
                    #q.append([i,j])
                    dfs(i,j)
        return count
