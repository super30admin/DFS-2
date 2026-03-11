# https://leetcode.com/problems/number-of-islands/description/

# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

# BFS solution
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        q = deque()
        m = len(grid)
        n = len(grid[0])
        dirs = [(1,0), (-1,0), (0,1), (0,-1)]
        count = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    q.append([i,j])
                    grid[i][j] = '0'

                    while len(q) > 0:
                        curr = q.popleft()

                        for dir in dirs:
                            r = curr[0] + dir[0]
                            c = curr[1] + dir[1]

                            if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == '1':
                                grid[r][c] = '0'
                                q.append([r,c])

        return count