"""
Runtime Complexity:
O(m*n) - we traverse 'm' rows and 'n' columns to check whether we have 1 or not. 
Space Complexity:
O(min(m*n)) - the stack does not store all the elements in it. It just endup with only diagonal elements. Therefore its the min of m and n.
Yes, the code worked on leetcode.
The idea behind the algorithm is to traverse the grid and when we find 1 we change it to 0 and continue the iteration. We use 'total' variable to count the number of 
islands and just return it.   
"""


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        total = 0
        if not grid or len(grid)==0:
            return 0
        dirs = [(-1,0),(1,0),(0,-1),(0,1)]
        m = len(grid)
        n = len(grid[0])
        q = []
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    total+=1
                    
                    grid[i][j] ="0"
                    q.append([i,j])
                    
                    while q:
                        curr = q.pop(0)
                        for d in dirs:
                            nr = curr[0] +d[0]
                            nc = curr[1] + d[1]
                            
                            if(nr>=0 and nr<m and nc>=0 and nc<n and grid[nr][nc]=="1"):
                                q.append([nr,nc])
                                grid[nr][nc] = "0"
                                
        return total
                        
                        
        