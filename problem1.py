#Time Complexity : O(m*n)
#Space Complexity : O(m*n)
#Any problem you faced while coding this : -

#The approach is a standard level-order traversal using a queue. Staarting with 1's, we add the vales to the queue and at each level we unmark the subsequent neighboring land values eventually counting islands based on each level.

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        count = 0
        q = collections.deque()
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    q.append([i,j])
                    grid[i][j] = '0'
                    while len(q)!= 0:
                        curr = q.popleft()
                        for d in dirs:
                            nr = curr[0] + d[0]
                            nc = curr[1] + d[1]
                            if nr >= 0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == '1':
                                q.append([nr,nc])
                                grid[nr][nc] = '0'

        return count