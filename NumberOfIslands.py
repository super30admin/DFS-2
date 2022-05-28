#Time complexity: O(mn)
#Space complexity: min of m and n
class Solution:
    def numIslands(self, grid) -> int:
        count=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if(grid[i][j]=="1"):
                    self.bfs(grid,i,j)
                    count+=1
        return count
    
    def bfs(self,grid,i,j):
        lst=[]
        lst.append([i,j])
        while(lst):
            (i,j)= lst.pop()
            if i>=0 and j >= 0 and i<len(grid) and j<len(grid[0]) and grid[i][j]=="1":
                lst.append([i,j-1])
                lst.append([i,j+1])
                lst.append([i-1,j])
                lst.append([i+1,j]) 
                grid[i][j]="0"
                
            
        
        
        
        