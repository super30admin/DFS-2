#Time Complexity :  O(mn)
#Space Complexity : O(mn)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if len(grid)==0:
            return 0
        
        m = len(grid)
        n = len(grid[0])
        count = 0
        dirs = [[0,-1],[0,1],[1,0],[-1,0]]
        for row in range(m):
            for col in range(n):
                if grid[row][col]=="1":
                    count+=1
                    
                    def dfs(r,c):
                  
                        if (r<0 or r>=m) or  (c<0 or c>=n) or grid[r][c]!="1":
                            return 
                        grid[r][c]="0"
                        for item in dirs:
                            r1 = item[0]+r
                            c1 = item[1]+c
                            dfs(r1,c1)
                    dfs(row,col) 
                                
        return count
                    
                