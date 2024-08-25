# Time and Space complexity - O(m*n)

# DFS approach
    def numIslands(self, grid: List[List[str]]) -> int:
        pos = [[0,1], [1,0], [-1,0], [0,-1]]

        m = len(grid)
        n = len(grid[0])
        count = 0

        def dfs(i,j,m,n):
            grid[i][j] = "0"

            for a,b in pos:
                r,c = i + a, j + b
                if 0 <= r < m and 0 <= c < n and grid[r][c] == "1":
                    dfs(r,c,m,n)

        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    dfs(i,j,m,n)
                    count += 1
        return count


# BFS
# Time complexity - O(m*n)
# Space complexity = min(m,n) as queue will have max elements equal to its diagonal elements
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        pos = [[0,1], [1,0], [-1,0], [0,-1]]

        m = len(grid)
        n = len(grid[0])
        queue = deque()

        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    queue.append((i,j))
                    grid[i][j] = "0"
                    while queue:
                        x,y = queue.popleft()
                        for a,b in pos:
                            r,c = x + a, y + b
                            if 0 <= r < m and 0 <= c < n and grid[r][c] == "1":
                                grid[r][c] = "0"
                                queue.append((r,c))
                    count += 1

        return count
