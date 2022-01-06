# Time: O(n*n)
# Space: O(n*n)
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        visited = [[False for x in range(len(grid[0]))] for y in range(len(grid))]
        #print(visited)
        ans = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                #print(grid[i][j],visited[i][j] )
                if grid[i][j] == '1' and visited[i][j] == False:
                    print('sdlvnnlj')
                    self.dfs(visited, i, j, grid)
                    ans += 1
        #print(visited)
        return ans
                    
    def dfs(self, visited, x,y , grid):
        visited[x][y] = True
        if x-1 >= 0:
            if grid[x-1][y] == '1' and visited[x-1][y] == False:
                self.dfs(visited, x-1, y, grid)
        if x+1 < len(grid):
            if grid[x+1][y] == '1' and visited[x+1][y] == False:
                self.dfs(visited, x+1, y, grid)
        if y-1 >=0:
            if grid[x][y-1] == '1' and visited[x][y-1] == False:
                self.dfs(visited, x, y-1, grid)
        if y+1 < len(grid[0]):
            if grid[x][y+1] == '1' and visited[x][y+1] == False:
                self.dfs(visited, x, y+1, grid)
        return
        
        
        
        
        
