# // Time Complexity : O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
class Solution:
    dirs = list()
    count = 0
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        m = len(grid) 
        n = len(grid[0])
        self.dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        q = list()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self.count += 1
                    q.append([i,j])
                    grid[i][j] == '0'
                    while(q):
                        curr = q.pop(0)
                        for direction in self.dirs:
                            r = curr[0] + direction[0]
                            c = curr[1] + direction[1]
                            if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == '1':
                                q.append([r,c])
                                grid[r][c] = '0'
                                
        return self.count
        
    
        
        