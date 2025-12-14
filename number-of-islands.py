'''
Docstring for number-of-islands
TC: O(m * n)
SC: O(min(m, n))
Leetcode: problem solved successfully

'''
class Solution:
    def __init__(self):
        self.dirs = [[0,1], [1,0], [-1,0], [0,-1]]

    def numIslands(self, grid):
        m = len(grid)
        n = len(grid[0])
        q = []
        count = 0
        for i in range(m):
            for j in range(n):
                # check for every 1s in the matrix
                if grid[i][j] == '1':
                    q.append([i, j])
                    # inc by 1.
                    count += 1
                    while len(q) > 0:
                        curr = q.pop(0)
                        for dir in self.dirs:
                            r = curr[0] + dir[0]
                            c = curr[1] + dir[1]
                            # check out of bounce errors and only let if the square is 1.
                            if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == "1":
                                grid[r][c] = 0
                                q.append([r, c])
        return count


grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
s = Solution()
print(s.numIslands(grid))
grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
s = Solution()
print(s.numIslands(grid))