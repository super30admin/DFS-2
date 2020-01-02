"""BFS approach"""
#Accepted on leetcode
#Time complexity - O(mn) as we are visting every element
#Space complexity - O(n) as we are using queue

from collections import deque
class Solution(object):
    m = 0
    n = 0
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        count = 0
        #Edge case
        if grid == None or len(grid) == 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]   
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    q = deque()
                    q.append((i,j))
                    grid[i][j] = '0'
                    while len(q) > 0:
                        curr = q.popleft()
                        for d in dirs:
                            r = curr[0] + d[0]
                            c = curr[1] + d[1]
                            if (0 <= r < m and 0 <= c < n and grid[r][c] == '1'):
                                q.append((r,c))
                                grid[r][c] = '0'
        return count