#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully


class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if grid is None or len(grid) == 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        count = 0
        rq = []
        cq = []
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    rq.append(i)
                    cq.append(j)
                    grid[i][j] ='0'
                    while rq:
                        cr = rq.pop(0)
                        cc = cq.pop(0)
                        for dir in dirs:
                            nr = dir[0] + cr
                            nc = dir[1] + cc
                            
                            if nr >= 0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == '1':
                                rq.append(nr)
                                cq.append(nc)
                                grid[nr][nc] = '0'
                                
        return count