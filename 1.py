'''
DFS-2

Problem1 (https://leetcode.com/problems/number-of-islands/)
'''

from queue import Queue

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int: # type: ignore
        if grid == None or len(grid) == 0:
            return 0

        q = Queue()
        count = 0
        m = len(grid)
        n = len(grid[0])

        dirs = [[-1,0], [0,-1], [0,1], [1,0]]

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count = count + 1
                    q.put([i,j])
                    grid[i][j] = '0'
                    while not q.empty():
                        curr = q.get()
                        for Dir in dirs:
                            nr = curr[0]+Dir[0]
                            nc = curr[1]+Dir[1]
                            if nr >= 0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == '1':
                                q.put([nr,nc])
                                grid[nr][nc] = '0'

        return count                       
        