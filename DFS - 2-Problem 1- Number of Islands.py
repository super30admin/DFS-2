"""
FAANMG Problem #67 {Medium}

200. Number of Islands

Time Complexity : O(N*M)

Space Complexity : O(min(m,n))


Did this code successfully run on Leetcode : Yes

BFS Solution

@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if(len(grid)==0):
            return 0
        
        rows = len(grid)
        cols = len(grid[0])
        
        count =0
        
        q = deque()
        
        directions = [ [0,1] , [1,0] , [0,-1] , [-1,0]]
        
        #loop through each elements
        for i in range(rows):
            for j in range(cols):
                
                #if we find 1 i.e Island, then we start the BFS from that node
                if(grid[i][j] =='1'):
                    #Increase the count
                    count +=1
                    
                    #add the node to the quess
                    q.append([i,j])
                    
                    #mark it Visited
                    grid[i][j] = 'v'
                    
                    #Loop untill the queue is empty
                    while q:
                        
                        #pop the added i and j value
                        r,c=q.popleft()
                        
                        #Iterate each of its neighbours 
                        for dr,dc in directions:
                            nr = dr +r
                            nc = dc +c
                            
                            #if the new row and the col is with the bounds and not visited
                            if( 0 <= nr <rows and 0<= nc < cols and grid[nr][nc]=='1'):
                                #mark it visited and add it to the queue
                                grid[nr][nc] ='v'
                                q.append([nr,nc])
        return count
                                
 """
FAANMG Problem #67 {Medium}

200. Number of Islands

Time Complexity : O(N*M)

Space Complexity : O(m*n)


Did this code successfully run on Leetcode : Yes

DFS Solution

@name: Rahul Govindkumar_RN27JUL2022
"""
                   
class Solution:
    
    def dfs(self, grid, r, c, rows, cols):
        
        #base
        if( 0 > r or r == rows or 0 > c or c==cols or grid[r][c]!='1'):
            return
        
        #logic
        grid[r][c] = 'v'
        
        for dr,dc in self.directions:
            nr = dr + r
            nc = dc + c
            self.dfs(grid,nr,nc,rows,cols )
            
        
        
        
        
        
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if(len(grid)==0):
            return 0
        
        rows = len(grid)
        cols = len(grid[0])
        
        count =0
        
    
        
        self.directions = [ [0,1] , [1,0] , [0,-1] , [-1,0]]
        
        #loop through each elements
        for i in range(rows):
            for j in range(cols):
                
                #if we find 1 i.e Island, then we start the BFS from that node
                if(grid[i][j] =='1'):
                    #Increase the count
                    count +=1
                    self.dfs(grid,i,j,rows,cols)
                    
                   
        return count
                                
                    
        
        
                
        

