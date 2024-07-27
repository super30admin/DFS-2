#In this code, I implemented a function numIslands to count the number of islands in a given 2D grid, where '1' represents land and '0' represents water. I used a breadth-first search (BFS) approach to traverse and mark each discovered island. For each cell in the grid, if it contains '1', I initialize a queue to explore the entire island by adding the current cell's coordinates to the queue. I then repeatedly dequeue and check adjacent cells, marking each visited '1' as '0' to avoid re-visitation. This exploration continues until all connected '1's are visited, after which I increment the island count (result). The process is repeated for all cells in the grid. The time complexity of this solution is O(m×n), where m is the number of rows and n is the number of columns, since each cell is visited once. The space complexity is also O(m×n) in the worst case, due to the space needed for the queue when all cells are land.

class Solution:
	def numIslands(self, grid: List[List[str]]) -> int:

		result = 0
		rows = len(grid)
		cols = len(grid[0])

		for row in range(rows):
			for col in range(cols):

				if grid[row][col] == '1':

					queue = deque([(row , col)])

					while queue:

						r , c = queue.popleft()

						if 0 <= r < rows and 0 <= c < cols and grid[r][c] == '1':

							grid[r][c] = '0'

							queue.append((r + 1, c))
							queue.append((r - 1, c))
							queue.append((r , c + 1))
							queue.append((r , c - 1))

					result = result + 1

		return result