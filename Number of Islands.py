# Time complexity : O(n), Space complexity : O(n)
# The code ran on LeetCode

# Traverse over the matrix and update the counter when a new land regions is found. Maintain a visited set to keep track of all the visited regions. Perform a dfs traversal starting from the new land region to get all the connected components.

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        visited = set()
        cnt = 0
        def dfs(x, y):

            for dx, dy in dirs:
                x_new = x + dx; y_new = y + dy

                if 0 <= x_new < m and 0 <= y_new < n and (x_new, y_new) not in visited and grid[x_new][y_new] == '1':
                    visited.add((x_new, y_new))
                    dfs(x_new, y_new)


        m = len(grid); n = len(grid[0])

        for i in range(m):
            for j in range(n):
                if int(grid[i][j]) == 1 and (i, j) not in visited:
                    cnt += 1
                    visited.add((i, j))
                    dfs(i, j)

        return cnt