# time : 0(MN)
#space  : 0(1)
class Solution(object):
    def dfs(self,grid,i,j):
        if i <0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j]!='1':
            return 0
        grid[i][j] = '0'
        self.dfs(grid,i+1,j)
        self.dfs(grid,i-1,j)
        self.dfs(grid,i,j+1)
        self.dfs(grid,i,j-1)
        return 1
    def numIslands(self, grid):
        if not grid:
            return 0
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    count +=self.dfs(grid,i,j)
        return count
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        