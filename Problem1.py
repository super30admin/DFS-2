# Used BFS and DFS to check the 1st and convert them to 2's and visit their neighbours with. If not found count +1
# TC: O(m x n) -> BFS and DFS
# SC: O(m + n) for BFS, O(m x n) for DFS
# Yes this worked in leetcode


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]:
            return 0
        rows, cols = len(grid), len(grid[0])
        visit = set()
        num_islands = 0

        def bfs(r, c):
            q = collections.deque()
            visit.add((r, c))
            q.append((r, c))

            while q:
                row, col = q.popleft()
                directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

                for dr, dc in directions:
                    r, c = row + dr, col + dc
                    if r in range(rows) and c in range(cols) and grid[r][c] == "1" and (r, c) not in visit:
                        q.append((r, c))
                        visit.add((r, c))

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1" and (r, c) not in visit:
                    bfs(r, c)
                    num_islands += 1
        return num_islands


        # def flood_fill(r, c):
        #     if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] == '0':
        #         return
        #     grid[r][c] = '0'

        #     flood_fill(r + 1, c)  # Down
        #     flood_fill(r - 1, c)  # Up
        #     flood_fill(r, c + 1)  # Right
        #     flood_fill(r, c - 1)  # Left

        # for r in range(rows):
        #     for c in range(cols):
        #         if grid[r][c] == '1':
        #             num_islands += 1
        #             flood_fill(r, c)
        # return num_islands
