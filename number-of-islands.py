'''
TC: O(m*n)
SC: O(m*n) (2mn - 1)

Intuition: Connected Components, inplace change
'''
class Solution(object):
    def numIslands(self, grid):
        if len(grid) == 0:
            return 0

        xlen = [1,-1,0,0]
        ylen = [0,0,-1,1]
        
        def issafe(a, b):
            if a>=0 and b>=0 and a<len(grid) and b<len(grid[0]):
                return True
            return False
        
        def dfs(x,y):
            for i in range(4):
                newx = x + xlen[i]
                newy = y + ylen[i]
                if issafe(newx, newy) and grid[newx][newy] == "1":
                    grid[newx][newy] = "0"
                    dfs(newx, newy)
        
        count = 0
        # visited = [[False for j in range(len(grid[0]))] for i in range(len(grid))]
        for l in range(len(grid)):
            for k in range(len(grid[0])):
                if grid[l][k] == "1":
                    grid[l][k] = "0"
                    count += 1
                    dfs(l,k)
        return count