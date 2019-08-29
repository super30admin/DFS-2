from collections import deque
class Solution:
	def numIslands(self, grid: List[List[str]]) -> int:
		# BFS Approach
		# Space Complexity : O(mn) where m is the number of rows and n is the number of columns (have a queue for BFS)
		# Time Complexity : O(mn) where m is the number of rows and n is the number of columns (Not sure because we are iterating over the queue for every 1 element in the matrix)
		# Accepted on leetcode
		res = 0
		if len(grid) == 0:
			return res
		if len(grid[0]) == 0:
			return res
		rows = len(grid)
		columns = len(grid[0])
		for i in range(rows):
			for j in range(columns):
				if grid[i][j] == "1":
					res += 1
					queue = deque()
					queue.append([i,j])
					while len(queue) > 0:
						r, c = queue.popleft()
						if r > 0 and grid[r - 1][c] == "1":
							queue.append([r - 1, c])
							grid[r - 1][c] = "0"
						if r < rows - 1 and grid[r + 1][c] == "1":
							queue.append([r + 1, c])
							grid[r + 1][c] = "0"
						if c > 0 and grid[r][c - 1] == "1":
							queue.append([r, c - 1])
							grid[r][c - 1] = "0"
						if c < columns - 1 and grid[r][c + 1] == "1":
							queue.append([r, c + 1])
							grid[r][c + 1] = "0"
		return res