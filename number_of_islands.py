"""
// Time Complexity : O(m*n) 
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
DFS 
- Updating the visited element in the grid by marking it as '0', since
it is not part of the island
- each DFS constitutes to be one count
"""
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        """
        1. Iterate over the grid and run dfs on non visited 1
        2. Dfs
            - mark the element visited
            - FOr valid direction and if ele is 1, call dfs
        """
        def dfs(grid,i,j,m,n):
            grid[i][j] = '0'
            directions = [(1,0),(0,1),(-1,0),(0,-1)]
            for x,y in directions:
                valx = x + i
                valy = y + j
                if valx >=0 and valx < m and valy >=0 and valy < n and grid[valx][valy]!='0':
                    dfs(grid,valx,valy,m,n)
        
        if not grid or not grid[0]:
            return 0
        m = len(grid)
        n = len(grid[0])
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    dfs(grid,i,j,m,n)
                    count+=1
        return count