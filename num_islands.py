# DFS
# // Time Complexity : O(mn) where m,n are rows and cols of the grid
# // Space Complexity : O(mn)
# BFS
# // Time Complexity : O(mn) where m,n are rows and cols of the grid
# // Space Complexity : O(min(m,n))
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

class Solution:
    def dfs(self,i,j,grid):
        for dx,dy in self.directions:
            if 0 <= i+dx < self.rows and 0 <= j+dy < self.cols and grid[i+dx][j+dy] == '1':
                grid[i+dx][j+dy] = '2'
                self.dfs(i+dx,j+dy,grid)
    def numIslands(self, grid: List[List[str]]) -> int:
        # BFS
        queue = deque()
        count = 0
        rows = len(grid)
        cols = len(grid[0])
        directions = [[0,1],[1,0],[-1,0],[0,-1]]
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    queue.append([i,j])
                    grid[i][j] = '2'
                    while queue:
                        x,y = queue.popleft()
                        for dx,dy in directions:
                            if 0 <= x+dx < rows and 0 <= y+dy < cols and grid[x+dx][y+dy] == '1':
                                queue.append([x+dx,y+dy])
                                grid[x+dx][y+dy] = '2'
                    count += 1
        return count
  
        
        # # DFS
        # # self.grid = grid
        # count = 0
        # self.rows = len(grid)
        # self.cols = len(grid[0])
        # self.directions = [[0,1],[1,0],[-1,0],[0,-1]]
        # for i in range(self.rows):
        #     for j in range(self.cols):
        #         if grid[i][j] == '1':
        #             grid[i][j] = '2'
        #             self.dfs(i,j,grid)
        #             count += 1
        # return count
