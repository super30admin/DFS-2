# Created by Aashish Adhikari at 4:35 PM 1/27/2021

'''
Time Complexity:
O( 2(m.n)) as we will reach each node just once in the nested for loop and the bfs done with reach m.n nodes in total for all (i,j) positions of the
nested for loop.

Space Complexity:
O(min(m,n)) where m and n are matrix dimensions.

'''


class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """

        from collections import deque

        if len(grid) == 0:
            return 0

        ctr = 0

        dirs = [[-1,0],[1,0], [0,-1], [0,1]]
        q = deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):

                if grid[i][j] == "1":

                    ctr += 1


                    q.append((i,j))

                    while len(q) != 0:

                        r, c = q[0][0], q[0][1]

                        for dir in dirs:

                            row = dir[0] + r
                            col = dir[1] + c


                            if row >= 0 and col >= 0 and row < len(grid) and col < len(grid[0]) and grid[row][col] == "1":

                                q.append((row, col))

                                grid[row][col] = "0"

                        q.popleft()

        return ctr









