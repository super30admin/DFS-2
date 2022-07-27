

#complexity o(n)
#space complexit o(n)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
#         m = len(grid)
#         n = len(grid[0])
#         def mark(r, c):
#             if r < 0 or c < 0 or r > m-1 or c > n-1 or grid[r][c] != '1' :
#                 return
#             grid[r][c] = '2'
#             mark(r + 1, c)
#             mark(r - 1, c)
#             mark(r, c + 1)
#             mark(r, c - 1)

#             res = 0
#         for i in range(m):
#             for j in range(n):
#                 if grid[i][j] == '1':
#                     res += 1
#                     mark(i, j)
#         return res
        
        m = len(grid)
        n = len(grid[0])
        def mark(r, c):
            stack = [(r, c)]
            while stack:
                r, c = stack.pop()
                if r + 1 < m and grid[r + 1][c] == '1' and (r + 1, c) not in stack:
                    stack.append((r + 1, c))
                if r - 1 >= 0 and grid[r - 1][c] == '1' and (r - 1, c) not in stack:
                    stack.append((r - 1, c))
                if c + 1 < n and grid[r][c + 1] == '1' and (r, c + 1) not in stack:
                    stack.append((r, c + 1))
                if c - 1 >= 0 and grid[r][c - 1] == '1' and (r, c - 1) not in stack:
                    stack.append((r, c - 1))
                grid[r][c] = 2
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    res += 1
                    mark(i, j)
        return res
