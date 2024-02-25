#
# @lc app=leetcode id=200 lang=python3
#
# [200] Number of Islands
#

# @lc code=start
'''
Time Complexity - O(mn) for BFS and DFS 
Space Complexity - O(min(m,n))for BFS as max number of elements in a queue could be the longest diagonal in the grid.
                   O(mn) for DFS as it uses recursive stack and if all element are 1 all of them will be in the stack at 1 stage.

Both methods work on leetcode.                   

'''
from collections import deque
class Solution:
    def __init__(self):
        self.dirs = [[-1,0],[1,0],[0,-1],[0,1]]
    def numIslands(self, grid: List[List[str]]) -> int:
        q = deque() #create a queue
        m, n = len(grid), len(grid[0]) #get the number of rows and columns
        islandsCnt = 0 #set a counter for islangs
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1": #if we find a 1, its is a island, 
                     
                    q.append((i,j)) #we add it to queue to check its neighbors
                    grid[i][j] = "0" #and set it to 0 so that we dont fall in an endless cycle
                    while q: #while q is not empty 
                        pos = q.popleft() #take out first position from grid
                        r = pos[0] #get its row
                        c = pos[1] #get its column
                        for dir in self.dirs:#check neighbors in all four directions
                            nr = r+dir[0] 
                            nc = c+dir[1]
                            if nr>=0 and nr<m and nc>=0 and nc<n and grid[nr][nc]=="1": #if the neighbor is within bounds and is 1
                                grid[nr][nc] = "0" #set its value to 0
                                q.append((nr,nc)) #add it to queue to check its neighbors
                    # self.dfs(grid, i, j, m, n) #DFS way
                    islandsCnt+=1 #once queue is completed we increase the island count by 1 as we just found an island and we may have more. Hence we do this in a loop
        return islandsCnt #return the number of islands finally
    
    def dfs(self,grid, i, j, m, n):
        if i <0 or j <0 or i==m or j==n or grid[i][j]=="0": #if the grid position is out of bound or value is 0
            return #exit the current recursion
        grid[i][j] = "0" #else set the value at grid position to 0 so that we are not stuck in an endless recursion as we visit neighbors
        for dir in self.dirs: 
            nr = i + dir[0] 
            nc = j + dir[1]
            self.dfs(grid, nr, nc, m, n)# visit every neighbor one by one and check their neighbors.

        
# @lc code=end

