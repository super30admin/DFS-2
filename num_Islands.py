from collections import deque
class Solution:
    """DFS Implementation
    Time Complexity-O(2(m*n)) as when we encounter a 1, we perform dfs on it and
    set all the child nodes(which are 1) val to 0. but again as we are having two for loops we again go to those elements and check if they are 1.so each node will be touched twice in worst case
    Space Complexity-O(m*n) as m*n elements will go to recursive stack"""
    def __init__(self):
        self.count=0
        self.dirs=[[1,0],[0,1],[-1,0],[0,-1]]
    
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=="1":
                    self.count+=1
                    self.dfs(grid, i, j)
        return self.count
    
    def dfs(self, grid, i, j):
        if i<0 or i==len(grid) or j<0 or j==len(grid[0]) or grid[i][j]!="1":
            return
        grid[i][j]="0"
        for dir in self.dirs:
            nr=i+dir[0]
            nc=j+dir[1]
            self.dfs(grid, nr, nc)
            
                
        
    """BFS implementation
    Time complexity-O(m*n)
    Space Complexity-O(min(m,n)) as we itertate from the first element of the grid and start doing bfs where the value is found to be 1 and need not consider its previous elements which are its children."""
    # def numIslands(self, grid: List[List[str]]) -> int:
    #     if not grid:
    #         return 0
    #     q=deque()
    #     count=0
    #     dirs=[[1,0],[0,1],[-1,0],[0,-1]]
    #     for i in range(len(grid)):
    #         for j in range(len(grid[0])):
    #             if grid[i][j]=="1":
    #                 count+=1
    #                 q.append([i,j])
    #                 grid[i][j]="0"
    #                 while q:
    #                     size=len(q)
    #                     for k in range(len(q)):
    #                         r,c=q.popleft()
    #                         for dir in dirs:
    #                             nr=r+dir[0]
    #                             nc=dir[1]+c
    #                             if nr>=0 and nc>=0 and nr<len(grid) and nc<len(grid[0]) and grid[nr][nc]=="1":
    #                                 q.append([nr, nc])
    #                                 grid[nr][nc]="0"
    #     return count
                                
                            
                            
        