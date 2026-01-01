"""
We use bfs to check all the surrounding cells to '1' and then keep a track of it in a set, if the '1' is not in set, it tells us that a new island exists and hence increase the 
count. Then have the normal bfs where in we add to the queue and then process 4 directions wrt to the currentr and current c and then appened it to the q and to the set as well.
TC is O(mxn) and SC is o(Mxn) in worst case.
"""


class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        rows = len(grid)
        cols = len(grid[0])
        visited = set()
        count = 0
        q = collections.deque()

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1' and (r,c) not in visited:
                    count += 1
                    visited.add((r,c))
                    q.append((r,c))

                    while q:
                        cr,cc = q.popleft()
                        for dr, dc in {(1,0), (-1, 0), (0, 1), (0, -1)}:
                            nr, nc = cr + dr, cc + dc
                            if (0 <= nr < rows and
                                 0 <= nc < cols and
                                 grid[nr][nc] == '1' and
                                 (nr, nc) not in visited):
                                 visited.add((nr, nc))
                                 q.append((nr, nc))
        return count


        