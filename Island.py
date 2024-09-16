#Time Complexity:O(N) where N is number of element
#Space Complexity : O(N) where N  is Number of elements
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if len(grid) == None:
            return 0
        count =0
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        def dfs(grid,i,j):
            if i <0 or j<0 or i >=len(grid) or j>=len(grid[0]) or grid[i][j]=='0':
                return
            grid[i][j]='0'
            for k in dirs:
                r = i+ k[0]
                c = j+ k[1]
                dfs(grid,r,c)
        
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    count+=1
                    dfs(grid,i,j)
        return count
        