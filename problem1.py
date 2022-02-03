#TIme Complexity =O(n)
#Space Complexity = O(h)


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if(grid==None or len(grid)==0):
            return 0
        count= 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if(grid[i][j]=="1"):
                    count+=1
                    self.helper(grid,i,j)
        return count
                    
    def helper(self,grid,i,j):
        if(i<len(grid) and i>=0 and j<len(grid[0]) and j>=0 and grid[i][j]=="1"):
            grid[i][j] = "0"
            di = [[0,1],[1,0],[-1,0],[0,-1]]
            for x,y in di:
                a = x+i
                b = y+j
                self.helper(grid,a,b)
                
                
        else:
            return 
                
            
            