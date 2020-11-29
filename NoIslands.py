# Depth first search
# Time complexity - O(n*m) # n is the no of rows and m is the no of columns
# Space complexity - O(n*m) # worst case every cell is land
from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        n = len(grid)
        if n==0 or not grid:
            return 
        m = len(grid[0])
        
        # directions array
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        num_islands = 0
        
        st = deque()
        for r in range(n):
            for c in range(m):
                if grid[r][c]=="1":
                    st.append((r, c))
                    # increment the number of islands.
                    num_islands += 1
                    
                    # traverse
                    while st:
                        node = st.pop()
                        # mark grid location as water since it has already been visited.
                        grid[node[0]][node[1]] = "0" 
                        
                        # add the neighbors to the stack.
                        for d in dirs:
                            curr = (node[0] + d[0], node[1] + d[1])  
                            if 0 <= curr[0] < n and 0 <= curr[1] < m and grid[curr[0]][curr[1]]=="1":
                                st.append(curr)
        
        return num_islands
    
# Time complexity - O(n*m) # n is the no of rows and m is the no of columns
# Space complexity - O(n*m) 
# Did this solution run on leetcode? - yes
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        n = len(grid)
        if n==0 or not grid:
            return
        m = len(grid[0])
        
        # count the number of islands.
        numIslands = 0
        for r in range(n):
            for c in range(m):
                if grid[r][c] == "1":
                    numIslands += 1
                    grid[r][c] = "0"
                    self.recursive(grid, r, c)
        
        return numIslands
    
        
    def recursive(self, grid, r, c, dirs=[(0, 1), (1, 0), (0, -1), (-1, 0)]):
        for d in dirs:
            r1, c1 = r+d[0], c+d[1]
            if 0<= r1 < len(grid) and 0<= c1 < len(grid[0]) and grid[r1][c1]=="1":
                grid[r1][c1]="0"
                self.recursive(grid, r1, c1)
        

# Union Find solution
# Time complexity - O(nm)
# Space complexity - O(2nm) for parent and rank arrays
# Did this solution run on leetcode? - yes
class unionFind:
    def __init__(self, grid):
        n = len(grid)
        m = len(grid[0])
        self.parent = {i*m+j: i*m+j for j in range(m) for i in range(n)}
        self.rank = {i*m+j: 0 for j in range(m) for i in range(n)}
        self.counts = 0 
        for i in range(n):
            for j in range(m):
                if grid[i][j] == "1":
                    # keep the count of cells which are land. Assuming each land is separate.
                    self.counts += 1    
    
    # union by rank
    def union(self, x, y):
        # find parents of the nodes
        parent_x = self.find(x)
        parent_y = self.find(y)
        
        if parent_x != parent_y:
            if self.rank[parent_x] > self.rank[parent_y]:
                self.parent[parent_y] = parent_x
            elif self.rank[parent_x] < self.rank[parent_y]:
                self.parent[parent_x] = parent_y
            else:
                self.parent[parent_y] = parent_x
                self.rank[parent_x] += 1
            # decrement the count since the two cells have been combined. Combine the lands.
            self.counts -= 1 

    # path compression
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        n = len(grid)
        if not grid or n==0:
            return 
        m = len(grid[0])
        # directions array
        dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        
        uf = unionFind(grid)
        for r in range(n):
            for c in range(m):
                if grid[r][c] == "1":
                    grid[r][c] = 0
                    # check for all neighboring nodes to the current node.
                    for d in dirs:
                        r1 = r+d[0]
                        c1 = c+d[1]
                        if 0 <= r1 < n and 0<= c1 < m and grid[r1][c1]=="1":
                            uf.union(r*m+c, r1*m+c1)
        
        return uf.counts

        