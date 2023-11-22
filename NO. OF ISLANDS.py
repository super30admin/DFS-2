# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        q = collections.deque()
        def bfs(r, c):
            q.append((r, c))
            grid[r][c] = '0'

            while q:
                directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
                r, c = q.popleft()
                #grid[r][c] = '0'
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                
                    if min(nr, nc) < 0 or nr >= rMax or nc >= cMax:
                        continue
                    if grid[nr][nc] == '0':
                        continue
                
                    q.append((nr, nc))
                    grid[nr][nc] = '0'

        rMax, cMax = len(grid), len(grid[0])
        count = 0
        for r in range(rMax):
            for c in range(cMax):
                if grid[r][c] == '1':
                    count += 1
                    bfs(r, c)
        return count