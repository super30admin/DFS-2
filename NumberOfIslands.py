# Time Complexity : O(m*n)
# Space Complexity : O(min(m,n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The intuition is here to do a BFS once we find a 1 and make all neighbours 0. Do this until we find 1s without any
# neighbors being 1 and increment the count

class Solution:
    def numIslandsBFS(self, grid: List[List[str]]) -> int:
        count = 0
        m = len(grid)
        n = len(grid[0])
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]

        for r in range(m):
            for c in range(n):
                if grid[r][c] == '1':
                    # BFS
                    count += 1
                    queue = deque()
                    queue.append((r, c))
                    while queue:
                        cr, cc = queue.popleft()
                        for dx, dy in directions:
                            nr = cr + dx
                            nc = cc + dy
                            # Bounds check
                            if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] != '0':
                                grid[nr][nc] = '0'
                                queue.append((nr, nc))

        return count

# Time Complexity : O(m*n)
# Space Complexity : O(min(m,n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The intuition is here to do a DFS  very similar to BFS once we find a 1 and make all neighbours 0. Do this until we find
# all 1s without any neighbors being 1 and increment the count
class Solution:
    def numIslandsDFS(self, grid: List[List[str]]) -> int:
        count = 0
        m = len(grid)
        n = len(grid[0])
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]

        def dfs(r, c):
            if r < 0 or c < 0 or r == m or c == n or grid[r][c] == '0':
                return
            grid[r][c] = '0'
            for dx, dy in directions:
                dfs(r + dx, c + dy)

        for r in range(m):
            for c in range(n):
                if grid[r][c] == '1':
                    # DFS
                    count += 1
                    dfs(r, c)

        return count


