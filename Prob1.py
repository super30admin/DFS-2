#Time complexity for put and get: O(m*n)
#Space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        self.dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        # self.numIslands = 0
        # #DFS
        # def helper(grid,i,j):
        #     #base
        #     if i<0 or j<0 or i>=len(grid) or j >= len(grid[0]) or grid[i][j] != '1':
        #         return
        #     #logic
        #     grid[i][j] = '0'
        #     for d in self.dirs:
        #         ni = i + d[0]
        #         nj = j + d[1]
        #         helper(grid,ni,nj)
        # for i in xrange(len(grid)):
        #     for j in xrange(len(grid[0])):
        #         if grid[i][j] == '1':
        #             self.numIslands += 1
        #             helper(grid,i,j)
        # return self.numIslands
                
        #BFS
        numIslands = 0
        q = deque()
        for i in xrange(len(grid)):
            for j in xrange(len(grid[0])):
                if grid[i][j] == '1':
                    numIslands += 1
                    q.append((i,j))
                    while q:
                        node = q.popleft()
                        grid[node[0]][node[1]] = '0'
                        for d in self.dirs:
                            ni = node[0] + d[0]
                            nj = node[1] + d[1]
                            if ni>=0 and nj>=0 and ni < len(grid) and nj < len(grid[0]) and grid[ni][nj]=='1':
                                grid[ni][nj] = '0'
                                q.append((ni,nj))
        return numIslands
                            