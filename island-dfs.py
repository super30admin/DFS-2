"""DFS approach"""
#Accepted by leetcode
#Time complexity - O(mn) as we are visting every element
#Space complexity - O(n) if we consider recursive stack otherwise O(1)

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
        def dfs(grid,i,j):
            #Base case
            if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] == '0':
                return
            dirs = ((1,0),(0,1),(0,-1),(-1,0))
            grid[i][j] = '0'
            for d in dirs:
                r = i + d[0]
                c = j + d[1]
                dfs(grid,r,c)
                
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    dfs(grid,i,j)
        return count   