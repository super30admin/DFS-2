# // Time Complexity :O(m*n) for matrix traversal + m*n dfs 
# // Space Complexity :O(m*n) for stack max
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : recursion basecase was incorrect

# // Your code here along with comments explaining your approach

#dfs
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dirs = [(-1,0),(1,0),(0,1),(0,-1)]
                
        count = 0
        # we use dfs when we find 1 on all 4 sides.
        def dfs(r,c):
            #base
            if r < 0 or r == m or c < 0 or c == n or grid[r][c] != '1':
                return 
            # if inbounds? make current visited and check all 4 sides
            grid[r][c] = "0"
            for di in dirs:
                dfs(di[0]+r,di[1]+c)                # recursion is called on all 4 sides till boundary
        # if 1 is found, increase count and call recurison
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count +=1
                    dfs(i,j)

        return count


# from collections import deque

#bfs
# class Solution:
#     def numIslands(self, grid: List[List[str]]) -> int:
#         m = len(grid)
#         n = len(grid[0])
#         dirs = [(-1, 0), (1, 0), (0, 1), (0, -1)]
#         count = 0
#         q = deque()

#         for i in range(m):
#             for j in range(n):
#                 if grid[i][j] == "1":
#                     count += 1
#                     q.append((i, j))

#                     while q:
#                         curr = q.popleft()
#                         for di in dirs:
#                             r = di[0] + curr[0]
#                             c = di[1] + curr[1]

#                             if 0 <= r < m and 0 <= c < n and grid[r][c] == "1":
#                                 grid[r][c] = 0
#                                 q.append((r, c))

#         return count
