# Time Complexity is O(mn)
# Space Complexity is O(mn) for the stack space, where mxn is the grid dimension
# Perform DFS to identify the island whenever we encounter a '1' in the grid
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        def val(i,j):
            if(0 <= i < len(grid) and 0<= j <len(grid[0])):
                return grid[i][j]
            return "0"
        
        def dfs(i,j):
            stack = [(i,j)]
            #visited = set()
            dirs = [(-1,0),(1,0),(0,-1),(0,1)]
            while(stack):
                i,j  = stack.pop()
                for d in dirs:
                    r = i+d[0]
                    c = j+d[1]
                    if(val(r,c) == "1"):
                        grid[r][c] = "-1"
                        stack.append((r,c))
            return
        
        
        count = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if(val(i,j) == "1"):
                    grid[i][j] = "-1"
                    dfs(i,j)
                    count+=1
        return count