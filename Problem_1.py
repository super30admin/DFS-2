'''
200 Number of Islands
https://leetcode.com/problems/number-of-islands/description/

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

Solution:
1. BFS with mutation of grid matrix
https://youtu.be/2AZvtk6UThs?t=3897

Time: O(MN), Space: O(MN)

2. BFS without mutation of grid matrix (use boolean visited matrix)
https://youtu.be/2AZvtk6UThs?t=3897

Time: O(MN), Space: O(MN)

3. DFS with mutation of grid matrix
Time: O(MN), Space: O(MN)
'''

from collections import deque
from copy import deepcopy as dcp

def num_islands_bfs_1(grid):
    '''
    BFS with mutation of grid matrix
    '''
    def bfs(grid, start_cell):
        q = deque()
        count_1s = 0
        q.append(start_cell)
        while q:
            curr_cell = q.popleft()
            x, y = curr_cell[0], curr_cell[1]
            grid[x][y] = "-1"
            count_1s += 1
            for delta in deltas: # explore all child nodes
                x_, y_ = x + delta[0], y + delta[1]
                if 0 <= x_ <= M-1 and 0 <= y_ <= N-1 and grid[x_][y_] == "1":
                    q.append((x_,y_))
        return count_1s

    if not grid:
            return 0
    M = len(grid)
    N = len(grid[0])
    deltas = [[-1,0],[1,0],[0,-1],[0,1]]
    count_islands = 0
    for i in range(M):
        for j in range(N):
            count_1s = 0
            if grid[i][j] == "1":
                start_cell = (i,j)
                count_1s = bfs(grid, start_cell)
                if count_1s > 0:
                    count_islands += 1
                #print(f"start cell = {(i,j)}, 1s = {count_1s}, islands = {count_islands}")
    return count_islands

def num_islands_bfs_2(grid):
    '''
    BFS without mutation of grid matrix (use boolean visited matrix)
    '''
    def bfs(grid, start_cell):
        q = deque()
        count_1s = 0
        q.append(start_cell)
        while q:
            curr_cell = q.popleft()
            x, y = curr_cell[0], curr_cell[1]
            visited[x][y] = True
            count_1s += 1
            for delta in deltas: # explore all child nodes
                x_, y_ = x + delta[0], y + delta[1]
                if 0 <= x_ <= M-1 and 0 <= y_ <= N-1 and not visited[x_][y_]:
                    q.append((x_,y_))
        return count_1s

    if not grid:
            return 0
    M = len(grid)
    N = len(grid[0])
    visited = [[False]*N for _ in range(M)]
    for i in range(M):
        for j in range(N):
            if grid[i][j] != "1":
                visited[i][j] = True

    deltas = [[-1,0],[1,0],[0,-1],[0,1]]
    count_islands = 0
    for i in range(M):
        for j in range(N):
            count_1s = 0
            if not visited[i][j]:
                start_cell = (i,j)
                count_1s = bfs(grid, start_cell)
                if count_1s > 0:
                    count_islands += 1
                #print(f"start cell = {(i,j)}, 1s = {count_1s}, islands = {count_islands}")
    return count_islands

def num_islands_dfs(grid):
    def dfs(grid, start_cell, count_1s):
        x, y = start_cell
        grid[x][y] = "-1"
        count_1s += 1
        for delta in deltas: # explore all child nodes
                x_, y_ = x + delta[0], y + delta[1]
                if 0 <= x_ <= M-1 and 0 <= y_ <= N-1 and grid[x_][y_] == "1":
                    dfs(grid, (x_,y_), count_1s)
        return count_1s

    if not grid:
        return 0
    M = len(grid)
    N = len(grid[0])
    deltas = [[-1,0],[1,0],[0,-1],[0,1]]
    count_islands = 0
    for i in range(M):
        for j in range(N):
            count_1s = 0
            if grid[i][j] == "1":
                start_cell = (i,j)
                count_1s = dfs(grid, start_cell, 0)
                if count_1s > 0:
                    count_islands += 1
                #print(f"start cell = {(i,j)}, 1s = {count_1s}, islands = {count_islands}")
    return count_islands

def num_islands(grid, method='bfs_1'):
    if method ==  'bfs_1':
        return num_islands_bfs_1(grid)
    elif method == 'bfs_2':
        return num_islands_bfs_2(grid)
    elif method == 'dfs':
        return num_islands_dfs(grid)


def run_num_islands():
    tests = [([["1","1","1","1","0"],
               ["1","1","0","1","0"],
               ["1","1","0","0","0"],
               ["0","0","0","0","0"]],
               1),
             ([["1","1","0","0","0"],
               ["1","1","0","0","0"],
               ["0","0","1","0","0"],
               ["0","0","0","1","1"]],
               3),
    ]
    for test in tests:
        grid, ans = test[0], test[1]
        print(f"\nGrid = {grid}")
        for method in ['bfs_1','bfs_2','dfs']:
            num = num_islands(dcp(grid), method)
            print(f"Method {method}: Number of islands in grid = {num}")
            print(f"Pass: {ans == num}")

run_num_islands()