## Problem1 (https://leetcode.com/problems/number-of-islands/)

# Method1: Using BFS
# M -- No. of Rows
# N -- No. of Cols
# Time Complexity : O(M*N) + O(M*N) = O(M*N) -- outer traversal of nodes + worst case all BFS would add to O(M*N)
# Space Complexity : O(min(M, N)) -- In worst case BFS, elements would be added to the queue level by level. So max would be at the diagonal
# which would be min(num of rows, num of cols)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We traverse all the nodes of the matrix. Wherever we find "1", our num of islands count increases by 1 and we start a fresh BFS,
# to mark all the connected 1s as visited by changing its value to "0". 

from collections import deque
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        # BFS
        m = len(grid)
        n = len(grid[0])

        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        numIslands = 0

        # traverse
        for i in range(m):
            for j in range(n):
                if(grid[i][j] == "1"):
                    numIslands += 1
                    # we start a new BFS
                    que = deque()
                    que.append((i, j))
                    # mark it visited and we should not traverse this again
                    grid[i][j] = "0"
                    while(que):
                        r,c = que.popleft()
                        for k in range(len(dirs)):
                            nr = r + dirs[k][0]
                            nc = c + dirs[k][1]

                            # check bounds and if it is land
                            if((0 <= nr < m) and (0 <= nc < n) and (grid[nr][nc] == "1")):
                                # mark it visited and add to the queue
                                grid[nr][nc] = "0"
                                que.append((nr, nc))

        return numIslands

sol = Solution()
print("Method1: Using BFS")
print(sol.numIslands([
  ["1","1","1","1","1"],
  ["1","1","1","1","1"],
  ["1","1","1","1","1"],
  ["1","1","1","1","0"]
]))

print(sol.numIslands([
  ["0","0","0","0","0"],
  ["0","0","0","0","0"],
  ["0","0","0","0","0"],
  ["0","0","0","0","0"]
]))

print(sol.numIslands([
  ["1","1","0","1","1"],
  ["1","1","0","1","1"],
  ["0","0","1","0","1"],
  ["1","1","0","1","0"]
]))


# Method2: Using DFS
# M -- No. of Rows
# N -- No. of Cols
# Time Complexity : O(M*N) + O(M*N) = O(M*N) -- outer traversal of nodes + worst case all DFS would add to O(M*N)
# Space Complexity : O(M*N) -- In worst case DFS, we could make recursive call to all the connected nodes. Recursive stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We traverse all the nodes of the matrix. Wherever we find "1", our num of islands count increases by 1 and we start a fresh DFS,
# to mark all the connected 1s as visited by changing its value to "0".

from collections import deque
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        # BFS
        m = len(grid)
        n = len(grid[0])

        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        numIslands = 0

        def dfs(r,c, dirs):
            # check bounds and if it is land
            if((r < 0) or (r >= len(grid)) or (c < 0) or (c >= len(grid[0])) or (grid[r][c] != "1")):
                return

            # mark it visited
            grid[r][c] = "0"
            for k in range(len(dirs)):
                nr = r + dirs[k][0]
                nc = c + dirs[k][1]
                dfs(nr, nc, dirs)




        # traverse
        for i in range(m):
            for j in range(n):
                if(grid[i][j] == "1"):
                    numIslands += 1
                    # mark it visited and we should not traverse this again
                    # we start a new DFS
                    dfs(i,j, dirs)


        return numIslands

sol = Solution()
print("Method2: Using DFS")
print(sol.numIslands([
  ["1","1","1","1","1"],
  ["1","1","1","1","1"],
  ["1","1","1","1","1"],
  ["1","1","1","1","0"]
]))

print(sol.numIslands([
  ["0","0","0","0","0"],
  ["0","0","0","0","0"],
  ["0","0","0","0","0"],
  ["0","0","0","0","0"]
]))

print(sol.numIslands([
  ["1","1","0","1","1"],
  ["1","1","0","1","1"],
  ["0","0","1","0","1"],
  ["1","1","0","1","0"]
]))