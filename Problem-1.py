'''
    Time Complexity: O(mn)
    Space Complexity: O(min(m,n))
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

        queue = deque()
        count = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    grid[i][j] = "-1"
                    queue.append((i, j))

                    while(len(queue)):
                        cell = queue.popleft()

                        for dir in directions:
                            r = cell[0] + dir[0]
                            c = cell[1] + dir[1]

                            if 0 <= r < m and 0 <= c < n:
                                if grid[r][c] == "1":
                                    grid[r][c] = "-1"
                                    queue.append((r, c))
                    
                    count += 1

        return count


        