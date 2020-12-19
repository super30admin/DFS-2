# Approach: DFS Recursive

# In this approach we will start from a cell having value "1" which will the start of our first island. Then we will keep visiting all of the neighbours with value "1" and mark them visited. If we reach a point where there are no neigbours with value '1' then we will again search the matrix for next '1', which would be start of another anothe island. We will keep doing this untill all the cells has been visited.

# Time complexity: O(m*n); m = rows and n=columns
# Space complexity: O(min(m,n)); m = rows and n=columns
# class Solution:
#     def numIslands(self, grid: List[List[str]]) -> int:
#         if grid == None or len(grid) == 0:
#             return 0
        
#         self.m = len(grid)
#         self.n = len(grid[0])
#         cnt = 0
        
#         for i in range(self.m):
#             for j in range(self.n):
#                 if grid[i][j] == '1':
#                     cnt += 1
#                     self.dfs(grid,i,j)
                    
#         return cnt
    
#     def dfs(self, grid, row, col):
        
#         if row<0 or col<0 or row>=self.m or col>=self.n or grid[row][col] != '1':
#             return 
        
#         grid[row][col] = '2'
#         dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        
#         for d in dirs:
#             r = row + d[0]
#             c = col + d[1]
#             self.dfs(grid,r,c)
                    
# Appraoch: Iterative

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        
        m = len(grid)
        n = len(grid[0])
        cnt = 0
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        
        q = []
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    cnt += 1
                    q.append([i,j])
                    
                    while len(q) != 0:
                        curr = q.pop(0)
                        for d in dirs:
                            r = curr[0] + d[0]
                            c = curr[1] + d[1]
                            if r>=0 and c>=0 and r<m and c<n and grid[r][c] == '1':
                                grid[r][c] = '2'
                                q.append([r,c])
                                
        return cnt
        
        
        

        