#Leet code -Number of Islands - 200 https://leetcode.com/problems/number-of-islands/
#Time complexity -O(M*N)
#space complexity - O(1)

#DFS Approach
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        count=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=='1':
                    count=count+1
                    self.dfs(grid,i,j)
        return count
        
    def dfs(self,grid,r,c):
     #base case
        if (r<0 or r>=len(grid) or  c<0 or c>=len(grid[0]) or grid[r][c]!='1'):
            return
        grid[r][c]='0'
        dir=[(1,0),(0,1),(-1,0),(0,-1)]
        for (i,j) in dir:
            new_r=i+r
            new_c=j+c
            self.dfs(grid,new_r,new_c)
            
            
            
#BFS approach

from collections import deque
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        
        if not grid :
            return 0
        queue=deque()
        dir=[(1,0),(0,1),(-1,0),(0,-1)]
        count=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=='1':
                    count=count+1
                    queue.append((i,j))
                    grid[i][j]='0'
                    
                    while queue:
                        curr=queue.popleft()
                        
                        for (x,y) in dir:
                            new_r=x+curr[0]
                            new_c=y+curr[1]
                            if (0<=new_r<len(grid) and  0<=new_c<len(grid[0]) and grid[new_r][new_c]=='1'): 
                                queue.append((new_r,new_c))
                                grid[new_r][new_c]='0'
                                
                                
        return count
            
        