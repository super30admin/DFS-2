# Time Complexity :  O(mn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        if len(grid[0]) == 0:
            return int(grid[0])
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    count += 1
                    queue = []
                    queue.append((i,j))

                    while(len(queue) > 0):
                        (p,q) = queue.pop()
                        if p > 0 and grid[p-1][q] == "1":
                            queue.append((p-1,q))
                            grid[p-1][q] = "0"
                        if p < len(grid)-1 and grid[p+1][q] == "1":
                            queue.append((p+1,q))
                            grid[p+1][q] = "0"
                        if q > 0 and grid[p][q-1] == "1":
                            queue.append((p,q-1))
                            grid[p][q-1] = "0"
                        if q < len(grid[0]) - 1 and grid[p][q+1] == "1":
                            queue.append((p,q+1))
                            grid[p][q+1] = "0"
        return count