# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0 or len(grid[0]) == 0:
            return 0
        count = 0
        q = deque()
        nei = [(0,1), (1,0), (-1,0), (0,-1)]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    count += 1
                    q.append((i,j))
                    
                    while len(q) != 0:
                        curr = q.popleft()
                        for k in nei:
                            r = curr[0] + k[0]
                            c = curr[1] + k[1]
                            
                            if r >= 0 and r < len(grid) and c >= 0 and c < len(grid[0]):
                                if grid[r][c] == '1':
                                    q.append((r,c))
                                    grid[r][c] = '0'
                                    
                        
        return count