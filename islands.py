# Time Complexity :
# O(M*N)

# Space Complexity :
# O(M*N)

# Did this code successfully run on Leetcode :
#Yes

#We do BFS over every location where we find a 1. Every time our queue is empty, we increase our count by 1 - this happens only when there are no connected components left for the element we started from
#We also ensure we don't visited an already visited node hence our time complexity remains O(M*N)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.queue = []
        self.visited = [[0 for j in range(len(grid[0]))] for i in range(len(grid))]
        count = 0
        neighbours = [(1,0),(-1,0),(0,1),(0,-1)]
        for i in range(0,len(grid)):
            for j in range(0,len(grid[0])):
                if self.visited[i][j] == 1 :
                    continue
                if grid[i][j] == "0":
                    continue
                count += 1
                self.queue.append((i,j))
                while (len(self.queue) != 0):
                    curr_elem = self.queue.pop(0)
                    cr = curr_elem[0]
                    cc = curr_elem[1]
                    for neighbour in neighbours:
                        x = cr + neighbour[0]
                        y = cc + neighbour[1]
                        if self.is_valid_coord(x,y,len(grid),len(grid[0])) and grid[x][y] == "1" and self.visited[x][y] == 0:
                            self.queue.append((x,y))
                            self.visited[x][y] = 1
        return count

    def is_valid_coord(self,x,y,size_x,size_y):
        if x < 0 or x >= size_x :
            return False
        if y < 0 or y >= size_y :
            return False
        return True


