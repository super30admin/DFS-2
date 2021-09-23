#Time Complexity : O(mn)
#Space Complexity : O(mn) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0:
            return 0
        q = deque()
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    q.append([i, j])
                    grid[i][j] = "0"
                    count += 1
                    while q:
                        curr = q.popleft()
                        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
                        for d in dirs:
                            r = curr[0] + d[0]
                            c = curr[1] + d[1]
                            if r>=0 and c>=0 and r<len(grid) and c<len(grid[0]) and grid[r][c] == "1":
                                q.append([r, c])
                                grid[r][c] = "0"
        return count
        