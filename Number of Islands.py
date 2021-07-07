"""
BFS Approach: Start with 1st '1' node which will be root node and continue BFS from it. Put it in queue and mark it as visited (mark it as '0') and then put its neighbors in queue and continue likewise until queue becomes empty.
Time Complexity: O(m*n)
Space Complexity: min(m,n)
"""

from collections import deque
from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid==None or len(grid)==0 or len(grid[0])==0:
            return 0

        m=len(grid)
        n=len(grid[0])
        island_counter=0
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        q=deque()
        #start with 1st '1' node and traverse from their in BFS manner
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=="1":
                    island_counter+=1 #increment island counter
                    q.append((i,j))

                while q:
                    popped=q.popleft()


                    for d in directions:
                        row=popped[0] + d[0]
                        column=popped[1] + d[1]
                        #check bounds and check if for popped cell, neighbor is also 1
                        if (row>=0 and column>=0 and row<m and column<n and grid[row][column]=="1"):
                            q.append((row,column))
                            grid[row][column]="0" #mark as visited

        return island_counter



s=Solution()
print(s.numIslands([["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
                   ))


