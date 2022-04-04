    # Time Complexity : O(mn)
    # Space Complexity : O(mn)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No



class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        q=[]
        count = 0
        grid_dir=[[0,1],[0,-1],[1,0],[-1,0]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    grid[i][j]='0'
                    q.append([i,j])
                    while(q):
                        curr=q.pop(0)
                        for d in grid_dir:
                            r=curr[0] + d[0]
                            c=curr[1] + d[1]
                            if r>=0 and c>=0 and r<m and c<n and grid[r][c]=='1':
                                q.append([r,c])
                                grid[r][c]='0'
                                
        return count
                                
                        
                    