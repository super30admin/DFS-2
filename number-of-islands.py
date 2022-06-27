# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# BFS
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        from collections import deque
        count=0
        directions=[[1,0],[-1,0],[0,-1],[0,1]]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=='1':
                    count+=1
                    q=deque()
                    q.append((i,j))
                    while len(q)!=0:
                        curr=q.popleft()
                        for d in directions:
                            r=d[0]+curr[0]
                            c=curr[1]+d[1]
                            if 0<=r<len(grid) and 0<=c<len(grid[0]) and grid[r][c]=='1':
                                q.append((r,c))
                                grid[r][c]='0'
        return count
    
    
    
    # Time Complexity: O(m*n)
    # Space Complexity: O(m*n)
    # BFS
    # def numIslands(self, grid: List[List[str]]) -> int:
    #     count=0
    #     self.directions=[[1,0],[-1,0],[0,-1],[0,1]]
    #     for i in range(len(grid)):
    #         for j in range(len(grid[0])):
    #             if grid[i][j]=='1':
    #                 count+=1
    #                 self.dfs(grid,i,j)
    #     return count
    # def dfs(self,grid: List[List[str]],i:int,j:int):
    #     if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j]!='1': return 
    #     grid[i][j]='0'
    #     for d in self.directions:
    #         r=d[0]+i
    #         c=j+d[1]
    #         self.dfs(grid,r,c)
                            
                    
                    
        