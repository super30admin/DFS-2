"""
time complexity: O(m*n) where m and n are the dimensions of the grid
space complexity: O(m*n) in the worst case when the grid is filled with "1"s
We maintain a visited set to keep track of the cells we have already visited. 
We iterate through each cell in the grid, and whenever we encounter a "1" that has not been visited, 
we increment our island count and perform a depth-first search (DFS) to mark all connected "1"s as visited. 
The DFS explores all four possible directions (up, down, left, right) from the current cell. 
This way, we ensure that we count each island only once.
"""
from typing import List
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.dirns = [[-1,0],[0,-1],[0,1],[1,0]]
        self.visited = set()
        self.grid = grid
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1" and (i,j) not in self.visited:
                    count+=1
                    self.helper(i,j)
        return count
                
    
    def helper(self,i,j):
        self.visited.add((i,j))
        for dirn in self.dirns:
            x = i+dirn[0]
            y = j+dirn[1]
            if -1<x<len(self.grid) and -1<y<len(self.grid[0]) \
            and (x,y) not in self.visited \
            and self.grid[x][y]=="1":
                self.helper(x,y)



        